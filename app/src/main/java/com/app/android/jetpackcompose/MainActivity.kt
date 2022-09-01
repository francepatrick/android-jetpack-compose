package com.app.android.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.app.android.arkboilerplate.screens.MainApplicationScreen
import com.app.android.jetpackcompose.ui.theme.JetpackComposeTheme
import com.app.android.jetpackcompose.viewmodel.splash.SplashViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: SplashViewModel by viewModels()
        setContent {
            JetpackComposeTheme {
                MainApplicationScreen(viewModel)
            }
        }
    }
}