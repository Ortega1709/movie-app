package com.ortega.infomovies.domain.mappers

import com.ortega.infomovies.domain.entity.PopularMovieEntity
import com.ortega.infomovies.domain.model.Movie

// to PopularMovieEntity
fun Movie.toPopularMovieEntity(): PopularMovieEntity {
    return PopularMovieEntity(
        id, posterPath, releaseDate, title, voteAverage, voteCount
    )
}

// to Movie
fun PopularMovieEntity.toMovie(): Movie {
    return Movie(
        id, posterPath, releaseDate, title, voteAverage, voteCount
    )
}