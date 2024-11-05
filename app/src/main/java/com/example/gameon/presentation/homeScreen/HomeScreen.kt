package com.example.gameon.presentation.homeScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.gameon.presentation.components.TopPart


@Composable
fun HomeScreen(viewModel: GamesViewModel) {
    val homeState= viewModel.uiState.collectAsState()


    Scaffold (
        modifier = Modifier.padding(10.dp),
        topBar = { TopPart()},
        bottomBar = {},
        ){paddingValues ->
        Column (modifier = Modifier.padding(paddingValues)){




        }

    }




}