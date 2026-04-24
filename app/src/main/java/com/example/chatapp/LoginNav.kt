package com.example.chatapp

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

val LOGIN_OTHER = "login_other"
val LOGIN_PHONE = "login_phone"
val MAIN_PAGE = "main_page"
val LOGIN = "login"

@Composable
fun LoginNav() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = LOGIN
    ) {
        composable(route = LOGIN) {
            LoginScreen(navController)
        }
        composable(route = LOGIN_OTHER) {
            LoginOther(navController)
        }
        composable(route = LOGIN_PHONE) {
            LoginPhone(navController)
        }
        composable(route = MAIN_PAGE) {
            MainScreen(navController)
        }
    }
}