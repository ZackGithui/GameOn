package com.example.gameon.presentation.homeScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gameon.domain.model.Games
import com.example.gameon.domain.repository.GamesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GamesViewModel @Inject constructor(private val repository: GamesRepository) : ViewModel() {

    private var _uiState: MutableStateFlow<HomeScreenState> = MutableStateFlow(HomeScreenState())
    val uiState get() = _uiState.asStateFlow()

    init {
        getGames()
    }

    private fun getGames() {
        viewModelScope.launch {
            try {
                _uiState.value.isLoading = true
                repository.getAllGames()
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    shooterGames = repository.getAllGames().data!!.filter { it.genre?.lowercase() == "shooter" },
                    anime = repository.getAllGames().data!!.filter { it.genre?.lowercase() == "anime" },
                    racing = repository.getAllGames().data!!.filter { it.genre?.lowercase() == "racing" },
                    fighting = repository.getAllGames().data!!.filter { it.genre?.lowercase() == "fighting" },
                    sports = repository.getAllGames().data!!.filter { it.genre?.lowercase() == "sports" }

                )
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    error = repository.getAllGames().message ?: e.localizedMessage
                )
            }
        }
    }
}

data class HomeScreenState(

    var isLoading: Boolean = false,
    val error: String? = "",
    val shooterGames: List<Games> = emptyList(),
    val anime: List<Games> = emptyList(),
    val racing: List<Games> = emptyList(),
    val fighting: List<Games> = emptyList(),
    val sports: List<Games> = emptyList()

)