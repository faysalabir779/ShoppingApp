package com.example.shoppingapp.domain.repo


import com.example.shoppingapp.common.ResultState
import com.example.shoppingapp.domain.model.UserDataParent
import com.example.shoppingapp.domain.model.UserModel
import com.google.firebase.firestore.core.UserData
import kotlinx.coroutines.flow.Flow


interface ShoppingAppRepo {

    suspend fun registerUserWithEmailAndPassword(userModel: UserModel): Flow<ResultState<String>>
    suspend fun loginUserWithEmailAndPassword(email: String, password: String): Flow<ResultState<String>>
    suspend fun getUserById(uid: String): Flow<ResultState<UserDataParent>>

}