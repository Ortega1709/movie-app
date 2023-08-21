package com.ortega.infomovies.domain.response

import com.ortega.infomovies.domain.model.Movie

data class MovieResponse(
    val results: List<Movie>
)
