package com.ortega.infomovies.data.datasource.remote.mediators

import android.content.Context
import android.content.SharedPreferences
import androidx.activity.contextaware.ContextAware
import androidx.compose.ui.text.style.TextDirection.Companion.Content
import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.ortega.infomovies.data.datasource.local.MovieDB
import com.ortega.infomovies.data.repository.MovieRepository
import com.ortega.infomovies.domain.entity.PopularMovieEntity
import com.ortega.infomovies.domain.mappers.toPopularMovieEntity
import com.ortega.infomovies.util.Constants
import com.ortega.infomovies.util.PreferencesManager
import kotlinx.coroutines.delay
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@OptIn(ExperimentalPagingApi::class)
class PopularMovieRemoteMediator @Inject constructor(
    private val movieDB: MovieDB,
    private val movieRepository: MovieRepository,
) : RemoteMediator<Int, PopularMovieEntity>() {

    //private val language = PreferencesManager(context).getSetting("language", "fr-FR")


    override suspend fun load(
        loadType: LoadType, state: PagingState<Int, PopularMovieEntity>
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

            val movies = movieRepository.getPopularMovies(page = key, language = "fr-FR").results

            movieDB.withTransaction {
                if (loadType == LoadType.REFRESH) {
                    movieDB.movieDAO().clearPopularMovies()
                }

                val movieEntities = movies.map { it.toPopularMovieEntity() }
                movieDB.movieDAO().upsertPopularMovie(movieEntities)
            }

            MediatorResult.Success(movies.isEmpty())

        } catch (e: IOException) {
            MediatorResult.Error(e)
        } catch (e: HttpException) {
            MediatorResult.Error(e)
        }

    }


}