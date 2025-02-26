package com.example.gameon.presentation.components

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.gameon.R
import com.example.gameon.ui.theme.GameOnTheme

@Composable
fun TopPart(
    navController: NavHostController
) {
    Column(
        modifier = Modifier
            .background(color = MaterialTheme.colorScheme.primary)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .padding(top = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically

        ) {
            Text(
                text = stringResource(id = R.string.Title),
                style = MaterialTheme.typography.titleMedium.copy(fontSize = 24.sp),
                color = MaterialTheme.colorScheme.onPrimary
            )

            Image(
                painter = painterResource(id = R.drawable.logo1),

                contentDescription = stringResource(id = R.string.Logo),
                modifier = Modifier.size(70.dp),
                contentScale = ContentScale.Crop,
                colorFilter = ColorFilter.tint(color = MaterialTheme.colorScheme.onPrimary)

            )
        }
       /* var text by remember {
            mutableStateOf("")
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
                .clickable { navController.navigate(AppScreens.SearchScreens.route) }
        ) {
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = text,
                onValueChange = { text = it },
                placeholder = { Text("Search...") },
                shape = RoundedCornerShape(10.dp),
                singleLine = true,
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Search, contentDescription = "Search Icon")
                },
                trailingIcon = {
                    if (text.isNotEmpty()) {
                        IconButton(onClick = { text = "" }) {
                            Icon(
                                imageVector = Icons.Default.Close,
                                contentDescription = "Clear Search"
                            )
                        }
                    }
                },
                enabled = false // Prevent keyboard from showing up since click navigates
            )
        }*/
        Divider(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.surface)
                .height(2.dp)
        )
    }
}

@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun TopPartPrev() {
    GameOnTheme {
        val navController = rememberNavController()
        TopPart(navController = navController)
    }

}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun TopPartPrev1() {
    GameOnTheme {
        val navController = rememberNavController()
        TopPart(navController = navController)
    }
}