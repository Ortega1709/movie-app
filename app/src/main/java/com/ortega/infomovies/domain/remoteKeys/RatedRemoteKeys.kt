package com.ortega.infomovies.domain.remoteKeys

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ortega.infomovies.util.Constants
import com.ortega.infomovies.util.Constants.RATED_REMOTE_KEYS_TABLE

@Entity(tableName = RATED_REMOTE_KEYS_TABLE)
data class RatedRemoteKeys(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val previousPage: Int?,
    val nextPage: Int?
)