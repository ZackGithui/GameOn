package com.example.gameon.presentation.components

import android.content.res.Configuration
import android.content.res.Resources
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement


import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gameon.R

@Composable
fun TopPart() {

        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,


            ) {
            Text(text = stringResource(id = R.string.Title),
                style = MaterialTheme.typography.titleMedium.copy(fontSize = 24.sp),
                color = MaterialTheme.colorScheme.onBackground)


            Image(
                painter = painterResource(id = R.drawable.logo1),

                contentDescription = stringResource(id = R.string.Logo),
                modifier = Modifier.size(70.dp),
                contentScale = ContentScale.Crop,
                colorFilter = ColorFilter.tint(color = MaterialTheme.colorScheme.onBackground)

                )



        }






}

@Preview(showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun TopPartPrev() {
    TopPart()

}
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun TopPartPrev1() {
    TopPart()

}