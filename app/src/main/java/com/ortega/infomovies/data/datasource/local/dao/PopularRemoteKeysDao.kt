package com.ortega.infomovies.data.datasource.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.ortega.infomovies.domain.remoteKeys.PopularRemoteKeys

@Dao
interface PopularRemoteKeysDao {

    @Upsert
    suspend fun upsertRemoteKeys(remoteKeys: List<PopularRemoteKeys>)

    @Query("SELECT * FROM popular_remote_keys_table WHERE id = :id")
    suspend fun getRemoteKeys(id: Int): PopularRemoteKeys

    @Query("DELETE FROM popular_remote_keys_table")
    suspend fun deleteAllRemoteKeys()


}