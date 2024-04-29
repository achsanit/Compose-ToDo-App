package com.achsanit.todolistapp.foundation.navigation

sealed class RouteScreen(val name: String) {
    object Home: RouteScreen("home-root"){
        val route = name
    }
    object Login: RouteScreen("login-root"){
        val route = name
    }
    object DetailToDo: RouteScreen("detail-todo-root"){
        val route = name
    }

}