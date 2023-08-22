package com.ortega.infomovies.data.datasource.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.ortega.infomovies.domain.model.PopularMovie
import com.ortega.infomovies.domain.model.UpcomingMovie

@Dao
interface UpcomingMovieDao {

    @Upsert
    suspend fun upsertMovies(upcomingMovies: List<UpcomingMovie>)

    @Query("SELECT * FROM upcoming_movie_table")
    fun getAllMovies(): PagingSource<Int, UpcomingMovie>

    @Query("DELETE FROM upcoming_movie_table")
    suspend fun deleteAllMovies()

}