package com.example.gameon.presentation.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.gameon.R

@Composable
fun ImageHolder(imageUrl: String) {
    Card(
        modifier = Modifier
            .height(150.dp)
            .width(100.dp)
            .padding(start = 8.dp)
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(imageUrl)
                .build(),
            contentDescription = stringResource(id = R.string.game_image),
            modifier = Modifier
                .clip(RoundedCornerShape(4.dp))
                .width(100.dp)
                .height(150.dp),
            contentScale = ContentScale.Crop

        )
    }
}