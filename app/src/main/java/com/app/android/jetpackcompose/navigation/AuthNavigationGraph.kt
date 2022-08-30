package com.app.android.jetpackcompose.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.app.android.jetpackcompose.screens.auth.Auth
import com.app.android.jetpackcompose.screens.auth.AuthScreen

fun NavGraphBuilder.authNavigationGraph(navHostController: NavHostController){
    navigation(
        startDestination = Auth.Login.route,
        route = AuthenticationRoute
    ){
        composable(route = Auth.Login.route){
            AuthScreen(navHostController = navHostController)
        }
    }
}