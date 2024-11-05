package com.example.gameon.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.gameon.R
import com.example.gameon.domain.model.GamesResponse


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameCard(games: GamesResponse) {
    Column(modifier = Modifier.padding(2.dp),
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        Card(onClick = { /*TODO*/ },
            modifier = Modifier.size(width = 50.dp,height=70.dp),
            shape = RectangleShape
                ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(games.thumbnail)
                    .build(),
                contentDescription = stringResource(id = R.string.game_image),
                contentScale = ContentScale.Fit,
                modifier = Modifier.clip(RoundedCornerShape(4.dp)),
                alignment = Alignment.Center,


            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = games.title?:"")


    }




    }
}