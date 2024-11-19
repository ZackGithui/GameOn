package com.example.gameon


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.gameon.presentation.homeScreen.HomeScreen
import com.example.gameon.ui.theme.GameOnTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            GameOnTheme {
                HomeScreen()

            }
        }
    }
}

