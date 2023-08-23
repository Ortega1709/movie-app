package com.ortega.infomovies.data.datasource.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.ortega.infomovies.domain.remoteKeys.PopularMovieRemoteKeys

@Dao
interface PopularMovieRemoteKeysDao {

    @Upsert
    suspend fun upsertRemoteKeys(remoteKeys: List<PopularMovieRemoteKeys>)

    @Query("SELECT * FROM popular_movie_remote_keys_table WHERE id = :id")
    suspend fun getRemoteKeys(id: Int): PopularMovieRemoteKeys

    @Query("DELETE FROM popular_movie_remote_keys_table")
    suspend fun deleteAllRemoteKeys()


}