package com.example.shoppingapp.domain.use_case

import com.example.shoppingapp.domain.repo.ShoppingAppRepo
import javax.inject.Inject

class LoginUserUseCase @Inject constructor(val repo: ShoppingAppRepo) {
    suspend fun loginUser(email: String, password: String) = repo.loginUserWithEmailAndPassword(email, password)
}