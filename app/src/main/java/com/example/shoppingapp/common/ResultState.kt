package com.example.shoppingapp.common

sealed class ResultState<out T> {
    data class Success<out T>(val data: T) : ResultState<T>()
    data class Error(val message: String) : ResultState<String>()
    object Loading : ResultState<Nothing>()

}