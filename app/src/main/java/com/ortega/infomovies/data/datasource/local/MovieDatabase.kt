package com.ortega.infomovies.data.datasource.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ortega.infomovies.data.datasource.local.dao.PopularMovieDao
import com.ortega.infomovies.data.datasource.local.dao.PopularRemoteKeysDao
import com.ortega.infomovies.data.datasource.local.dao.RatedMovieDao
import com.ortega.infomovies.data.datasource.local.dao.RatedRemoteKeysDao
import com.ortega.infomovies.data.datasource.local.dao.RecommendedMovieDao
import com.ortega.infomovies.data.datasource.local.dao.RecommendedRemoteKeysDao
import com.ortega.infomovies.data.datasource.local.dao.UpcomingMovieDao
import com.ortega.infomovies.domain.model.PopularMovie
import com.ortega.infomovies.domain.model.RatedMovie
import com.ortega.infomovies.domain.model.RecommendedMovie
import com.ortega.infomovies.domain.model.UpcomingMovie
import com.ortega.infomovies.domain.remoteKeys.PopularRemoteKeys
import com.ortega.infomovies.domain.remoteKeys.RatedRemoteKeys
import com.ortega.infomovies.domain.remoteKeys.RecommendedRemoteKeys
import com.ortega.infomovies.domain.remoteKeys.UpcomingRemoteKeys

@Database(
    entities = [
        PopularMovie::class,
        RatedMovie::class,
        UpcomingMovie::class,
        RecommendedMovie::class,
        PopularRemoteKeys::class,
        RatedRemoteKeys::class,
        UpcomingRemoteKeys::class,
        RecommendedRemoteKeys::class],
    version = 1
)
abstract class MovieDatabase : RoomDatabase() {

    abstract fun popularMovieDao(): PopularMovieDao
    abstract fun ratedMovieDao(): RatedMovieDao
    abstract fun upcomingMovieDao(): UpcomingMovieDao
    abstract fun recommendedMovieDao(): RecommendedMovieDao

    abstract fun popularRemoteKeysDao(): PopularRemoteKeysDao
    abstract fun ratedRemoteKeysDao(): RatedRemoteKeysDao
    abstract fun upcomingRemoteKeysDao(): UpcomingRemoteKeys
    abstract fun recommendedRemoteKeysDao(): RecommendedRemoteKeysDao



}