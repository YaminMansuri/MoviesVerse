package com.ymistudios.movieverse.data.datastore

import androidx.datastore.preferences.core.booleanPreferencesKey

object UserDataStoreKey {
    val IS_USER_LOGGED_IN = booleanPreferencesKey("isUserLoggedIn")
    val SHOULD_SHOW_TUTORIAL_SCREEN = booleanPreferencesKey("shouldShowTutorialScreen")

    const val USER_DATA_STORE = "USER_DATA_STORE"
}