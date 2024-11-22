package com.example.shoppingapp.data.repo

import com.example.shoppingapp.common.ResultState
import com.example.shoppingapp.domain.model.UserModel
import com.example.shoppingapp.domain.repo.ShoppingAppRepo
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

class ShoppingAppRepoImpl @Inject constructor(
    private val firestore: FirebaseFirestore,
    private val firebaseAuth: FirebaseAuth
) :
    ShoppingAppRepo {

    //signUp
    override suspend fun registerUserWithEmailAndPassword(userModel: UserModel): Flow<ResultState<String>> =
        callbackFlow {
            trySend(ResultState.Loading)

            firebaseAuth.createUserWithEmailAndPassword(userModel.email, userModel.password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        trySend(ResultState.Success("Success"))
                    } else {
                        trySend(ResultState.Error(task.exception?.message.toString()))
                    }

                }
            awaitClose {
                close()
            }
        }
}