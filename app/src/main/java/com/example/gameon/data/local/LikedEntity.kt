package com.example.gameon.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Favourites")
data class LikedEntity(
    @PrimaryKey val id: Int,
    val title: String,
    val thumbnail: String,
    val genre: String
)