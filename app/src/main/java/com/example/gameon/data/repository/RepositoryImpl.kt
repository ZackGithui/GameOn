package com.example.gameon.data.repository

import android.content.ContentValues.TAG
import android.util.Log
import com.example.gameon.data.mappers.toGames

import com.example.gameon.data.remote.FreeToGame
import com.example.gameon.domain.model.Game
import com.example.gameon.domain.model.Games
import com.example.gameon.domain.repository.GamesRepository
import com.example.gameon.util.Resource
import com.example.gameon.util.safeApiCall
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val api: FreeToGame):GamesRepository {
    override suspend fun getAllGames(): Flow<Resource<List<Games>>> =flow {

        emit(Resource.Loading())
        try {
            val games= api.getAllGames()

            val allGames= games.map { it.toGames() }
            Log.d(TAG,"$allGames")
            emit(Resource.Success(allGames))
        }catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage ?:"Unexpected error occurred"))
            Log.d(TAG,"error")
        }
        catch (e: IOException){
            emit(Resource.Error("Server error occurred"))
        }catch (e: Exception) {

            emit(Resource.Error("An unknown error occurred"))
            Log.d(TAG,"Unknown error")
        }






    }

    override suspend fun getGamesByCategories(category: String): Flow<Resource<List<Games>>> =flow {
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