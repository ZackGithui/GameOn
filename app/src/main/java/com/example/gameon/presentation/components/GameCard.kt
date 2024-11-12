package com.example.gameon.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.gameon.R
import com.example.gameon.data.remote.Dto.GamesResponseDtoItem
import com.example.gameon.domain.model.GamesResponse


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameCard(
    games: GamesResponseDtoItem,
    onClick:()->Unit) {
    Column(modifier = Modifier.padding(2.dp),
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        Card(onClick = { onClick},
            modifier = Modifier.size(width = 60.dp,height=80.dp)
                .clip(RoundedCornerShape(5.dp)),
            shape = RectangleShape
                ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(games.thumbnail)
                    .build(),
                contentDescription = stringResource(id = R.string.game_image),
                contentScale = ContentScale.Fit,
                modifier = Modifier.clip(RoundedCornerShape(5.dp)),
                alignment = Alignment.Center,

            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = games.title?:"PUBG",
                style = MaterialTheme.typography.labelMedium.copy(fontSize = 20.sp) )


    }




    }
}

@Preview
@Composable
private fun GameCardPrev() {

}