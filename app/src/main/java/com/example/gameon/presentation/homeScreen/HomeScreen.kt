package com.example.gameon.presentation.homeScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.gameon.domain.repository.GamesRepository
import com.example.gameon.presentation.components.GameCard
import com.example.gameon.presentation.components.TopPart


@Composable
fun HomeScreen(viewModel: GamesViewModel= hiltViewModel()) {


    var homeState = viewModel.uiState.collectAsState().value


    Scaffold (
        modifier = Modifier
            .fillMaxSize()
            //.padding(10.dp)
        ,
        topBar = { TopPart()},
        bottomBar = {},
        ){paddingValues ->

           LazyColumn (
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = MaterialTheme.colorScheme.background)
                    .padding(paddingValues)


            ){

                    if (homeState.shooterGames.isNotEmpty()) {
                        item{
                            LazyRow(modifier =Modifier.fillMaxWidth()){
                            items(homeState.shooterGames) {
                            GameCard(games = homeState.shooterGames[0],
                                onClick = {})
                                 }
                            }
                        }

                    }
                    if(homeState.racing.isNotEmpty()) {
                        item{
                            LazyRow(modifier =Modifier.fillMaxWidth()){
                                items(homeState.shooterGames) {
                                    GameCard(games = homeState.shooterGames[0],
                                        onClick = {})
                                }
                            }
                        }

                    }
                    if (homeState.sports.isNotEmpty()) {
                        item{
                            LazyRow(modifier =Modifier.fillMaxWidth()){
                                items(homeState.shooterGames) {
                                    GameCard(games = homeState.shooterGames[0],
                                        onClick = {})
                                }
                            }
                        }

                    }

                    if (homeState.anime.isNotEmpty()) {
                        item{
                            LazyRow(modifier =Modifier.fillMaxWidth()){
                                items(homeState.shooterGames) {
                                    GameCard(games = homeState.shooterGames[0],
                                        onClick = {})
                                }
                            }
                        }

                    }
                    if (homeState.fighting.isNotEmpty()) {
                        item{
                            LazyRow(modifier =Modifier.fillMaxWidth()){
                                items(homeState.shooterGames) {
                                    GameCard(games = homeState.shooterGames[0],
                                        onClick = {})
                                }
                            }
                        }

                    }


                else {
                    println("No game!")
                }





            }










    }




}

@Preview
@Composable
private fun HomeScreenPrev() {



}