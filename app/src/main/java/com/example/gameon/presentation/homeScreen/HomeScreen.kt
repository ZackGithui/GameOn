package com.example.gameon.presentation.homeScreen
import com.example.gameon.presentation.components.GameCard
import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.gameon.presentation.components.TopPart


@Composable
fun HomeScreen(viewModel: GamesViewModel = hiltViewModel()) {

    val state = viewModel.uiState.collectAsStateWithLifecycle().value

    Log.d(TAG, "shooterGames loaded: ${state.shooterGames.isNotEmpty()}")

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background),
        topBar = { TopPart() },
        content = { paddingValues ->
            LazyColumn(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()

            ) {
                if (state.shooterGames.isNotEmpty()) {
                    item {
                        GameCard(
                            games = state.shooterGames,
                            text = "Shooting",
                            onLabelButtonClicked = {}
                        )
                    }
                }
                if(state.racing.isNotEmpty()){
                    item {
                        GameCard(games = state.racing,
                            text ="Racing",
                            onLabelButtonClicked = {})
                    }
                }


            }

        },


        )
}