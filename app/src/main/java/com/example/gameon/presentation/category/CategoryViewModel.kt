package com.example.gameon.presentation.category

import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gameon.domain.model.Games
import com.example.gameon.domain.repository.GamesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException

@HiltViewModel
class CategoryViewModel @Inject constructor(private val repository: GamesRepository) : ViewModel() {
    private val _categoryState: MutableStateFlow<CategoryState> = MutableStateFlow(CategoryState())
    val categoryState = _categoryState.asStateFlow()

    fun uiEvents(event: UiEvents) {
        when (event) {
            is UiEvents.VieWAllClicked -> {
                _categoryState.value = _categoryState.value.copy(
                    category = event.category
                )
                getGamesByCategory(event.category)
            }
        }
    }

    init {
        getGamesByCategory(category = _categoryState.value.category)
    }

    private fun getGamesByCategory(category: String) {
        viewModelScope.launch {
            try {
                _categoryState.value = _categoryState.value.copy(
                    isLoading = true
                )
                val games = repository.getGamesByCategories(category).data ?: emptyList()

                _categoryState.value = _categoryState.value.copy(
                    shooting = games.filter { it.genre?.lowercase() == "shooter" },
                    sports = games.filter { it.genre?.lowercase() == "sports" },
                    fighting = games.filter { it.genre?.lowercase() == "fighting" },
                    racing = games.filter { it.genre?.lowercase() == "racing" },
                    category = category,
                    isLoading = false

                )
            } catch (e: HttpException) {
                _categoryState.value = _categoryState.value.copy(
                    isLoading = false,
                    error = repository.getGamesByCategories(category).message ?: e.localizedMessage
                )
            }
        }
        Log.d(ContentValues.TAG, "CategoryScreen: ${_categoryState.value.sports}")
    }
}

sealed class UiEvents {
    data class VieWAllClicked(val category: String) : UiEvents()
}

val categories = listOf("shooting", "racing", "anime", "fighting", "sports")

data class CategoryState(
    val selected: List<String> = categories,
    val error: String = "",
    val shooting: List<Games> = emptyList(),
    val racing: List<Games> = emptyList(),
    val anime: List<Games> = emptyList(),
    val fighting: List<Games> = emptyList(),
    val sports: List<Games> = emptyList(),
    val isLoading: Boolean = false,
    val category: String = "fighting"

)