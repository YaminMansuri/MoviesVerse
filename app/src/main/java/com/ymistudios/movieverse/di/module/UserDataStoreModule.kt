package com.ymistudios.movieverse.di.module

import com.ymistudios.movieverse.data.datastore.UserDataStore
import com.ymistudios.movieverse.data.datastore.UserDataStoreImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class UserDataStoreModule {

    @Binds
    @Singleton
    abstract fun bindUserDataStore(userDataStoreImpl: UserDataStoreImpl): UserDataStore
}