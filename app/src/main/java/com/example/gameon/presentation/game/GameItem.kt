package com.example.gameon.presentation.game

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.gameon.domain.model.Game
import com.example.gameon.presentation.components.ImageHolder

@Composable
fun GameItem(
    game: Game,
    navController: NavController
) {
    Column(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .weight(0.4f)
                .padding(end = 10.dp, bottom = 10.dp)
        ) {
            ImageHolder(
                onClick = { },
                imageUrl = game.gameUrl ?: ""
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Column {
            Text(
                text = game!!.title ?: "",
                style = MaterialTheme.typography.displayMedium.copy(fontSize = 27.sp)
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