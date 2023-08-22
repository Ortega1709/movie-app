package com.ortega.infomovies.data.datasource.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.ortega.infomovies.domain.model.RatedMovie
import com.ortega.infomovies.domain.model.RecommendedMovie

@Dao
interface RecommendedMovieDao {

    @Upsert
    suspend fun upsertMovies(recommendedMovie: List<RecommendedMovie>)

    @Query("SELECT * FROM recommended_movie_table")
    fun getAllMovies(): PagingSource<Int, RecommendedMovie>

    @Query("DELETE FROM recommended_movie_table")
    suspend fun deleteAllMovies()

}