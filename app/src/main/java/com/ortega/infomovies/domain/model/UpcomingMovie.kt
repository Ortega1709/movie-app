package com.ortega.infomovies.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.ortega.infomovies.util.Constants.UPCOMING_MOVIE_TABLE

@Entity(tableName = UPCOMING_MOVIE_TABLE)
data class UpcomingMovie(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("release_date")
    val releaseDate: String,
    val title: String,
    @SerializedName("vote_average")
    val voteAverage: Double,
    @SerializedName("vote_count")
    val voteCount: Int
)
