package com.example.gameon.data.repository

import com.example.gameon.data.mappers.toGame
import com.example.gameon.data.mappers.toGames
import com.example.gameon.data.remote.FreeToGame
import com.example.gameon.domain.model.Game
import com.example.gameon.domain.model.Games
import com.example.gameon.domain.repository.GamesRepository
import com.example.gameon.util.Resource
import java.io.IOException
import javax.inject.Inject
import retrofit2.HttpException

class RepositoryImpl @Inject constructor(private val api: FreeToGame) : GamesRepository {
    override suspend fun getAllGames(): Resource<List<Games>> =

        try {
            val games = api.getAllGames().map { it.toGames() }

            Resource.Success(games)
        } catch (e: HttpException) {
            Resource.Error(e.localizedMessage ?: "Unexpected error occurred")
        } catch (e: IOException) {
            Resource.Error("Server error occurred")
        } catch (e: Exception) {
            Resource.Error("An unknown error occurred")
        }

    override suspend fun getGamesByCategories(category: String): Resource<List<Games>> =

        try {
            val games = api.getGamesByCategory(category).map { it.toGames() }
            // ver eror occurred  Log.d(TAG, "getGamesByCategories: $games")
            Resource.Success(games)
        } catch (e: HttpException) {
            Resource.Error(e.localizedMessage ?: "Unexpected error occurred")
        } catch (e: IOException) {
            Resource.Error("Server error occurred")
        } catch (e: Exception) {
            Resource.Error("An unknown error occurred")
        }

    override suspend fun getGameById(id: Int): Game =

        api.getGameById(id).toGame()
}
