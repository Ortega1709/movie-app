package com.ortega.infomovies.domain.response

import com.ortega.infomovies.domain.model.PopularMovie

data class PopularMovieResponse(
    val results: List<PopularMovie>
)
