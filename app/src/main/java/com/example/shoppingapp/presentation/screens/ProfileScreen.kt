package com.example.shoppingapp.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.example.shoppingapp.presentation.view_model.ShoppingAppViewModel
import com.google.firebase.auth.FirebaseAuth

@Composable
fun ProfileScreen(viewModel: ShoppingAppViewModel, firebaseAuth: FirebaseAuth) {
    LaunchedEffect(key1 = true) {
        viewModel.getUserById(firebaseAuth.currentUser!!.uid)
    }

    Column {
        Text(text = "Profile Screen")
    }
}