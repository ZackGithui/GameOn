package com.example.gameon.presentation.components

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.gameon.presentation.navigation.AppScreens

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        AppScreens.HomeScreens,
        AppScreens.SearchScreens,
        AppScreens.FavouriteScreens

    )

    NavigationBar(
        containerColor = MaterialTheme.colorScheme.onPrimary,
        contentColor = MaterialTheme.colorScheme.primary,
        tonalElevation = 4.dp
    ) {
        val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

        items.forEach { item ->
            NavigationBarItem(
                enabled = true,
                selected = item.route == currentRoute,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        restoreState = true
                    }
                },
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = "",
                        modifier = Modifier.size(30.dp)
                    )
                },

                label = { Text(text = item.title) }

            )
        }
    }
}
