package com.example.gameon.presentation.game

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gameon.domain.model.Game
import com.example.gameon.domain.repository.GamesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
@HiltViewModel
class GameViewModel @Inject constructor(private val repository: GamesRepository) : ViewModel() {
    private val _state = MutableStateFlow(GameState())
    val state = _state.asStateFlow()

    fun loadGame(id: Int) {
        viewModelScope.launch {
            val game = repository.getGameById(id) // Fetch the game from the repository
            _state.value = _state.value.copy(
                id = id,
                game = game
            )
        }
    }
}

data class GameState(
    val id: Int = 0,
    val game: Game? = null
)
