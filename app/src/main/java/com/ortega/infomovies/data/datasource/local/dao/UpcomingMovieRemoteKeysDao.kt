package com.ortega.infomovies.data.datasource.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.ortega.infomovies.domain.remoteKeys.UpcomingMovieRemoteKeys

@Dao
interface UpcomingMovieRemoteKeysDao {

    @Upsert
    suspend fun upsertRemoteKeys(remoteKeys: List<UpcomingMovieRemoteKeys>)

    @Query("SELECT * FROM upcoming_movie_remote_keys_table WHERE id = :id")
    suspend fun getRemoteKeys(id: Int): UpcomingMovieRemoteKeys

    @Query("DELETE FROM upcoming_movie_remote_keys_table")
    suspend fun deleteAllRemoteKeys()

}