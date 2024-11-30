package com.example.gameon.data.remote.Dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MinimumSystemRequirements(
    @Json(name = "graphics")
    val graphics: String,
    @Json(name = "memory")
    val memory: String,
    @Json(name = "os")
    val os: String,
    @Json(name = "processor")
    val processor: String,
    @Json(name = "storage")
    val storage: String
)