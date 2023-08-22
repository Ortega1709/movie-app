package com.ortega.infomovies.data.datasource.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.ortega.infomovies.domain.remoteKeys.UpcomingRemoteKeys

@Dao
interface UpcomingRemoteKeysDao {

    @Upsert
    suspend fun upsertRemoteKeys(remoteKeys: List<UpcomingRemoteKeys>)

    @Query("SELECT * FROM upcoming_remote_keys_table WHERE id = :id")
    suspend fun getRemoteKeys(id: Int): UpcomingRemoteKeys

    @Query("DELETE FROM upcoming_remote_keys_table")
    suspend fun deleteAllRemoteKeys()

}