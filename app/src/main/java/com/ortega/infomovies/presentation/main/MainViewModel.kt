package com.ortega.infomovies.presentation.main

import androidx.lifecycle.ViewModel
import androidx.paging.ExperimentalPagingApi
import com.ortega.infomovies.data.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
@ExperimentalPagingApi
class MainViewModel
@Inject constructor(
    movieRepository: MovieRepository,
): ViewModel() {

    val popularMovies = movieRepository.getAllPopularMovies()
    val ratedMovies = movieRepository.getAllRatedMovies()
    val upcomingMovies = movieRepository.getAllUpcomingMovies()

}