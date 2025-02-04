package com.example.gameon.presentation.game

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gameon.data.local.FavouriteDAO
import com.example.gameon.data.local.LikedEntity
import com.example.gameon.domain.model.Game
import com.example.gameon.domain.repository.GamesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch

@HiltViewModel
class GameViewModel @Inject constructor(
    private val repository: GamesRepository,
    private val favouriteDAO: FavouriteDAO
) : ViewModel() {
    private val _state = MutableStateFlow(GameState())
    val state = _state.asStateFlow()

    private val _isFavorite = MutableLiveData<Boolean>()
    val isFavorite: LiveData<Boolean> get() = _isFavorite

    init {
        checkIfFavorite(_state.value.game?.id.toString())
    }

    fun loadGame(id: Int) {
        viewModelScope.launch {
            val game = repository.getGameById(id)
            _state.value = _state.value.copy(game = game)
        }
    }

    fun checkIfFavorite(gameId: String) {
        viewModelScope.launch {
            val likedGame = favouriteDAO.getGameById(gameId)
            _isFavorite.postValue(likedGame != null)
            _state.value.copy(
                savedGame = likedGame
            )
        }
    }

    fun toggleSaveButton(game: Game) {
        viewModelScope.launch {
            val existingGame = favouriteDAO.getGameById(game.id.toString())

            if (existingGame != null) {
                favouriteDAO.deleteGame(existingGame)
                _isFavorite.postValue(false)
                _state.value = _state.value.copy(savedGame = null)
            } else {
                val likedEntity = LikedEntity(
                    id = game.id,
                    title = game.title ?: "",
                    thumbnail = game.thumbnail ?: "",
                    genre = game.genre ?: ""
                )
                favouriteDAO.updateGames(likedEntity)
                _isFavorite.postValue(true)
                _state.value = _state.value.copy(savedGame = likedEntity)
            }
        }
    }

    suspend fun isGameSaved(id: String): Boolean {
        return favouriteDAO.getGameById(id) != null
    }

    fun getFavoriteGames() {
        viewModelScope.launch {
            val savedGames = favouriteDAO.getAllGames().toList().flatten()
            _state.value = _state.value.copy(savedGames = savedGames)
        }
    }
}

data class GameState(

    val game: Game? = null,
    val savedGames: List<LikedEntity>? = emptyList(),
    val savedGame: LikedEntity? = null
)
