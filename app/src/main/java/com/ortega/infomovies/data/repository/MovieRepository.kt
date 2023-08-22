package com.ortega.infomovies.data.repository

import com.ortega.infomovies.data.datasource.remote.MovieApi
import javax.inject.Inject

class MovieRepository @Inject constructor(private val movieAPI: MovieApi) {

    suspend fun getPopularMovies(page: Int, language: String) =
        movieAPI.getPopularMovies(page = page, language = language)

    suspend fun getRatedMovies(page: Int, language: String) =
        movieAPI.getRatedMovies(page = page, language = language)

    suspend fun getUpcomingMovies(page: Int, language: String) =
        movieAPI.getUpcomingMovies(page = page, language = language)

    suspend fun getRecommendedMovies(movieId: Int, page: Int, language: String) =
        movieAPI.getRecommendedMovies(movieId = movieId, page = page, language = language)


    suspend fun getDetailMovies(movieId: Int, language: String) =
        movieAPI.getDetailMovies(movieId = movieId, language = language)


    suspend fun searchMovies(query: String, page: Int, language: String) =
        movieAPI.searchMovies(query = query, page = page, language = language)


}