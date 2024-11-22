package com.example.shoppingapp.domain.repo


import com.example.shoppingapp.common.ResultState
import com.example.shoppingapp.domain.model.UserModel
import com.google.firebase.firestore.core.UserData
import kotlinx.coroutines.flow.Flow


interface ShoppingAppRepo {

    suspend fun registerUserWithEmailAndPassword(userModel: UserModel): Flow<ResultState<String>>
}