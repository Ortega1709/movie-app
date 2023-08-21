package com.ortega.infomovies.domain.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "ratedMovie"
)
data class RatedMovieEntity(
    @PrimaryKey
    val id: Int,
    val posterPath: String,
    val releaseDate: String,
    val title: String,
    val voteAverage: Double,
    val voteCount: Int
)