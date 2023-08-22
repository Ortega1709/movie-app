package com.ortega.infomovies.di

import android.content.Context
import androidx.room.Room
import com.ortega.infomovies.data.datasource.local.MovieDatabase
import com.ortega.infomovies.util.Constants.MOVIE_DATABASE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideBeerDB(@ApplicationContext context: Context): MovieDatabase {
        return Room.databaseBuilder(
            context = context,
            klass = MovieDatabase::class.java,
            name = MOVIE_DATABASE
        ).build()
    }

}