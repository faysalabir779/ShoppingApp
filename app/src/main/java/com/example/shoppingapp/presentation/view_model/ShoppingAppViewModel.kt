package com.example.shoppingapp.presentation.view_model

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shoppingapp.common.ResultState
import com.example.shoppingapp.domain.model.UserDataParent
import com.example.shoppingapp.domain.model.UserModel
import com.example.shoppingapp.domain.repo.ShoppingAppRepo
import com.example.shoppingapp.domain.use_case.CreateUserUseCase
import com.example.shoppingapp.domain.use_case.GetUserByIdUseCase
import com.example.shoppingapp.domain.use_case.LoginUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShoppingAppViewModel @Inject constructor(
    private val createUserUseCase: CreateUserUseCase,
    private val loginUserUseCase: LoginUserUseCase,
    private val getUserByIdUseCase: GetUserByIdUseCase
): ViewModel()
{
    private val _signUpState = MutableStateFlow(SignUpState())
    val signUpState = _signUpState.asStateFlow()

    private val _loginState = MutableStateFlow(LoginState())
    val loginState = _loginState.asStateFlow()

    private val _getUserById = MutableStateFlow(GetUser())
    val getUserById = _getUserById.asStateFlow()

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

    fun loginUser(email: String, password: String){
        viewModelScope.launch {
            loginUserUseCase.loginUser(email, password).collectLatest {
                when(it){
                    is ResultState.Error -> {
                        _loginState.value = LoginState(error = it.message)
                    }
                    is ResultState.Loading -> {
                        _loginState.value = LoginState(isLoading = true)

                    }
                    is ResultState.Success -> {
                        _loginState.value = LoginState(isSuccess = it.data)
                    }
                }
            }
        }
    }

    fun getUserById(uid: String){
        viewModelScope.launch {
            getUserByIdUseCase.getUserById(uid).collectLatest {
                when(it){
                    is ResultState.Error -> {
                        _getUserById.value = GetUser(error = it.message)
                    }
                    is ResultState.Loading -> {
                        _getUserById.value = GetUser(isLoading = true)

                    }
                    is ResultState.Success -> {
                        _getUserById.value = GetUser(isSuccess = it.data)
                    }
                }
                Log.d("issuccess", "getUserById: ${getUserById.value.isSuccess}")
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

    fun resetLoginSuccess(){
        _loginState.update {
            it.copy(isSuccess = "")
        }
    }
}

data class GetUser(
    val isLoading: Boolean = false,
    val isSuccess: UserDataParent? = null,
    val error: String = ""
)


data class LoginState(
    val isLoading: Boolean = false,
    val isSuccess: String = "",
    val error: String = ""
)


data class SignUpState(
    val isLoading: Boolean = false,
    val isSuccess: String = "",
    val error: String = ""

)