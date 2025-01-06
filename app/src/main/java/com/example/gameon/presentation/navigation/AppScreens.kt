package com.example.gameon.presentation.navigation

sealed class AppScreens(val route: String) {
    data object HomeScreens : AppScreens("Home screen")
    data object SearchScreens : AppScreens("Search screen")
    data object GameScreen : AppScreens("Game screen/{id}") {
        fun createRoute(id: Int) = "Game screen/$id"
    }
}