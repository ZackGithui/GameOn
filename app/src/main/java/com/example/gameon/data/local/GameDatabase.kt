package com.example.gameon.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [LikedEntity::class],
    version = 2,
    exportSchema = false
)
abstract class GameDatabase : RoomDatabase() {
    abstract fun favouriteDAO(): FavouriteDAO
}