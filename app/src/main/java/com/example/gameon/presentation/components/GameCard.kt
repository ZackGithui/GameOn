package com.example.gameon.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gameon.domain.model.Games
import com.example.gameon.presentation.components.ImageHolder

@Composable
fun GameCard(
    games:List<Games>,
    text:String,
    onLabelButtonClicked:()->Unit) {

        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp),
            ){
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween) {
                Text(
                    text = text?:"",
                    style = MaterialTheme.typography.bodyMedium.copy(fontSize = 23.sp)
                )
                TextButton(onClick = { onLabelButtonClicked}) {
                    Text(text = "See all", style =MaterialTheme.typography.bodyMedium.copy(fontSize = 23.sp))

                }
            }

            Spacer(modifier= Modifier.height(5.dp))

            LazyRow {
                items(games){
                    ImageHolder(imageUrl = it.thumbnail?:"")
                    Text(text = it.title?:"")
                }



            }

        }


}