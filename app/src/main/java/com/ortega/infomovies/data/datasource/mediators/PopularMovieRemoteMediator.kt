package com.ortega.infomovies.data.datasource.mediators

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.ortega.infomovies.data.datasource.local.MovieDatabase
import com.ortega.infomovies.data.datasource.remote.MovieApi
import com.ortega.infomovies.domain.model.PopularMovie
import com.ortega.infomovies.domain.remoteKeys.PopularMovieRemoteKeys
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@OptIn(ExperimentalPagingApi::class)
class PopularMovieRemoteMediator @Inject constructor(
    private val movieApi: MovieApi,
    private val movieDatabase: MovieDatabase
) : RemoteMediator<Int, PopularMovie>() {

    private val popularMovieDao = movieDatabase.popularMovieDao()
    private val popularMovieRemoteKeysDao = movieDatabase.popularRemoteKeysDao()

    override suspend fun load(
        loadType: LoadType, state: PagingState<Int, PopularMovie>
    ): MediatorResult {

        return try {

            val currentPage = when (loadType) {
                LoadType.REFRESH -> {
                    val remoteKeys = getRemoteKeyClosestToCurrentPosition(state)
                    remoteKeys?.nextPage?.minus(1) ?: 1
                }

                LoadType.PREPEND -> {
                    val remoteKeys = getRemoteKeyForFirstItem(state)
                    val previousPage = remoteKeys?.previousPage ?: return MediatorResult.Success(
                        endOfPaginationReached = remoteKeys != null
                    )
                    previousPage
                }

                LoadType.APPEND -> {
                    val remoteKeys = getRemoteKeyForLastItem(state)
                    val nextPage = remoteKeys?.nextPage ?: return MediatorResult.Success(
                        endOfPaginationReached = remoteKeys != null
                    )
                    nextPage
                }
            }

            val popularMovieResponse =
                movieApi.getPopularMovies(page = currentPage, language = "fr-FR")
            val endOfPaginationReached = popularMovieResponse.results.isEmpty()

            val previousPage = if (currentPage == 1) null else currentPage - 1
            val nextPage = if (endOfPaginationReached) null else currentPage + 1

            movieDatabase.withTransaction {

                if (loadType == LoadType.REFRESH) {
                    popularMovieDao.deleteAllMovies()
                    popularMovieRemoteKeysDao.deleteAllRemoteKeys()
                }

                val keys = popularMovieResponse.results.map {
                    PopularMovieRemoteKeys(
                        id = it.id,
                        previousPage = previousPage,
                        nextPage = nextPage
                    )
                }

                popularMovieRemoteKeysDao.upsertRemoteKeys(remoteKeys = keys)
                popularMovieDao.upsertMovies(popularMovies = popularMovieResponse.results)

            }

            MediatorResult.Success(endOfPaginationReached = endOfPaginationReached)

        } catch (e: IOException) {
            MediatorResult.Error(e)
        } catch (e: HttpException) {
            MediatorResult.Error(e)
        }

    }

    private suspend fun getRemoteKeyClosestToCurrentPosition(
        state: PagingState<Int, PopularMovie>
    ): PopularMovieRemoteKeys? {

        return state.anchorPosition?.let { position ->
            state.closestItemToPosition(position)?.id?.let { id ->
                popularMovieRemoteKeysDao.getRemoteKeys(id)
            }
        }

    }

    private suspend fun getRemoteKeyForFirstItem(
        state: PagingState<Int, PopularMovie>
    ): PopularMovieRemoteKeys? {

        return state.pages.firstOrNull { it.data.isNotEmpty() }?.data
            ?.firstOrNull()?.let { popularMovie ->
                popularMovieRemoteKeysDao.getRemoteKeys(popularMovie.id)
            }

    }

    private suspend fun getRemoteKeyForLastItem(
        state: PagingState<Int, PopularMovie>
    ): PopularMovieRemoteKeys? {

        return state.pages.lastOrNull { it.data.isNotEmpty() }?.data
            ?.lastOrNull()?.let { popularMovie ->
                popularMovieRemoteKeysDao.getRemoteKeys(popularMovie.id)
            }

    }


}