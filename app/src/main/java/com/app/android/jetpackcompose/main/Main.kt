package com.app.android.arkboilerplate.screens

import android.util.Log
import androidx.compose.animation.*
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.navigation.compose.rememberNavController
import com.app.android.jetpackcompose.components.AppBottomBarNavigation
import com.app.android.jetpackcompose.navigation.NavigationGraph
import com.app.android.jetpackcompose.viewmodel.splash.SplashViewModel


@Composable
fun MainApplicationScreen(viewModel: SplashViewModel) {
    val navController = rememberNavController()
    var isSplash by remember { mutableStateOf(false) }
    Log.d("FRANCE", "${viewModel.state}")
    Scaffold(bottomBar = {
        AnimatedVisibility(
            visible = true,
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            AppBottomBarNavigation(navController)
        }
    }) {
        NavigationGraph(navController = navController)
    }
}
