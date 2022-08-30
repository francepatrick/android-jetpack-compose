package com.app.android.jetpackcompose.screens.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.app.android.jetpackcompose.R
import com.app.android.jetpackcompose.navigation.AuthenticationRoute
import com.app.android.jetpackcompose.navigation.HomeRoute
import com.app.android.jetpackcompose.navigation.RootRoute
import com.app.android.jetpackcompose.navigation.SplashRoute
import com.app.android.jetpackcompose.screens.auth.Auth
import com.app.android.jetpackcompose.viewmodel.SplashViewModel
import kotlinx.coroutines.delay


sealed class Splash(val route: String){
    object Loader : Splash(route = "default")
}

@Composable
fun SplashScreen(navHostController: NavHostController){
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.splash))
    val progress by animateLottieCompositionAsState(composition)
    val splashViewModel : SplashViewModel = viewModel()
    LaunchedEffect(Unit){
        delay(2500)
        splashViewModel.loadingDone()
        navHostController.navigate(HomeRoute){
            navHostController.backQueue.removeIf { it.destination.route == SplashRoute }
            navHostController.popBackStack()
        }
    }
    splashViewModel.loadingDone()
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(Color.White),
        verticalArrangement = Arrangement.Center
    ) {
        LottieAnimation(
            composition,
            progress,
        )
    }
}