package com.ymistudios.movieverse.data.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class UserDataStoreImpl @Inject constructor(
    private val dataStore: DataStore<Preferences>
) : UserDataStore {

    override val isUserLoggedIn: Flow<Boolean>
        get() = dataStore.data.map { preferences ->
            preferences[UserDataStoreKey.IS_USER_LOGGED_IN] ?: false
        }

    override suspend fun saveIsUserLoggedIn(isUserLoggedIn: Boolean) {
        dataStore.edit { preferences ->
            preferences[UserDataStoreKey.IS_USER_LOGGED_IN] = isUserLoggedIn
        }
    }

    override val shouldShowTutorialScreen: Flow<Boolean>
        get() = dataStore.data.map { preferences ->
            preferences[UserDataStoreKey.SHOULD_SHOW_TUTORIAL_SCREEN] ?: true
        }

    override suspend fun saveShouldShowTutorialScreen(shouldShowTutorialScreen: Boolean) {
        dataStore.edit { preferences ->
            preferences[UserDataStoreKey.SHOULD_SHOW_TUTORIAL_SCREEN] = shouldShowTutorialScreen
        }
    }
}