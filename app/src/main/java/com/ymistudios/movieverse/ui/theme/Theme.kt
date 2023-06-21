package com.ymistudios.movieverse.ui.theme

import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun MoviesVerseTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = lightColorScheme()

    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setSystemBarsColor(color = Color.White)
    }

    ProvideMoviesVerseTheme(colors = colors, content = content)
}

@Composable
fun ProvideMoviesVerseTheme(
    colors: PicVerseColors = MoviesVerseTheme.colors,
    typography: Typography = MoviesVerseTheme.typography,
    content: @Composable () -> Unit
) {
    val colorPalette = remember {
        colors.copy()
    }

    colorPalette.update(colors)

    val rippleIndication = rememberRipple()

    CompositionLocalProvider(
        LocalPicVerseColors provides colorPalette,
        LocalIndication provides rippleIndication,
        LocalTypography provides MoviesVerseTheme.typography
    ) {
        ProvideTextStyle(value = typography.body, content = content)
    }
}

object MoviesVerseTheme {
    val colors: PicVerseColors
        @Composable
        get() = LocalPicVerseColors.current

    val typography: Typography
        @Composable
        get() = LocalTypography.current
}
