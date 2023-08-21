package com.ortega.infomovies.data.repository

import android.content.Context
import com.ortega.infomovies.data.datasource.remote.MovieAPI
import com.ortega.infomovies.util.Result
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MovieRepository @Inject constructor(private val movieAPI: MovieAPI) {

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