package com.example.gameon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.gameon.presentation.components.BottomNavigationBar
import com.example.gameon.presentation.favourite.FavouriteScreen
import com.example.gameon.presentation.game.Game
import com.example.gameon.presentation.homeScreen.HomeScreen
import com.example.gameon.presentation.navigation.AppScreens
import com.example.gameon.presentation.search.SearchScreen
import com.example.gameon.ui.theme.GameOnTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            GameOnTheme {
                val navController = rememberNavController()
                Scaffold(bottomBar = {
                    BottomNavigationBar(navController = navController)
                }) { paddingValues ->
                    App(paddingValues)
                }
            }
        }
    }
}

@Composable
fun App(paddingValues: PaddingValues) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.HomeScreens.route) {
        composable(AppScreens.HomeScreens.route) {
            HomeScreen(navController = navController)
        }
        composable(AppScreens.SearchScreens.route) {
            SearchScreen()
        }
        composable(AppScreens.FavouriteScreens.route) {
            FavouriteScreen()
        }
        composable(
            route = AppScreens.GameScreen.route,
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) { backStackEntry ->
            val gameId = backStackEntry.arguments?.getInt("id")
            Game(navController = navController, gameId = gameId ?: 0)
        }
    }
}