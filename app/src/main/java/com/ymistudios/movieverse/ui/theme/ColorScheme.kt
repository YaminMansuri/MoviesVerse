package com.ymistudios.movieverse.ui.theme

import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Stable
class PicVerseColors(
    primary: Color,
    onPrimary: Color,
    background: Color,
    toolbar: Color,
    border: Color,
    icon: Color,
    title: Color,
    subTitle: Color,
    hint: Color,
    isDark: Boolean
) {
    var primary by mutableStateOf(primary)
        private set
    var onPrimary by mutableStateOf(onPrimary)
        private set
    var background by mutableStateOf(background)
        private set
    var toolbar by mutableStateOf(toolbar)
        private set
    var border by mutableStateOf(border)
        private set
    var icon by mutableStateOf(icon)
        private set
    var text by mutableStateOf(title)
        private set
    var subTitle by mutableStateOf(subTitle)
        private set
    var hint by mutableStateOf(hint)
        private set
    var isDark by mutableStateOf(isDark)
        private set

    fun update(other: PicVerseColors) {
        primary = other.primary
        onPrimary = other.onPrimary
        background = other.background
        toolbar = other.toolbar
        border = other.border
        icon = other.icon
        text = other.text
        subTitle = other.subTitle
        hint = other.hint
        isDark = other.isDark
    }

    fun copy(): PicVerseColors = PicVerseColors(
        primary = primary,
        onPrimary = onPrimary,
        background = background,
        toolbar = toolbar,
        border = border,
        icon = icon,
        title = text,
        subTitle = subTitle,
        hint = hint,
        isDark = isDark
    )
}

/* ------------- Light Color Schemes ------------- */
fun lightColorScheme() = PicVerseColors(
    primary = Purple40,
    onPrimary = Color.White,
    background = Color.White,
    toolbar = Color.White,
    border = Gray,
    icon = NavyBlue,
    title = NavyBlue,
    subTitle = BlueGray,
    hint = BlueGray,
    isDark = false
)

val LocalPicVerseColors = staticCompositionLocalOf {
    lightColorScheme()
}