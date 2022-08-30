package com.app.android.arkboilerplate.screens

import android.provider.Settings
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun SettingsScreen(){
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.White),
        contentAlignment = Alignment.Center) {
        Text(text = "Settings Screen", color = Color.Black)
    }
}