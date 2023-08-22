package com.ortega.infomovies.data.datasource.remote.mediators


import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.ortega.infomovies.data.datasource.local.MovieDB
import com.ortega.infomovies.data.repository.MovieRepository
import com.ortega.infomovies.domain.entity.RatedMovieEntity
import com.ortega.infomovies.domain.mappers.toRatedMovieEntity
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@OptIn(ExperimentalPagingApi::class)
class RatedMovieRemoteMediator @Inject constructor(
    private val movieDB: MovieDB,
    private val movieRepository: MovieRepository,
) : RemoteMediator<Int, RatedMovieEntity>() {

    //private val language = PreferencesManager(context).getSetting("language", "fr-FR")


    override suspend fun load(
        loadType: LoadType, state: PagingState<Int, RatedMovieEntity>
    ): MediatorResult {

        return try {

            val key = when (loadType) {
                LoadType.REFRESH -> 1
                LoadType.PREPEND -> return MediatorResult.Success(true)
                LoadType.APPEND -> {
                    val lItem = state.lastItemOrNull()
                    if (lItem == null) {
                        1
                    } else {
                        (lItem.id / state.config.pageSize) + 1
                    }
                }
            }

            val movies = movieRepository.getRatedMovies(page = key, language = "fr-FR").results

            movieDB.withTransaction {
                if (loadType == LoadType.REFRESH) {
                    movieDB.movieDAO().clearRatedMovies()
                }

                val movieEntities = movies.map { it.toRatedMovieEntity() }
                movieDB.movieDAO().upsertRatedMovie(movieEntities)
            }

            MediatorResult.Success(movies.isEmpty())

        } catch (e: IOException) {
            MediatorResult.Error(e)
        } catch (e: HttpException) {
            MediatorResult.Error(e)
        }

    }


}