package com.example.gameon.presentation.homeScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.example.gameon.presentation.category.CategoryViewModel
import com.example.gameon.presentation.category.UiEvents
import com.example.gameon.presentation.components.GameCard
import com.example.gameon.presentation.components.ShimmerScreen
import com.example.gameon.presentation.components.TopPart
import com.example.gameon.presentation.navigation.AppScreens

@Composable
fun HomeScreen(
    viewModel: GamesViewModel = hiltViewModel(),
    navController: NavHostController,
    categoryViewModel: CategoryViewModel = hiltViewModel()

) {
    val state = viewModel.uiState.collectAsStateWithLifecycle().value

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.onPrimary),
        topBar = { TopPart(navController) },
        bottomBar = {},
        content = { paddingValues ->
            LazyColumn(
                modifier = Modifier
                    .background(color = MaterialTheme.colorScheme.onPrimary)
                    .padding(paddingValues)
                    .fillMaxSize()

            ) {
                if (state.isLoading) {
                    items(6) {
                        ShimmerScreen()
                    }
                }
                if (state.shooterGames.isNotEmpty()) {
                    item {
                        GameCard(
                            games = state.shooterGames,
                            text = "Shooting",
                            onLabelButtonClicked = {
                                categoryViewModel.uiEvents(UiEvents.VieWAllClicked("shooter"))
                                navController.navigate(AppScreens.CategoryScreen.route)
                            },
                            onGameClicked = { gameId ->
                                navController.navigate(
                                    AppScreens.GameScreen.createRoute(
                                        gameId
                                    )
                                )
                            }
                        )
                    }
                }
                if (state.anime.isNotEmpty()) {
                    item {
                        GameCard(
                            games = state.anime,
                            text = "Anime",
                            onLabelButtonClicked = {
                                categoryViewModel.uiEvents(UiEvents.VieWAllClicked("anime"))
                                navController.navigate(AppScreens.CategoryScreen.route)
                            },
                            onGameClicked = { gameId ->
                                navController.navigate(
                                    AppScreens.GameScreen.createRoute(
                                        gameId
                                    )
                                )
                            }
                        )
                    }
                }
                if (state.sports.isNotEmpty()) {
                    item {
                        GameCard(
                            games = state.sports,
                            text = "Sports",
                            onLabelButtonClicked = {
                                categoryViewModel.uiEvents(UiEvents.VieWAllClicked("sports"))
                                navController.navigate(AppScreens.CategoryScreen.route)
                            },
                            onGameClicked = { gameId ->
                                navController.navigate(
                                    AppScreens.GameScreen.createRoute(
                                        gameId
                                    )
                                )
                            }
                        )
                    }
                }
                if (state.fighting.isNotEmpty()) {
                    item {
                        GameCard(
                            games = state.fighting,
                            text = "Fighting",
                            onLabelButtonClicked = {
                                categoryViewModel.uiEvents(
                                    UiEvents.VieWAllClicked(category = "fighting")
                                )
                                navController.navigate(AppScreens.CategoryScreen.route)
                            },
                            onGameClicked = { gameId ->
                                navController.navigate(
                                    AppScreens.GameScreen.createRoute(
                                        gameId
                                    )
                                )
                            }
                        )
                    }
                }

                if (state.racing.isNotEmpty()) {
                    item {
                        GameCard(
                            games = state.racing,
                            text = "Racing",
                            onLabelButtonClicked = {
                                categoryViewModel.uiEvents(
                                    UiEvents.VieWAllClicked(category = "racing")
                                )
                                navController.navigate(AppScreens.CategoryScreen.route)
                            },
                            onGameClicked = { gameId ->
                                navController.navigate(
                                    AppScreens.GameScreen.createRoute(
                                        gameId
                                    )
                                )
                            }
                        )
                    }
                }
            }
        }

    )
}
