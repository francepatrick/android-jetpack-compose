package com.app.android.arkboilerplate.screens

import android.util.Log
import androidx.compose.animation.*
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.app.android.jetpackcompose.components.AppBottomBarNavigation
import com.app.android.jetpackcompose.navigation.NavigationGraph
import com.app.android.jetpackcompose.viewmodel.SplashViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


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
