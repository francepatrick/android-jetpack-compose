package com.app.android.jetpackcompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.app.android.jetpackcompose.components.BottomBarItems

/***
 * Navigation Graph
 * @param navController NavHostController
 */
@Composable
fun NavigationGraph(navController: NavHostController){
    NavHost(navController = navController, startDestination = SplashRoute, route = RootRoute){
        /**
         * splash route
         */
        splashNavigationGraph(navHostController = navController)
        /**
         * authentication route
         */
        authNavigationGraph(navHostController = navController)
        /**
         * main menu route with bottom navigation
         */
        bottomNavigationGraph(navHostController = navController)
    }
}
