package com.example.shoppingapp.data.repo

import com.example.shoppingapp.common.ResultState
import com.example.shoppingapp.common.USER_COLLECTION
import com.example.shoppingapp.domain.model.UserDataParent
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
                        firestore.collection(USER_COLLECTION)
                            .document(task.result.user?.uid.toString()).set(userModel)
                            .addOnCompleteListener {
                                if (it.isSuccessful) {
                                    trySend(ResultState.Success("Success"))
                                } else {
                                    trySend(ResultState.Error(it.exception?.message.toString()))
                                }
                            }
                        trySend(ResultState.Success("Success"))
                    } else {
                        trySend(ResultState.Error(task.exception?.message.toString()))
                    }

                }
            awaitClose {
                close()
            }
        }

    override suspend fun loginUserWithEmailAndPassword(email: String, password: String): Flow<ResultState<String>> =
        callbackFlow {
            trySend(ResultState.Loading)
            firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener{
                if (it.isSuccessful){
                    trySend(ResultState.Success("Success"))
                }else{
                    trySend(ResultState.Error(it.exception?.message.toString()))
                }
            }

            awaitClose{
                close()
            }
        }

    override suspend fun getUserById(uid: String): Flow<ResultState<UserDataParent>> = callbackFlow {
        trySend(ResultState.Loading)
        firestore.collection(USER_COLLECTION).document(uid).get().addOnCompleteListener{
            if (it.isSuccessful){
               val data = it.result.toObject(UserModel::class.java)!!
                val userDataParent = UserDataParent(it.result.id, data)
                trySend(ResultState.Success(userDataParent))
            }else{
                if (it.exception != null){
                    trySend(ResultState.Error(it.exception?.localizedMessage.toString()))
                }
            }
        }
        awaitClose{
            close()
        }
    }
}