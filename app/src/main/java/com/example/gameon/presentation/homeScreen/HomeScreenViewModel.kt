package com.example.gameon.presentation.homeScreen


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gameon.domain.model.Games
import com.example.gameon.domain.repository.GamesRepository
import com.example.gameon.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
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
                       val games:List<Games> = emptyList()
                       val shooting= games.filter { it.genre == "Shooter"}
                       val anime= games.filter { it.genre == "anime" }
                       val race = games.filter { it.genre.equals("racing") }
                       val fights =games.filter { it.genre.equals("fighting") }
                       val sport = games.filter{it.genre.equals("sports")}
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
    val shooterGames:List<Games> = emptyList(),
    val anime:List<Games> = emptyList(),
    val racing :List<Games> = emptyList(),
    val fighting :List<Games> = emptyList(),
    val sports:List<Games> = emptyList()


)