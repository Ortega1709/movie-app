package com.ortega.infomovies.domain.response

import com.ortega.infomovies.domain.model.RecommendedMovie

data class RecommendedMovieResponse(
    val results: List<RecommendedMovie>
)
