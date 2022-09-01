package com.app.android.jetpackcompose.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.app.android.arkboilerplate.screens.HomeScreen
import com.app.android.arkboilerplate.screens.ProfileScreen
import com.app.android.arkboilerplate.screens.SettingsScreen
import com.app.android.jetpackcompose.components.BottomBarItems
import com.app.android.jetpackcompose.screens.detail.DetailScreen

fun NavGraphBuilder.mainNavigationGraph(navHostController: NavHostController){
    navigation(
        startDestination = BottomBarItems.Home.route,
        route = HomeRoute
    ){

        /***
         * Bottom navigation
         */
        composable(route = BottomBarItems.Home.route){
            HomeScreen(navHostController)
        }
        composable(route = BottomBarItems.Setting.route){
            SettingsScreen()
        }
        composable(route = BottomBarItems.Profile.route){
            ProfileScreen()
        }

        /***
         * Detail screens
         */
        composable(route = DetailRoute){
            DetailScreen(navHostController)
        }
    }
}