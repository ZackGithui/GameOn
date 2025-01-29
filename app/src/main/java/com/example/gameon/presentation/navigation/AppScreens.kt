package com.example.gameon.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class AppScreens(val route: String,val title:String,val icon: ImageVector) {
    data object HomeScreens : AppScreens("Home screen","Home", icon = Icons.Default.Home)
    data object SearchScreens : AppScreens("Search screen","Search", icon = Icons.Default.Search)
    data object FavouriteScreens : AppScreens("Favourite screen","Favourites", icon = Icons.Default.FavoriteBorder)
    data object GameScreen : AppScreens("Game screen/{id}","Game", icon = Icons.Default.ArrowBack) {
        fun createRoute(id: Int) = "Game screen/$id"
    }
}