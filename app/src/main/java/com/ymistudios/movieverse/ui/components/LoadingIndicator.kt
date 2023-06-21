package com.ymistudios.movieverse.ui.components

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.StartOffset
import androidx.compose.animation.core.animate
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.ymistudios.movieverse.ui.theme.MoviesVerseTheme

@Composable
fun LoadingDot(
    modifier: Modifier = Modifier,
    color: Color = MoviesVerseTheme.colors.primary
) {
    Box(
        modifier = modifier
            .clip(CircleShape)
            .background(color = color)
    )
}

@Composable
fun LoadingIndicator(
    animating: Boolean,
    modifier: Modifier = Modifier,
    color: Color = MoviesVerseTheme.colors.primary,
    indicatorSpacing: Dp = IndicatorSpacing,
    indicatorCount: Int = IndicatorCount,
    indicatorSize: Int = IndicatorSize,
    animationDurationMillis: Int = AnimationDurationMillis
) {
    val animatedValues = List(indicatorCount) { index ->
        var animatedValues by remember(animating) { mutableFloatStateOf(0f) }
        LaunchedEffect(animating) {
            if (animating) {
                animate(
                    initialValue = indicatorSize / 2f,
                    targetValue = -(indicatorSize / 2f),
                    animationSpec = infiniteRepeatable(
                        animation = tween(durationMillis = animationDurationMillis),
                        repeatMode = RepeatMode.Reverse,
                        initialStartOffset = StartOffset((animationDurationMillis / indicatorCount) * index) // For creating staggered effect of dots.
                    )
                ) { value, _ ->
                    animatedValues = value
                }
            }
        }
        animatedValues
    }

    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        animatedValues.forEach { animatedValue ->
            LoadingDot(
                modifier = Modifier
                    .padding(horizontal = indicatorSpacing)
                    .width(indicatorSize.dp)
                    .aspectRatio(1f)
                    .offset(y = animatedValue.dp),
                color = color
            )
        }
    }
}

private val IndicatorSpacing = 5.dp
private const val IndicatorCount = 3
private const val IndicatorSize = 15
private const val AnimationDurationMillis = 300