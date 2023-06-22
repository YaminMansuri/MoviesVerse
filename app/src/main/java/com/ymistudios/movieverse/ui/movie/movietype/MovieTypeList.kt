package com.ymistudios.movieverse.ui.movie.movietype

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ymistudios.movieverse.ui.home.HorizontalSpacing

@Composable
fun MovieTypeList(
    movieTypeList: List<MovieType>,
    modifier: Modifier = Modifier,
    selectedMovieType: MovieType? = null,
    onMovieTypeClick: (movieType: MovieType) -> Unit
) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = HorizontalSpacing)
    ) {
        items(movieTypeList) { movieType ->
            MovieTypeCard(
                movieType = movieType,
                onMovieTypeClick = {
                    onMovieTypeClick(it)
                },
                selected = movieType.type == selectedMovieType?.type
            )
        }
    }
}