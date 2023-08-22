package com.ortega.infomovies.domain.response

import com.ortega.infomovies.domain.model.RatedMovie

data class RatedMovieResponse(
    val results: List<RatedMovie>
)
