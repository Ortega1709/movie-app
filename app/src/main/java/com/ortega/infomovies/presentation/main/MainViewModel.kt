package com.ortega.infomovies.presentation.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.ortega.infomovies.data.repository.MovieRepository
import com.ortega.infomovies.domain.entity.PopularMovieEntity
import com.ortega.infomovies.domain.entity.RatedMovieEntity
import com.ortega.infomovies.domain.mappers.toMovie
import com.ortega.infomovies.domain.model.Movie
import com.ortega.infomovies.util.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val pager: Pager<Int, RatedMovieEntity>
): ViewModel() {


    var ratedMoviePaging: Flow<PagingData<Movie>> = pager.flow.map { paging -> paging.map { it.toMovie() } }.cachedIn(viewModelScope)

    fun getPopularMovies() {
        ratedMoviePaging = pager.flow.map { paging -> paging.map { it.toMovie() } }.cachedIn(viewModelScope)
    }



}