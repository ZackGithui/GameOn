package com.example.gameon.presentation.game

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController

@Composable
fun Game(
    gameId: Int,
    navController: NavController

) {
    val viewModel: GameViewModel = hiltViewModel()
    val state = viewModel.state.collectAsStateWithLifecycle().value
    LaunchedEffect(gameId) {
        viewModel.loadGame(gameId)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.onPrimary)
    ) {
        state.game?.let { GameItem(game = it, navController = navController) }
    }
}