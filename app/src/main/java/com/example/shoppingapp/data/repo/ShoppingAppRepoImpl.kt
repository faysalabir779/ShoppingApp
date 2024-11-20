package com.example.shoppingapp.data.repo

import com.example.shoppingapp.domain.repo.ShoppingAppRepo
import com.google.firebase.firestore.FirebaseFirestore
import javax.inject.Inject

class ShoppingAppRepoImpl @Inject constructor(private val firestore: FirebaseFirestore): ShoppingAppRepo {
}