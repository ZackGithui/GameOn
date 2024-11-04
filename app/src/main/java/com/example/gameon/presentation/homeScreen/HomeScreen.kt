package com.example.gameon.presentation.homeScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier


@Composable
fun HomeScreen(viewModel: GamesViewModel) {
    val homeState= viewModel.uiState.collectAsState()


    Scaffold (
        modifier = Modifier,
        topBar = {},
        bottomBar = {},
        ){paddingValues ->
        Column (modifier = Modifier.padding(paddingValues)){



        }

    }




}