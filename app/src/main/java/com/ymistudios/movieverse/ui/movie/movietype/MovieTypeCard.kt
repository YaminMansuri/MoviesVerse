package com.ymistudios.movieverse.ui.movie.movietype

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.ymistudios.movieverse.ui.theme.MoviesVerseTheme
import com.ymistudios.movieverse.ui.theme.NavyBlue
import com.ymistudios.movieverse.utils.capitalizeFirstLetter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieTypeCard(
    movieType: MovieType,
    onMovieTypeClick: (movieType: MovieType) -> Unit,
    modifier: Modifier = Modifier,
    selected: Boolean = false
) {
    Card(
        modifier = modifier
            .size(width = 180.dp, height = 80.dp),
        onClick = {
            onMovieTypeClick(movieType)
        },
        border = BorderStroke(3.dp, MoviesVerseTheme.colors.primary).takeIf { selected }
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            AsyncImage(
                model = movieType.image,
                contentDescription = "",
                modifier = Modifier
                    .fillMaxSize()
                    .drawWithCache {
                        val gradient = Brush.verticalGradient(
                            colors = listOf(Color.Transparent, NavyBlue.copy(alpha = 0.5f))
                        )
                        onDrawWithContent {
                            drawContent()
                            drawRect(gradient, blendMode = BlendMode.Multiply)
                        }
                    },
                contentScale = ContentScale.Crop
            )
            Text(
                text = movieType.type.capitalizeFirstLetter(),
                style = MoviesVerseTheme.typography.subTitle,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(bottom = 8.dp, end = 15.dp),
                color = Color.White
            )
        }
    }
}

@Preview
@Composable
fun MovieTypeCardPrev() {
    MovieTypeCard(
        movieType = MovieType(
            type = "Movie",
            image = "https://images.unsplash.com/photo-1579445710183-f9a816f5da05?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8YXZlbmdlcnMlMjBlbmRnYW1lfGVufDB8fDB8fHww&auto=format&fit=crop&w=500&q=60"
        ), onMovieTypeClick = {}
    )
}