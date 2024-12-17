package com.example.gameon.presentation.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.gameon.presentation.search.components.SearchedItem

@Composable
fun SearchScreen(
    viewModel: SearchViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    val state = viewModel.searchState.collectAsStateWithLifecycle().value
    var text by remember { mutableStateOf(state.query) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(10.dp)
    ) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = text,
            onValueChange = {
                text = it
                viewModel.onEvent(SearchEvents.OnValueChanged(it)) // Notify ViewModel of changes
            },
            placeholder = { Text("Search...") },
            shape = RoundedCornerShape(10.dp),
            singleLine = true,
            leadingIcon = {
                Icon(imageVector = Icons.Default.Search, contentDescription = "Search Icon")
            },
            trailingIcon = {
                if (text.isNotEmpty()) {
                    IconButton(onClick = {
                        text = ""
                        viewModel.onEvent(SearchEvents.OnValueChanged("")) // Clear query
                    }) {
                        Icon(imageVector = Icons.Default.Close, contentDescription = "Clear Search")
                    }
                }
            }
        )

        LazyColumn(modifier = Modifier.padding(top = 16.dp)) {
            if (state.result.isNotEmpty()) {
                items(state.result) { game ->
                    SearchedItem(game = game)
                }
            } else if (text.isNotEmpty() && state.result.isEmpty()) {
                item {
                    Text(
                        text = "No results found.",
                        modifier = Modifier.padding(top = 16.dp)
                    )
                }
            }
        }
    }
}
