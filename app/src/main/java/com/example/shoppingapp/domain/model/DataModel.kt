package com.example.shoppingapp.domain.model

data class UserModel (
    val name: String = "",
    val email: String = "",
    val password: String = "",
)

data class UserDataParent(val nodeId: String = "", val userModel: UserModel = UserModel())