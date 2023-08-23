package com.ortega.infomovies.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.ortega.infomovies.data.datasource.local.MovieDatabase
import com.ortega.infomovies.data.datasource.mediators.PopularMovieRemoteMediator
import com.ortega.infomovies.data.datasource.mediators.RatedMovieRemoteMediator
import com.ortega.infomovies.data.datasource.mediators.UpcomingMovieRemoteMediator
import com.ortega.infomovies.data.datasource.remote.MovieApi
import com.ortega.infomovies.domain.model.PopularMovie
import com.ortega.infomovies.domain.model.RatedMovie
import com.ortega.infomovies.domain.model.UpcomingMovie
import com.ortega.infomovies.util.Constants.PER_PAGE
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@OptIn(ExperimentalPagingApi::class)
class MovieRepository @Inject constructor(
    private val movieAPI: MovieApi,
    private val movieDatabase: MovieDatabase
) {


    fun getAllPopularMovies(): Flow<PagingData<PopularMovie>> {

        val popularMovieSourceFactory = { movieDatabase.popularMovieDao().getAllMovies() }
        return Pager(
            config = PagingConfig(pageSize = PER_PAGE),
            remoteMediator = PopularMovieRemoteMediator(
                movieApi = movieAPI,
                movieDatabase = movieDatabase
            ),
            pagingSourceFactory = popularMovieSourceFactory
        ).flow

    }

    fun getAllRatedMovies(): Flow<PagingData<RatedMovie>> {

        val ratedMovieSourceFactory = { movieDatabase.ratedMovieDao().getAllMovies() }
        return Pager(
            config = PagingConfig(pageSize = PER_PAGE),
            remoteMediator = RatedMovieRemoteMediator(
                movieApi = movieAPI,
                movieDatabase = movieDatabase
            ),
            pagingSourceFactory = ratedMovieSourceFactory
        ).flow

    }

    fun getAllUpcomingMovies(): Flow<PagingData<UpcomingMovie>> {

        val upcomingMovieSourceFactory = { movieDatabase.upcomingMovieDao().getAllMovies() }
        return Pager(
            config = PagingConfig(pageSize = PER_PAGE),
            remoteMediator = UpcomingMovieRemoteMediator(
                movieApi = movieAPI,
                movieDatabase = movieDatabase
            ),
            pagingSourceFactory = upcomingMovieSourceFactory
        ).flow

    }

}