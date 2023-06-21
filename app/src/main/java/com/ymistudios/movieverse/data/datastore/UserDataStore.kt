package com.ymistudios.movieverse.data.datastore

import kotlinx.coroutines.flow.Flow

interface UserDataStore {

    val isUserLoggedIn: Flow<Boolean>
    suspend fun saveIsUserLoggedIn(isUserLoggedIn: Boolean)

    val shouldShowTutorialScreen: Flow<Boolean>
    suspend fun saveShouldShowTutorialScreen(shouldShowTutorialScreen: Boolean)
}