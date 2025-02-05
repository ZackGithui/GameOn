package com.example.gameon.presentation.favourite

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.gameon.presentation.favourite.components.FavouriteItem
import com.example.gameon.presentation.game.GameViewModel

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun FavouriteScreen() {
    val viewModel: GameViewModel = hiltViewModel()
    viewModel.getFavoriteGames()

    val games = viewModel.state.value.savedGames
    FavouriteItem(games = viewModel.state.value.savedGames!!)
    Log.d(TAG, "The saved games are $games")
}