package com.ortega.infomovies.data.datasource.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.ortega.infomovies.domain.model.PopularMovie
import com.ortega.infomovies.domain.model.RatedMovie

@Dao
interface RatedMovieDao {

    @Upsert
    suspend fun upsertMovies(ratedMovies: List<RatedMovie>)

    @Query("SELECT * FROM rated_movie_table")
    fun getAllMovies(): PagingSource<Int, RatedMovie>

    @Query("DELETE FROM rated_movie_table")
    suspend fun deleteAllMovies()

}