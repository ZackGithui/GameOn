package com.example.gameon.domain.repository

import com.example.gameon.domain.model.Game
import com.example.gameon.domain.model.Games
import com.example.gameon.util.Resource

interface GamesRepository {

    suspend fun getAllGames(): Resource<List<Games>>

    suspend fun getGamesByCategories(category: String): Resource<List<Games>>

    suspend fun getGameById(id: Int): Resource<Game>
}