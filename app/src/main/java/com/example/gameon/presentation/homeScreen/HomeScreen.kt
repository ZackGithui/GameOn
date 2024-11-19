package com.example.gameon.presentation.homeScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.gameon.presentation.components.GameCard
import com.example.gameon.presentation.components.TopPart


@Composable
fun HomeScreen(viewModel: GamesViewModel = hiltViewModel()) {

    val state = viewModel.uiState.collectAsStateWithLifecycle().value



    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background),
        topBar = { TopPart() },
        content = { paddingValues ->
            LazyColumn(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()

            ) {
                if (state.shooterGames.isNotEmpty()) {
                    item {
                        GameCard(
                            games = state.shooterGames,
                            text = "Shooting",
                            onLabelButtonClicked = {})
                    }
                }
                if (state.anime.isNotEmpty()) {
                    item {
                        GameCard(
                            games = state.anime,
                            text = "Anime",
                            onLabelButtonClicked = {}
                        )
                    }
                }
                if (state.sports.isNotEmpty()) {
                    item {
                        GameCard(
                            games = state.sports,
                            text = "Sports",
                            onLabelButtonClicked = {}
                        )
                    }
                }
                if (state.fighting.isNotEmpty()) {
                    item {
                        GameCard(
                            games = state.fighting,
                            text = "Fighting",
                            onLabelButtonClicked = {})
                    }
                }


                if (state.racing.isNotEmpty()) {
                    item {
                        GameCard(games = state.racing,
                            text = "Racing",
                            onLabelButtonClicked = {})
                    }
                }


            }

        },


        )
}