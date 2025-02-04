package com.example.gameon.domain.model

data class Game(
    val description: String?,
    val thumbnail: String?,
    val shortDescription: String?,
    val id: Int,
    val title: String?,
    val genre: String?,
    val developer: String?,
    val gameUrl: String?,
    val releaseDate: String?
)
data class LikedEntity(
    val id: Int,
    val title: String,
    val thumbnail: String,
    val genre: String
)
