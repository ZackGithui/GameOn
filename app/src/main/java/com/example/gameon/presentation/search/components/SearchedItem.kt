package com.example.gameon.presentation.search.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.gameon.domain.model.Games
import com.example.gameon.presentation.components.ImageHolder

@Composable
fun SearchedItem(game: Games) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(30.dp)
    ) {
        ImageHolder(imageUrl = game.thumbnail ?: "", onClick = {})

        Column {
            Text(text = game.title ?: "Unknown Game") // Game title
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = game.genre ?: "Unknown Genre") // Game genre
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = game.releaseDate ?: "Release Date Unknown") // Release date
        }
    }
    Spacer(modifier = Modifier.height(15.dp))
}
