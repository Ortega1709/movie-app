package com.ortega.infomovies.data.datasource.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ortega.infomovies.data.datasource.local.dao.PopularMovieDao
import com.ortega.infomovies.data.datasource.local.dao.RatedMovieDao
import com.ortega.infomovies.data.datasource.local.dao.RecommendedMovieDao
import com.ortega.infomovies.data.datasource.local.dao.UpcomingMovieDao
import com.ortega.infomovies.domain.model.PopularMovie
import com.ortega.infomovies.domain.model.RatedMovie
import com.ortega.infomovies.domain.model.RecommendedMovie
import com.ortega.infomovies.domain.model.UpcomingMovie

@Database(
    entities = [PopularMovie::class, RatedMovie::class, UpcomingMovie::class, RecommendedMovie::class],
    version = 1
)
abstract class MovieDatabase : RoomDatabase() {

    abstract fun popularMovieDao(): PopularMovieDao
    abstract fun ratedMovieDao(): RatedMovieDao
    abstract fun upcomingMovieDao(): UpcomingMovieDao
    abstract fun recommendedMovieDao(): RecommendedMovieDao

}