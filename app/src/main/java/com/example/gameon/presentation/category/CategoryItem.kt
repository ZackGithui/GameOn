package com.example.gameon.presentation.category

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.gameon.domain.model.Games
import com.example.gameon.presentation.components.ImageHolder

@Composable
fun CategoryItem(games: List<Games>) {
    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        games.forEach { game ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                horizontalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                ImageHolder(imageUrl = game.thumbnail ?: "", onClick = {})

                Column {
                    Row {
                        Text(text = "Game title: ")
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(text = game.title ?: "Unknown Game") // Game title
                    }
                    Spacer(modifier = Modifier.height(5.dp))
                    Row {
                        Text(text = "Game genre: ")
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(text = game.genre ?: "Unknown Genre") // Game genre
                    }

                    Spacer(modifier = Modifier.height(5.dp))
                    Row {
                        Text(text = "Release data: ")
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(text = game.releaseDate ?: "Release Date Unknown") // Release date
                    }
                }
            }
        }
    }

    Spacer(modifier = Modifier.height(15.dp))
}
