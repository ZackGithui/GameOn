package com.example.gameon.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.gameon.domain.model.Games
import com.example.gameon.presentation.homeScreen.GamesViewModel

@Composable
fun GameCard(
    games: List<Games>,
    text: String,
    onLabelButtonClicked: () -> Unit,
    onGameClicked: (Int) -> Unit

) {
    val viewModel: GamesViewModel = hiltViewModel()
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .background(MaterialTheme.colorScheme.onPrimary)

    ) {
        // Header row
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = text,
                style = MaterialTheme.typography.bodyMedium.copy(fontSize = 23.sp)
            )
            TextButton(onClick = onLabelButtonClicked) {
                Text(
                    text = "See all",
                    style = MaterialTheme.typography.bodyMedium.copy(fontSize = 18.sp)
                )
            }
        }

        Spacer(modifier = Modifier.height(5.dp))

        // LazyRow for game items
        LazyRow(
            modifier = Modifier.padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(games) { game ->
                Column(
                    modifier = Modifier
                        .padding(2.dp)
                        .width(100.dp),
                    horizontalAlignment = Alignment.CenterHorizontally

                ) {
                    ImageHolder(
                        imageUrl = game.thumbnail ?: "",
                        onClick = { onGameClicked(game.id) }
                    )
                    Text(
                        text = game.title ?: "Unknown Title",
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier.padding(top = 4.dp),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis

                    )
                }
            }
        }
    }
}
