package com.example.gameon.presentation.homeScreen


import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gameon.data.remote.Dto.GamesResponseDtoItem
import com.example.gameon.domain.model.GamesResponse
import com.example.gameon.domain.repository.GamesRepository
import com.example.gameon.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GamesViewModel @Inject constructor(private val repository: GamesRepository): ViewModel(){

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
                       val games= result.data?: emptyList()
                       val shooting= games.filter { it.genre == "Shooter"}
                       val anime= games.filter { it.genre.lowercase() == "anime" }
                       val race = games.filter { it.genre.lowercase().equals("racing") }
                       val fights =games.filter { it.genre.lowercase().equals("fighting") }
                       val sport = games.filter{it.genre.lowercase().equals("sports")}
                     _uiState.value=_uiState.value.copy(
                         shooterGames = shooting,
                         anime=anime,
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
    val shooterGames:List<GamesResponseDtoItem> = emptyList(),
    val anime:List<GamesResponseDtoItem> = emptyList(),
    val racing :List<GamesResponseDtoItem> = emptyList(),
    val fighting :List<GamesResponseDtoItem> = emptyList(),
    val sports:List<GamesResponseDtoItem> = emptyList()


)