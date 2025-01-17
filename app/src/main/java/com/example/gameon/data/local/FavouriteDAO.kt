package com.example.gameon.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface FavouriteDAO {
    @Upsert
    suspend fun updateGames(likedEntity: LikedEntity)

    @Delete
    suspend fun deleteGame(likedEntity: LikedEntity)

    @Query("Select * From Favourites ")
    fun getAllGames(): Flow<List<LikedEntity>>

    @Query("SELECT EXISTS(SELECT 1 FROM Favourites WHERE id = :id)")
    suspend fun getGameById(id: String): Boolean
}