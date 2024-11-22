package com.example.shoppingapp.presentation.navigation

import kotlinx.serialization.Serializable

sealed class SubNavigation{
    @Serializable
    object MainHomeScreenRoute: SubNavigation()

    @Serializable
    object LoginSignupScreenRoute: SubNavigation()
}


@Serializable
object LoginRoute

@Serializable
object SignUpRoute



@Serializable
object HomeRoute

@Serializable
object WishListRoute

@Serializable
object CartRoute

@Serializable
object ProfileRoute

@Serializable
object ProductDetailsRoute

@Serializable
object CheckOutRoute

