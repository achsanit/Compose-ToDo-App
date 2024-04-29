package com.achsanit.todolistapp.foundation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.achsanit.todolistapp.features.home.HomeScreen
import com.achsanit.todolistapp.features.login.ui.DetailScreen
import com.achsanit.todolistapp.features.login.ui.LoginScreen

@Composable
fun NavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = RouteScreen.Home.route
    ) {
        composable(route = RouteScreen.Login.route) {
            LoginScreen {
                navController.navigate(route = RouteScreen.Home.route)
            }
        }
        composable(route = RouteScreen.Home.route) {
            HomeScreen(navController = navController) {
                navController.navigate(route = RouteScreen.DetailToDo.route)
            }
        }
        composable(route = RouteScreen.DetailToDo.route) {
            DetailScreen()
        }
    }
}