package com.app.android.jetpackcompose.components

import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.app.android.jetpackcompose.R

/***
 * Bottom Bar Items
 * @param route Navigation route
 * @param title Navigation title
 * @param icon Navigation icon
 */
sealed class BottomBarItems (
    val route: String,
    val title: String,
    val icon: ImageVector
){
    /***
     * Put all bottom bar items here
     */
    object Home: BottomBarItems(
        route = "home",
        title = "Home",
        icon = Icons.Default.Home
    )
    object Profile: BottomBarItems(
        route = "profile",
        title = "Profile",
        icon = Icons.Default.AccountBox
    )
    object Setting: BottomBarItems(
        route = "settings",
        title = "Setting",
        icon = Icons.Default.Settings
    )
}

/***
 * App Bottom Bar Navigation Controller
 * @param navController NavHostController
 */
@Composable
fun AppBottomBarNavigation(navController: NavHostController){
    val screens = listOf(
        BottomBarItems.Home,
        BottomBarItems.Profile,
        BottomBarItems.Setting,
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomNavigation(
        modifier = Modifier.graphicsLayer {
            shape = RoundedCornerShape(
                topStart = 15.dp,
                topEnd = 15.dp,
            )
            clip = true
        },
        backgroundColor = colorResource(R.color.orange_500),
        contentColor = androidx.compose.ui.graphics.Color.White
    ) {
        screens.forEach {
            BottomNavigationItem(
                label = {
                    Text(text = it.title)
                },
                icon = {
                    Icon(imageVector = it.icon, contentDescription = "navigation icon")
                },
                selected = currentDestination?.hierarchy?.any { s -> s.route == it.route } == true,
                selectedContentColor = colorResource(R.color.amber),
                unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
                onClick = {
                    navController.navigate(it.route){
                        popUpTo(navController.graph.findStartDestination().id)
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}