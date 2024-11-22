package com.example.shoppingapp.domain.di

import com.example.shoppingapp.data.repo.ShoppingAppRepoImpl
import com.example.shoppingapp.domain.repo.ShoppingAppRepo
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Provides
    @Singleton
    fun provideRepo(firestore: FirebaseFirestore, firebaseAuth: FirebaseAuth): ShoppingAppRepo {
        return ShoppingAppRepoImpl(firestore = firestore, firebaseAuth = firebaseAuth)
    }
}