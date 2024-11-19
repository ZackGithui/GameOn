package com.example.gameon.data.remote


import com.example.gameon.data.remote.Dto.GameResponse

import com.example.gameon.data.remote.Dto.GamesResponseItem
import retrofit2.http.GET
import retrofit2.http.Query

interface FreeToGame {

    @GET("games")
    suspend fun getAllGames(): List<GamesResponseItem>

    @GET("games")
    suspend fun getGamesByCategory(
        @Query("category") category: String = "shooter"
    ): List<GamesResponseItem>

    @GET("game")
    suspend fun getGameById(
        @Query("id") id: Int
    ): GameResponse


}