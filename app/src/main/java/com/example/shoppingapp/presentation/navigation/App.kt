package com.example.shoppingapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.shoppingapp.presentation.screens.CompleteSignUpBox
import com.example.shoppingapp.presentation.screens.LoginScreen
import com.example.shoppingapp.presentation.screens.SignUpScreen

@Composable
fun App(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = LoginRoute ){
        composable<LoginRoute> {
            LoginScreen(navController)
        }
        composable<SignUpRoute> {
            SignUpScreen(navController)
        }
    }
}