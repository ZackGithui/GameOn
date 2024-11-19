package com.example.gameon.domain.repository


import com.example.gameon.domain.model.Game
import com.example.gameon.domain.model.Games
import com.example.gameon.util.Resource
import kotlinx.coroutines.flow.Flow

interface GamesRepository {

    suspend fun getAllGames(): Flow<Resource<List<Games>>>

    suspend fun getGamesByCategories(category: String): Flow<Resource<List<Games>>>

    suspend fun getGameById(id: Int): Flow<Resource<Game>>
}