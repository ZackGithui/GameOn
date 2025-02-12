package com.example.gameon.presentation.category

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun CategoryScreen(
    viewModel: CategoryViewModel = hiltViewModel()
) {
    viewModel
    val state = viewModel.categoryState.collectAsState().value
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.onPrimary)
            .padding(15.dp)
    ) {
        if (state.shooting.isNotEmpty()) {
            items(state.shooting) {
                CategoryItem(games = state.shooting)
            }
        } else if (state.racing.isNotEmpty()) {
            items(state.racing) {
                CategoryItem(games = state.racing)
            }
        }
    }
}
