package com.example.gameon.data.remote

import com.example.gameon.data.remote.Dto.GameDto
import com.example.gameon.data.remote.Dto.GamesResponseDto
import com.example.gameon.data.remote.Dto.GamesResponseDtoItem
import retrofit2.http.GET
import retrofit2.http.Query

interface FreeToGame {

    @GET("games")
    suspend fun getAllGames(): List<GamesResponseDtoItem>

    @GET("games")
    suspend fun getGamesByCategory(
        @Query ("category") category:String="shooter"
    ):List<GamesResponseDto>

    @GET("game")
    suspend fun getGameById(
        @Query("id") id:Int
    ): GameDto


}