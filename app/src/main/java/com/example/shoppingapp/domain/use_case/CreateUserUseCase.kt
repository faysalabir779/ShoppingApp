package com.example.shoppingapp.domain.use_case

import com.example.shoppingapp.common.ResultState
import com.example.shoppingapp.domain.model.UserModel
import com.example.shoppingapp.domain.repo.ShoppingAppRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CreateUserUseCase @Inject constructor(private val repo: ShoppingAppRepo) {
    suspend fun createUser(userModel: UserModel): Flow<ResultState<String>> {
       return repo.registerUserWithEmailAndPassword(userModel)
    }
}