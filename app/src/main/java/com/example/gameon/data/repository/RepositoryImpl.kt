package com.example.gameon.data.repository

import android.content.ContentValues.TAG
import android.util.Log
import com.example.gameon.data.remote.Dto.GamesResponseDtoItem
import com.example.gameon.data.remote.FreeToGame
import com.example.gameon.domain.model.Game
import com.example.gameon.domain.model.GamesResponse
import com.example.gameon.domain.repository.GamesRepository
import com.example.gameon.util.Resource
import com.example.gameon.util.safeApiCall
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val api: FreeToGame):GamesRepository {
    override suspend fun getAllGames(): Flow<Resource<List<GamesResponseDtoItem>>> =flow {
        safeApiCall(Dispatchers.IO){
            try {
               var x= api.getAllGames()
                Log.d(TAG, "getAllGames: success yaay! $x")
            }
            catch (e: HttpException){
                Log.d(TAG,"Sorry sth wrong occurred")
               // Log.d(TAG, e.localizedMessage.toString()?: "UNEXPECTED ERROR OCCURRED")
            }

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