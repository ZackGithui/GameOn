package com.example.gameon.data.repository

import com.example.gameon.data.remote.FreeToGame
import com.example.gameon.domain.model.Game
import com.example.gameon.domain.model.GamesResponse
import com.example.gameon.domain.repository.GamesRepository
import com.example.gameon.util.Resource
import com.example.gameon.util.safeApiCall
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val api: FreeToGame):GamesRepository {
    override suspend fun getAllGames(): Flow<Resource<List<GamesResponse>>> =flow {
        safeApiCall(Dispatchers.IO){
            api.getAllGames()
        }



    }

    override suspend fun getGamesByCategories(category: String): Flow<Resource<List<GamesResponse>>> =flow {
        safeApiCall(Dispatchers.IO){
            api.getGamesByCategory(category)
        }
    }

    override suspend fun getGameById(id: Int): Flow<Resource<Game>> =flow{
        safeApiCall(Dispatchers.IO){
            api.getGameById(id)
        }
    }
}