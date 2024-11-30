package com.example.gameon.data.repository

import com.example.gameon.data.mappers.toGame
import com.example.gameon.data.mappers.toGames
import com.example.gameon.data.remote.FreeToGame
import com.example.gameon.domain.model.Game
import com.example.gameon.domain.model.Games
import com.example.gameon.domain.repository.GamesRepository
import com.example.gameon.util.Resource
import com.example.gameon.util.safeApiCall
import java.io.IOException
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import retrofit2.HttpException

class RepositoryImpl @Inject constructor(private val api: FreeToGame) : GamesRepository {
    override suspend fun getAllGames(): Resource<List<Games>> =

        try {
            val games = api.getAllGames()

            val allGames = games.map { it.toGames() }

            Resource.Success(allGames)
        } catch (e: HttpException) {
            Resource.Error(e.localizedMessage ?: "Unexpected error occurred")
        } catch (e: IOException) {
            Resource.Error("Server error occurred")
        } catch (e: Exception) {
            Resource.Error("An unknown error occurred")
        }

    override suspend fun getGamesByCategories(category: String): Resource<List<Games>> =

        safeApiCall(Dispatchers.IO) {
            api.getGamesByCategory(category).map { it.toGames() }
        }

    override suspend fun getGameById(id: Int): Resource<Game> =
        safeApiCall(Dispatchers.IO) {
            api.getGameById(id).toGame()
        }
}
