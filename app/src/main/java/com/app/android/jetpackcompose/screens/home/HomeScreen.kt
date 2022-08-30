package com.app.android.arkboilerplate.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import com.app.android.jetpackcompose.viewmodel.SplashViewModel


@Composable
fun HomeScreen(){
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.White),
        contentAlignment = Alignment.Center) {
        Text(text = "Home Screen", color = Color.Black)
    }
}