package com.ortega.infomovies.domain.response

import com.ortega.infomovies.domain.model.UpcomingMovie

data class UpcomingMovieResponse(
    val results: List<UpcomingMovie>
)
