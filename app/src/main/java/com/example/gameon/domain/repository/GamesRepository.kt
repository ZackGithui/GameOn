package com.example.gameon.domain.repository

import com.example.gameon.data.remote.Dto.GamesResponseDtoItem
import com.example.gameon.domain.model.Game
import com.example.gameon.domain.model.GamesResponse
import com.example.gameon.util.Resource
import kotlinx.coroutines.flow.Flow

interface GamesRepository {

    suspend fun getAllGames():Flow<Resource<List<GamesResponseDtoItem>>>

    suspend fun getGamesByCategories(category:String):Flow<Resource<List<GamesResponse>>>

    suspend fun getGameById(id:Int):Flow<Resource<Game>>
}