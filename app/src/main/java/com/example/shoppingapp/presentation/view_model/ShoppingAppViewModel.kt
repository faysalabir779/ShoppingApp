package com.example.shoppingapp.presentation.view_model

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shoppingapp.common.ResultState
import com.example.shoppingapp.domain.model.UserModel
import com.example.shoppingapp.domain.repo.ShoppingAppRepo
import com.example.shoppingapp.domain.use_case.CreateUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShoppingAppViewModel @Inject constructor(
    private val createUserUseCase: CreateUserUseCase
): ViewModel()
{
    private val _signUpState = MutableStateFlow(SignUpState())
    val signUpState = _signUpState.asStateFlow()

    fun createUser(userModel: UserModel){
        viewModelScope.launch {
            createUserUseCase.createUser(userModel).collectLatest {
                when(it){
                    is ResultState.Error -> {
                        _signUpState.value = SignUpState(error = it.message)
                    }
                    is ResultState.Loading -> {
                        _signUpState.value = SignUpState(isLoading = true)

                    }
                    is ResultState.Success -> {
                        _signUpState.value = SignUpState(isSuccess = it.data)
                    }
                }
            }
        }
    }

    fun resetIsSuccess(){
        _signUpState.update {
            it.copy(isSuccess = "")
        }
    }

    fun resetError(){
        _signUpState.update {
            it.copy(error = "")
        }
    }
}


data class SignUpState(
    val isLoading: Boolean = false,
    val isSuccess: String = "",
    val error: String = ""

)