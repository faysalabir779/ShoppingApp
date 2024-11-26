package com.example.shoppingapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.example.shoppingapp.presentation.screens.CartScreen
import com.example.shoppingapp.presentation.screens.CheckOutScreen
import com.example.shoppingapp.presentation.screens.HomeScreen
import com.example.shoppingapp.presentation.screens.LoginScreen
import com.example.shoppingapp.presentation.screens.ProductDetailsScreen
import com.example.shoppingapp.presentation.screens.ProfileScreen
import com.example.shoppingapp.presentation.screens.SignUpScreen
import com.example.shoppingapp.presentation.screens.WishListScreen
import com.example.shoppingapp.presentation.view_model.ShoppingAppViewModel
import com.google.firebase.auth.FirebaseAuth

@Composable
fun App(viewModel: ShoppingAppViewModel, firebaseAuth: FirebaseAuth) {
    val navController = rememberNavController()
    var startScreen = if (firebaseAuth.currentUser == null) {
        SubNavigation.LoginSignupScreenRoute
    } else {
        SubNavigation.MainHomeScreenRoute
    }
    NavHost(
        navController = navController,
        startDestination = startScreen
    ) {



        navigation<SubNavigation.LoginSignupScreenRoute>(startDestination = LoginRoute) {
            composable<LoginRoute> {
                LoginScreen(navController, viewModel)
            }
            composable<SignUpRoute> {
                SignUpScreen(navController, viewModel)
            }
        }

        navigation<SubNavigation.MainHomeScreenRoute>(startDestination = ProfileRoute) {
            composable<HomeRoute> {
                HomeScreen()
            }
            composable<WishListRoute> {
                WishListScreen()
            }
            composable<CartRoute> {
                CartScreen()
            }
            composable<ProfileRoute> {
                ProfileScreen(viewModel,firebaseAuth)
            }
        }

        composable<ProductDetailsRoute> {
            ProductDetailsScreen()
        }
        composable<CheckOutRoute> {
            CheckOutScreen()
        }


    }
}