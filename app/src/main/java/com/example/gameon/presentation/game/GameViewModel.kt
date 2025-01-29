package com.example.gameon.presentation.game

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gameon.data.local.GameDatabase
import com.example.gameon.data.local.LikedEntity
import com.example.gameon.domain.model.Game
import com.example.gameon.domain.repository.GamesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flatMap
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GameViewModel @Inject constructor(
    private val repository: GamesRepository,
    private val database: GameDatabase
) : ViewModel() {
    private val _state = MutableStateFlow(GameState())
    val state = _state.asStateFlow()

    private val _isFavorite = MutableLiveData<Boolean>()
    val isFavorite: LiveData<Boolean> get() = _isFavorite

    fun loadGame(id: Int) {
        viewModelScope.launch {
            val game = repository.getGameById(id)
            _state.value = _state.value.copy(game = game)
        }
    }

    fun checkIfFavorite(gameId: String) {
        viewModelScope.launch {
            _isFavorite.value = database.favouriteDAO().getGameById(gameId)
        }
    }

    fun toggleSaveButton(likedEntity: LikedEntity) {
        viewModelScope.launch {
            val isFavorite = database.favouriteDAO().getGameById(likedEntity.id.toString())
            if (isFavorite) {
               database.favouriteDAO().deleteGame(likedEntity)
                _isFavorite.postValue(false)
            } else {
                database.favouriteDAO().updateGames(likedEntity)
                _isFavorite.postValue(true)
            }
        }
    }

    suspend fun isGameSaved(id: String): Boolean {
        return database.favouriteDAO().getGameById(id) != null
    }

    fun getFavoriteGames() {
        viewModelScope.launch {
            val savedGames = database.favouriteDAO().getAllGames().toList().flatten()
            _state.value = _state.value.copy(savedGames = savedGames)
        }
    }
}


data class GameState(

    val game: Game? = null,
    val savedGames: List<LikedEntity>? = emptyList(),
    val savedGame: LikedEntity? = null
)
