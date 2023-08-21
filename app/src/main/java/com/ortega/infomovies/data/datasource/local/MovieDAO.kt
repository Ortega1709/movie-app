package com.ortega.infomovies.data.datasource.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.ortega.infomovies.domain.entity.PopularMovieEntity
import com.ortega.infomovies.domain.entity.RatedMovieEntity

@Dao
interface MovieDAO {

    // Popular movies
    @Upsert
    suspend fun upsertPopularMovie(popularMovieEntity: List<PopularMovieEntity>)

    @Query("SELECT * FROM popularMovie")
    fun pagingSourcePopularMovie(): PagingSource<Int, PopularMovieEntity>

    @Query("DELETE FROM popularMovie")
    suspend fun clearPopularMovies()

    // Rated movies
    @Upsert
    suspend fun upsertRatedMovie(ratedMovieEntity: List<RatedMovieEntity>)

    @Query("SELECT * FROM ratedMovie")
    fun pagingSourceRatedMovie(): PagingSource<Int, RatedMovieEntity>

    @Query("DELETE FROM ratedMovie")
    suspend fun clearRatedMovies()

}