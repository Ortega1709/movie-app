package com.ortega.infomovies.data.datasource.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.ortega.infomovies.domain.model.PopularMovie

@Dao
interface PopularMovieDao {

    @Upsert
    suspend fun upsertMovies(popularMovies: List<PopularMovie>)

    @Query("SELECT * FROM popular_movie_table")
    fun getAllMovies(): PagingSource<Int, PopularMovie>

    @Query("DELETE FROM popular_movie_table")
    suspend fun deleteAllMovies()

}