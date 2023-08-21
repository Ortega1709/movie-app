package com.ortega.infomovies.data.datasource.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ortega.infomovies.domain.entity.PopularMovieEntity
import com.ortega.infomovies.domain.entity.RatedMovieEntity

@Database(
    entities = [
        PopularMovieEntity::class,
        RatedMovieEntity::class
               ],
    version = 1
)
abstract class MovieDB: RoomDatabase() {

    abstract fun movieDAO(): MovieDAO

}