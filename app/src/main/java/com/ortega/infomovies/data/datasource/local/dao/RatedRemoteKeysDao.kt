package com.ortega.infomovies.data.datasource.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.ortega.infomovies.domain.remoteKeys.RatedRemoteKeys

@Dao
interface RatedRemoteKeysDao {

    @Upsert
    suspend fun upsertRemoteKeys(remoteKeys: List<RatedRemoteKeys>)

    @Query("SELECT * FROM rated_remote_keys_table WHERE id = :id")
    suspend fun getRemoteKeys(id: Int): RatedRemoteKeys

    @Query("DELETE FROM rated_remote_keys_table")
    suspend fun deleteAllRemoteKeys()

}