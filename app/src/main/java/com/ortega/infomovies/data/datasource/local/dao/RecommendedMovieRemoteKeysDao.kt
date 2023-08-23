package com.ortega.infomovies.data.datasource.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.ortega.infomovies.domain.remoteKeys.RecommendedMovieRemoteKeys

@Dao
interface RecommendedMovieRemoteKeysDao {

    @Upsert
    suspend fun upsertRemoteKeys(remoteKeys: List<RecommendedMovieRemoteKeys>)

    @Query("SELECT * FROM recommended_movie_remote_keys_table WHERE id = :id")
    suspend fun getRemoteKeys(id: Int): RecommendedMovieRemoteKeys

    @Query("DELETE FROM recommended_movie_remote_keys_table")
    suspend fun deleteAllRemoteKeys()

}