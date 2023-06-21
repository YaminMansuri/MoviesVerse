package com.ymistudios.movieverse.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.ymistudios.movieverse.R

val poppins = FontFamily(
    Font(R.font.poppins_regular, FontWeight.Normal),
    Font(R.font.poppins_medium, FontWeight.Medium),
    Font(R.font.poppins_semi_bold, FontWeight.SemiBold),
    Font(R.font.poppins_bold, FontWeight.Bold),
    Font(R.font.poppins_extra_bold, FontWeight.ExtraBold),
    Font(R.font.poppins_black, FontWeight.Black)
)

val poppinsTextStyle =
    TextStyle(platformStyle = PlatformTextStyle(includeFontPadding = false), fontFamily = poppins)

@Immutable
class Typography(
    val toolbarTitle: TextStyle = poppinsTextStyle.copy(
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp
    ),

    val title: TextStyle = poppinsTextStyle.copy(
        fontWeight = FontWeight.SemiBold,
        fontSize = 22.sp
    ),

    val subTitle: TextStyle = poppinsTextStyle.copy(
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        platformStyle = PlatformTextStyle(includeFontPadding = false)
    ),

    val body: TextStyle = poppinsTextStyle.copy(
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),

    val textFieldHint: TextStyle = poppinsTextStyle.copy(
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),

    val textField: TextStyle = poppinsTextStyle.copy(
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp
    ),

    val textFieldError: TextStyle = poppinsTextStyle.copy(
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
)

val LocalTypography = staticCompositionLocalOf {
    Typography()
}