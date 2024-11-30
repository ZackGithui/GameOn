package com.example.gameon.presentation.components

import android.content.res.Configuration
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ShimmerScreen() {
    val shimmerColors = listOf(
        Color.LightGray.copy(0.6f),
        Color.LightGray.copy(0.2f),
        Color.LightGray.copy(0.6f)

    )

    val transition = rememberInfiniteTransition()

    val animateTransition = transition.animateFloat(
        initialValue = 0f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1000,
                easing = FastOutSlowInEasing
            ),
            repeatMode = RepeatMode.Reverse

        )
    )

    val brush = Brush.linearGradient(
        colors = shimmerColors,
        start = Offset.Zero,
        end = Offset(x = animateTransition.value, y = animateTransition.value)
    )
    shimmerObject(brush = brush)
}

@Composable
fun shimmerObject(brush: Brush) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Spacer(
                modifier = Modifier
                    .size(height = 20.dp, width = 45.dp)
                    .clip(
                        RoundedCornerShape(7.dp)
                    )
                    .background(brush)
            )

            Spacer(
                modifier = Modifier
                    .size(height = 20.dp, width = 45.dp)
                    .clip(
                        RoundedCornerShape(7.dp)
                    )
                    .background(brush)
            )
        }

        Spacer(modifier = Modifier.height(5.dp))
        LazyRow(
            modifier = Modifier.padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(7) {
                Spacer(
                    modifier = Modifier
                        .size(height = 150.dp, width = 100.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(brush)
                )
            }
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun shimmerPrev() {
    shimmerObject(
        brush = Brush.linearGradient(
            colors = listOf(
                Color.LightGray.copy(0.6f),
                Color.LightGray.copy(0.2f),
                Color.LightGray.copy(0.6f)
            )
        )
    )
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
private fun shimmerPrev2() {
    shimmerObject(
        brush = Brush.linearGradient(
            colors = listOf(
                Color.LightGray.copy(0.7f),
                Color.LightGray.copy(0.2f),
                Color.LightGray.copy(0.7f)
            )
        )
    )
}