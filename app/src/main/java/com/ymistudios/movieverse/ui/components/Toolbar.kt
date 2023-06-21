package com.ymistudios.movieverse.ui.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ymistudios.movieverse.ui.theme.MoviesVerseTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Toolbar(
    title: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    titleAlignment: TitleAlignment = TitleAlignment.Center,
    navigationIcon: @Composable () -> Unit = {},
    actions: @Composable RowScope.() -> Unit = {},
    windowInsets: WindowInsets = TopAppBarDefaults.windowInsets,
    colors: TopAppBarColors = TopAppBarDefaults.centerAlignedTopAppBarColors(/*containerColor = PicVerseTheme.colors.toolbar*/),
    scrollBehavior: TopAppBarScrollBehavior? = null
) {
    val titleWithTextStyle = @Composable {
        ProvideTextStyle(value = MoviesVerseTheme.typography.toolbarTitle) {
            title()
        }
    }
    if (titleAlignment == TitleAlignment.Center)
        CenterAlignedTopAppBar(
            title = titleWithTextStyle,
            modifier = modifier,
            navigationIcon = navigationIcon,
            actions = actions,
            windowInsets = windowInsets,
            colors = colors,
            scrollBehavior = scrollBehavior
        )
    else
        TopAppBar(
            title = titleWithTextStyle,
            modifier = modifier,
            navigationIcon = navigationIcon,
            actions = actions,
            windowInsets = windowInsets,
            colors = colors,
            scrollBehavior = scrollBehavior
        )
}

enum class TitleAlignment {
    Start,
    Center
}
