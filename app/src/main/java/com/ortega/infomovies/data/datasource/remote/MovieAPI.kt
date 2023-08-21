package com.ortega.infomovies.data.datasource.remote

import com.ortega.infomovies.domain.model.Movie
import com.ortega.infomovies.domain.response.MovieResponse
import com.ortega.infomovies.util.Constants.GET_DETAIL_MOVIES
import com.ortega.infomovies.util.Constants.GET_POPULAR_MOVIES
import com.ortega.infomovies.util.Constants.GET_RATED_MOVIES
import com.ortega.infomovies.util.Constants.GET_RECOMMENDED_MOVIES
import com.ortega.infomovies.util.Constants.GET_UPCOMING_MOVIES
import com.ortega.infomovies.util.Constants.SEARCH_MOVIES
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieAPI {

    @GET(GET_POPULAR_MOVIES)
    suspend fun getPopularMovies(
        @Query("page") page: Int,
        @Query("language") language: String
    ): MovieResponse

    @GET(GET_RATED_MOVIES)
    suspend fun getRatedMovies(
        @Query("page") page: Int,
        @Query("language") language: String
    ): MovieResponse

    @GET(GET_UPCOMING_MOVIES)
    suspend fun getUpcomingMovies(
        @Query("page") page: Int,
        @Query("language") language: String
    ): MovieResponse

    @GET(GET_RECOMMENDED_MOVIES)
    suspend fun getRecommendedMovies(
        @Path("movie_id") movieId: Int,
        @Query("page") page: Int,
        @Query("language") language: String
    ): MovieResponse

    @GET(GET_DETAIL_MOVIES)
    suspend fun getDetailMovies(
        @Path("movie_id") movieId: Int,
        @Query("language") language: String
    )

    @GET(SEARCH_MOVIES)
    suspend fun searchMovies(
        @Query("query") query: String,
        @Query("page") page: Int,
        @Query("language") language: String
    )



}