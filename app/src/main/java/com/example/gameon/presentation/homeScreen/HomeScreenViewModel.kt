package com.example.gameon.presentation.homeScreen


import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gameon.domain.model.Games
import com.example.gameon.domain.repository.GamesRepository
import com.example.gameon.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
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
            repository.getAllGames().collect { result ->
                when (result) {
                    is Resource.Success -> {

                        val games = result.data ?: emptyList()
                        val shootingGames = games.filter { it.genre?.lowercase() == "shooter" }
                        val anime = games.filter { it.genre?.lowercase() == "anime" }
                        val race = games.filter { it.genre?.lowercase() == "racing" }
                        val fights = games.filter { it.genre?.lowercase() == "fighting" }
                        val sport = games.filter { it.genre?.lowercase() == "sports" }
                        _uiState.update {
                            it.copy(
                                isLoading = false,
                                shooterGames = shootingGames,
                                anime = anime,
                                racing = race,
                                fighting = fights,
                                sports = sport,
                            )

                        }


                    }

                    is Resource.Error -> {
                        _uiState.value = _uiState.value.copy(
                            isLoading = false,
                            error = result.message ?: "Unexpected error occurred"
                        )
                    }

                    is Resource.Loading -> {
                        _uiState.value = _uiState.value.copy(isLoading = true)
                    }
                }
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
    val sports: List<Games> = emptyList(),


    )