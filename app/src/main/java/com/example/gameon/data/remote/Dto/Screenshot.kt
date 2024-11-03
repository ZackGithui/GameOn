package com.example.gameon.data.remote.Dto


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Screenshot(
    @Json(name = "id")
    val id: Int,
    @Json(name = "image")
    val image: String
)