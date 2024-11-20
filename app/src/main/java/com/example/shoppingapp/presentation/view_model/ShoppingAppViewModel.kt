package com.example.shoppingapp.presentation.view_model

import androidx.lifecycle.ViewModel
import com.example.shoppingapp.domain.repo.ShoppingAppRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ShoppingAppViewModel @Inject constructor(val repo: ShoppingAppRepo): ViewModel(){
}