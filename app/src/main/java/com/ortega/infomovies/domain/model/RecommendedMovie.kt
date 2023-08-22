package com.ortega.infomovies.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.ortega.infomovies.util.Constants.RECOMMENDED_MOVIE_TABLE

@Entity(tableName = RECOMMENDED_MOVIE_TABLE)
data class RecommendedMovie(
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
