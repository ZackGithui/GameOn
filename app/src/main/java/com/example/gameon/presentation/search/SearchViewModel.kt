package com.example.gameon.presentation.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gameon.domain.model.Games
import com.example.gameon.domain.repository.GamesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val gamesRepository: GamesRepository
) : ViewModel() {

    private val _searchState = MutableStateFlow(SearchState())
    val searchState = _searchState.asStateFlow()

    // Function to handle UI events
    fun onEvent(events: SearchEvents) {
        when (events) {
            is SearchEvents.OnValueChanged -> {
                updateSearchQuery(events.search)
            }
        }
    }

    // Updates the search query and filters the results
    private fun updateSearchQuery(query: String) {
        viewModelScope.launch {
            kotlinx.coroutines.delay(1000)
            try {
                val allGames = gamesRepository.getAllGames().data.orEmpty() // Null safety
                val filteredGames = allGames.filter { game ->
                    game.title?.lowercase()?.contains(query.lowercase()) ?: false
                }

                _searchState.value = _searchState.value.copy(
                    query = query,
                    result = filteredGames,
                    error = null
                )
            } catch (e: Exception) {
                _searchState.value = _searchState.value.copy(
                    error = "Error fetching games: ${e.message}"
                )
            }
        }
    }
}

data class SearchState(
    val query: String = "",
    val result: List<Games> = emptyList(),
    val error: String? = null
)

sealed interface SearchEvents {
    data class OnValueChanged(val search: String) : SearchEvents
}
