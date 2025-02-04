package com.example.gameon.presentation.game

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.gameon.domain.model.Game

@Composable
fun GameItem(
    game: Game,
    navController: NavController

) {
    val viewModel: GameViewModel = hiltViewModel()
    viewModel.checkIfFavorite(game.id.toString())
    val isFavourite = viewModel.isFavorite.observeAsState().value

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()

    ) {
        item {
            Column {
                Box(
                    modifier = Modifier.fillMaxWidth(), // Ensure the image and icons fit the width
                    contentAlignment = Alignment.TopCenter // Position icons on top
                ) {
                    GameImage(
                        onClick = { },
                        imageUrl = game.thumbnail ?: ""

                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 25.dp), // Optional padding for spacing
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconButton(
                            onClick = { /* Handle back action */ }

                        ) {
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = "Back",
                                tint = MaterialTheme.colorScheme.onPrimary,
                                modifier = Modifier.size(30.dp)
                            )
                        }

                        IconButton(
                            onClick = {
                                viewModel.toggleSaveButton(game)
                            }

                        ) {
                            Icon(
                                imageVector = if (isFavourite == true) Icons.Default.Favorite else Icons.Outlined.FavoriteBorder,
                                contentDescription = "Favorite",
                                tint = MaterialTheme.colorScheme.onPrimary,
                                modifier = Modifier.size(30.dp)
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                Column(modifier = Modifier.padding(10.dp)) {
                    Text(
                        text = game.title ?: "",
                        style = MaterialTheme.typography.displayMedium.copy(fontSize = 24.sp)
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    TextButton(onClick = { navController.navigate(game.gameUrl ?: "") }) {
                        Text(text = "Get Game")
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = game.description ?: "")
                }
            }
        }
    }
}