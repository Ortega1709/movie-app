package com.ortega.infomovies.data.datasource.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ortega.infomovies.domain.model.UpcomingMovie
import com.ortega.infomovies.domain.remoteKeys.PopularMovieRemoteKeys
import com.ortega.infomovies.domain.remoteKeys.RatedMovieRemoteKeys
import com.ortega.infomovies.domain.remoteKeys.RecommendedMovieRemoteKeys
import com.ortega.infomovies.domain.remoteKeys.UpcomingMovieRemoteKeys

@Database(
    entities = [
        PopularMovie::class,
        RatedMovie::class,
        UpcomingMovie::class,
        RecommendedMovie::class,
        PopularMovieRemoteKeys::class,
        RatedMovieRemoteKeys::class,
        UpcomingMovieRemoteKeys::class,
        RecommendedMovieRemoteKeys::class],
    version = 1
)
abstract class MovieDatabase : RoomDatabase() {

    abstract fun popularMovieDao(): PopularMovieDao
    abstract fun ratedMovieDao(): RatedMovieDao
    abstract fun upcomingMovieDao(): UpcomingMovieDao
    abstract fun recommendedMovieDao(): RecommendedMovieDao

    abstract fun popularMovieRemoteKeysDao(): PopularMovieRemoteKeysDao
    abstract fun ratedMovieRemoteKeysDao(): RatedMovieRemoteKeysDao
    abstract fun upcomingMovieRemoteKeysDao(): UpcomingMovieRemoteKeysDao
    abstract fun recommendedMovieRemoteKeysDao(): RecommendedMovieRemoteKeysDao



}