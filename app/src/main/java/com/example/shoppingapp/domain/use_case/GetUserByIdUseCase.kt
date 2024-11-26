package com.example.shoppingapp.domain.use_case

import com.example.shoppingapp.common.ResultState
import com.example.shoppingapp.domain.model.UserDataParent
import com.example.shoppingapp.domain.repo.ShoppingAppRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetUserByIdUseCase @Inject constructor(private val repo: ShoppingAppRepo){
    suspend fun getUserById(uid: String): Flow<ResultState<UserDataParent>> {
       return repo.getUserById(uid)
    }
}