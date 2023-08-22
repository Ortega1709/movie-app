package com.ortega.infomovies.domain.remoteKeys

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ortega.infomovies.util.Constants.POPULAR_REMOTE_KEYS_TABLE

@Entity(tableName = POPULAR_REMOTE_KEYS_TABLE)
data class PopularRemoteKeys(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val previousPage: Int?,
    val nextPage: Int?
)
