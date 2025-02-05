package com.example.gameon.presentation.favourite.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.gameon.data.local.LikedEntity
import com.example.gameon.presentation.components.ImageHolder

@Composable
fun FavouriteItem(
    games: List<LikedEntity>

) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.onPrimary)
            .padding(10.dp)

    ) {
        items(games) { game ->
            Box(
                modifier = Modifier.border(
                    width = 1.dp,
                    color = Color.LightGray,
                    shape = RoundedCornerShape(10.dp)

                )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp),
                    horizontalArrangement = Arrangement.spacedBy(30.dp)
                ) {
                    ImageHolder(imageUrl = game.thumbnail, onClick = {})

                    Column {
                        Text(text = game.title ?: "Unknown Game") // Game title
                        Spacer(modifier = Modifier.height(5.dp))
                        Text(text = game.genre ?: "Unknown Genre") // Game genre
                        Spacer(modifier = Modifier.height(5.dp))
                        // Text(text = releaseDate ?: "Release Date Unknown") // Release date
                    }
                }
            }
            Spacer(modifier = Modifier.height(15.dp))
        }
    }
}
