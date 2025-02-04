package com.example.gameon.presentation.favourite

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.gameon.presentation.favourite.components.FavouriteItem
import com.example.gameon.presentation.game.GameViewModel

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun FavouriteScreen() {
    val viewModel: GameViewModel = hiltViewModel()
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = MaterialTheme.colorScheme.onPrimary)
            ) {
                viewModel.state.value.game?.let {
                    FavouriteItem(
                        // games = viewModel.state.value.save,
                        thumbnail = viewModel.state.value.savedGame?.thumbnail,
                        title = viewModel.state.value.savedGame?.title,
                        genre = viewModel.state.value.savedGame?.genre
                        // releaseDate = viewModel.state.value.savedGame.
                    )
                }
            }
        }
    }
}