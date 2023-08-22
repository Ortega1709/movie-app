package com.ortega.infomovies.domain.remoteKeys

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ortega.infomovies.util.Constants.RECOMMENDED_REMOTE_KEYS_TABLE

@Entity(tableName = RECOMMENDED_REMOTE_KEYS_TABLE)
data class RecommendedRemoteKeys(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val previousPage: Int?,
    val nextPage: Int?
)