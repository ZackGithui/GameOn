package com.example.gameon.data.remote.Dto


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GameDto(
    @Json(name = "description")
    val description: String,
    @Json(name = "developer")
    val developer: String,
    @Json(name = "freetogame_profile_url")
    val freetogameProfileUrl: String,
    @Json(name = "game_url")
    val gameUrl: String,
    @Json(name = "genre")
    val genre: String,
    @Json(name = "id")
    val id: Int,
    @Json(name = "minimum_system_requirements")
    val minimumSystemRequirements: MinimumSystemRequirements,
    @Json(name = "platform")
    val platform: String,
    @Json(name = "publisher")
    val publisher: String,
    @Json(name = "release_date")
    val releaseDate: String,
    @Json(name = "screenshots")
    val screenshots: List<Screenshot>,
    @Json(name = "short_description")
    val shortDescription: String,
    @Json(name = "status")
    val status: String,
    @Json(name = "thumbnail")
    val thumbnail: String,
    @Json(name = "title")
    val title: String
)