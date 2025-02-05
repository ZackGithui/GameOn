package com.example.gameon.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        AppScreens.HomeScreens,
        AppScreens.SearchScreens,
        AppScreens.FavouriteScreens
    )
    BottomAppBar {
        val currentRoute = navController.currentBackStackEntry?.destination?.route
        items.forEach { item ->
            NavigationBarItem(
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(AppScreens.HomeScreens.route) {
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                    }
                },
                icon = { if (currentRoute == item.route) Icons.Filled.Home else item.icon },
                label = { Text(text = item.title) }
            )
            NavigationBarItem(
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(AppScreens.SearchScreens.route) {
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                    }
                },
                icon = { if (currentRoute == item.route) Icons.Filled.Search else item.icon },
                label = { Text(text = item.title) }
            )
            NavigationBarItem(
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(AppScreens.FavouriteScreens.route) {
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                    }
                },
                icon = { if (currentRoute == item.route) Icons.Filled.Favorite else item.icon },
                label = { Text(text = item.title) }
            )
        }
    }
}