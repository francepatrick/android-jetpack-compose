package com.app.android.jetpackcompose.viewmodel

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel



class SplashViewModel : ViewModel(){

    var state by mutableStateOf(false)
        private set

    fun loadingDone() {
        state = true
    }

}
