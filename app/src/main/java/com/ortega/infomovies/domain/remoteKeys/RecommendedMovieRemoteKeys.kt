package com.ortega.infomovies.domain.remoteKeys

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ortega.infomovies.util.Constants.RECOMMENDED_MOVIE_REMOTE_KEYS_TABLE

@Entity(tableName = RECOMMENDED_MOVIE_REMOTE_KEYS_TABLE)
data class RecommendedMovieRemoteKeys(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val previousPage: Int?,
    val nextPage: Int?
)