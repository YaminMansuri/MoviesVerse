package com.ymistudios.movieverse.ui.movie

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.ymistudios.movieverse.data.pojo.Movie
import com.ymistudios.movieverse.ui.theme.MoviesVerseTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieCard(movie: Movie, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.fillMaxWidth(),
        elevation = CardDefaults.elevatedCardElevation(),
        onClick = {}
    ) {
        AsyncImage(
            model = movie.poster,
            contentDescription = "Movie",
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop
        )
        Column(Modifier.padding(8.dp)) {
            Spacer(modifier = Modifier.height(2.dp))
            Text(text = movie.title ?: "", style = MoviesVerseTheme.typography.body)
            Text(
                text = movie.type ?: "",
                style = MoviesVerseTheme.typography.subTitle,
                color = MoviesVerseTheme.colors.subTitle
            )
        }
    }
}

@Preview
@Composable
fun MovieCardPrev() {
    MovieCard(
        Movie(
            title = "Avengers Endgame",
            poster = "https://images.unsplash.com/photo-1687125106218-3c7a1963bd6e?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxlZGl0b3JpYWwtZmVlZHw3fHx8ZW58MHx8fHx8&auto=format&fit=crop&w=500&q=60",
            releaseDate = "2016"
        )
    )
}