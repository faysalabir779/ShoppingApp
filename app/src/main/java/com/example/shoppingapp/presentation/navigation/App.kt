package com.example.shoppingapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.shoppingapp.presentation.screens.LoginScreen
import com.example.shoppingapp.presentation.screens.SignUpScreen
import com.example.shoppingapp.presentation.view_model.ShoppingAppViewModel

@Composable
fun App(viewModel: ShoppingAppViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = LoginRoute ){
        composable<LoginRoute> {
            LoginScreen(navController, viewModel)
        }
        composable<SignUpRoute> {
            SignUpScreen(navController, viewModel)
        }
    }
}