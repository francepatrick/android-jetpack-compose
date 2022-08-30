package com.app.android.jetpackcompose.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.app.android.jetpackcompose.screens.splash.Splash
import com.app.android.jetpackcompose.screens.splash.SplashScreen

fun NavGraphBuilder.splashNavigationGraph(navHostController: NavHostController){
    navigation(
        startDestination = Splash.Loader.route,
        route = SplashRoute
    ){
        composable(route = Splash.Loader.route){
            SplashScreen(navHostController = navHostController)
        }
    }
}