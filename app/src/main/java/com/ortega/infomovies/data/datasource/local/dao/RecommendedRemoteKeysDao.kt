package com.ortega.infomovies.data.datasource.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.ortega.infomovies.domain.remoteKeys.RecommendedRemoteKeys
import com.ortega.infomovies.domain.remoteKeys.UpcomingRemoteKeys

@Dao
interface RecommendedRemoteKeysDao {

    @Upsert
    suspend fun upsertRemoteKeys(remoteKeys: List<RecommendedRemoteKeys>)

    @Query("SELECT * FROM recommended_remote_keys_table WHERE id = :id")
    suspend fun getRemoteKeys(id: Int): RecommendedRemoteKeys

    @Query("DELETE FROM recommended_remote_keys_table")
    suspend fun deleteAllRemoteKeys()

}