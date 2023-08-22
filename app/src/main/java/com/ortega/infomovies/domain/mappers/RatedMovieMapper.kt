package com.ortega.infomovies.domain.mappers

import com.ortega.infomovies.domain.entity.PopularMovieEntity
import com.ortega.infomovies.domain.entity.RatedMovieEntity
import com.ortega.infomovies.domain.model.Movie

// to PopularMovieEntity
fun Movie.toRatedMovieEntity(): RatedMovieEntity {
    return RatedMovieEntity(
        id, posterPath, releaseDate, title, voteAverage, voteCount
    )
}

// to Movie
fun RatedMovieEntity.toMovie(): Movie {
    return Movie(
        id, posterPath, releaseDate, title, voteAverage, voteCount
    )
}