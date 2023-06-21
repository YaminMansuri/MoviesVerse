package com.ymistudios.movieverse.ui

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.animations.rememberAnimatedNavHostEngine
import com.ymistudios.movieverse.ui.destinations.HomeScreenDestination
import com.ymistudios.movieverse.ui.theme.MoviesVerseTheme

@OptIn(
    ExperimentalMaterialNavigationApi::class, ExperimentalAnimationApi::class
)
@Composable
fun MoviesVerseApp() {
    MoviesVerseTheme {
        val engine = rememberAnimatedNavHostEngine()
        val navController = engine.rememberNavController()

        DestinationsNavHost(
            engine = engine,
            navController = navController,
            navGraph = NavGraphs.root,
            startRoute = HomeScreenDestination
        )
    }
}