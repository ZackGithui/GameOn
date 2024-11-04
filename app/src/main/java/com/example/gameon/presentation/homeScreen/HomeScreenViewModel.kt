package com.example.gameon.presentation.homeScreen

import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gameon.domain.model.GamesResponse
import com.example.gameon.domain.repository.GamesRepository
import com.example.gameon.util.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class GamesViewModel @Inject constructor(private val repository: GamesRepository):ViewModel(){

    private var _uiState= MutableStateFlow(HomeScreenState())
    var uiState= _uiState.asStateFlow()

    init {
        getGames()
    }


   private fun getGames(){
       viewModelScope.launch {
           repository.getAllGames().collect{result->
               when(result) {
                   is Resource.Success ->{
                       val games= result.data ?: emptyList()
                       val shooting= games.filter { it.genre?.lowercase().equals("shooter") }
                       val animes= games.filter { it.genre?.lowercase().equals("anime") }
                       val race = games.filter { it.genre?.lowercase().equals("racing") }
                       val fights =games.filter { it.genre?.lowercase().equals("fighting") }
                       val sport = games.filter{it.genre?.lowercase().equals("sports")}
                     _uiState.value=_uiState.value.copy(
                         shooterGames = shooting,
                         anime=animes,
                         racing = race,
                         fighting = fights,
                         sports = sport,
                         isLoading = false


                     )


                   }

                   is Resource.Error -> {
                       _uiState.value=_uiState.value.copy(isLoading = false,
                           error = result.message ?: "Unexpected error occurred"
                       )
                   }
                   is Resource.Loading -> {
                       _uiState.value= _uiState.value.copy(isLoading = true)
                   }
               }

           }
       }
   }





}





data class HomeScreenState(
    var isLoading:Boolean=false,
    val error:String?="",
    val shooterGames:List<GamesResponse> = emptyList(),
    val anime:List<GamesResponse> = emptyList(),
    val racing :List<GamesResponse> = emptyList(),
    val fighting :List<GamesResponse> = emptyList(),
    val sports:List<GamesResponse> = emptyList()


)