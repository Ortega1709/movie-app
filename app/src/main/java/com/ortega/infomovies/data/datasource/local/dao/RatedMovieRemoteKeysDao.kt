package com.ortega.infomovies.data.datasource.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.ortega.infomovies.domain.remoteKeys.RatedMovieRemoteKeys

@Dao
interface RatedMovieRemoteKeysDao {

    @Upsert
    suspend fun upsertRemoteKeys(remoteKeys: List<RatedMovieRemoteKeys>)

    @Query("SELECT * FROM rated_movie_remote_keys_table WHERE id = :id")
    suspend fun getRemoteKeys(id: Int): RatedMovieRemoteKeys

    @Query("DELETE FROM rated_movie_remote_keys_table")
    suspend fun deleteAllRemoteKeys()

}