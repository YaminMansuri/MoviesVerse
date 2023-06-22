package com.ymistudios.movieverse.ui.movie.moviedetails

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ymistudios.movieverse.data.pojo.Movie
import com.ymistudios.movieverse.ui.components.Toolbar
import com.ymistudios.movieverse.ui.home.HorizontalSpacing
import com.ymistudios.movieverse.ui.theme.MoviesVerseTheme
import com.ymistudios.movieverse.ui.theme.NavyBlue

@OptIn(ExperimentalMaterial3Api::class)
@Destination
@Composable
fun MovieDetailsScreen(movie: Movie, navigator: DestinationsNavigator) {
    Scaffold(modifier = Modifier.fillMaxSize()) { paddingValues ->
        Box(
            modifier = Modifier.padding(paddingValues)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                AsyncImage(
                    model = movie.poster,
                    contentDescription = "",
                    modifier = Modifier
                        .aspectRatio(1.2f)
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

                Spacer(modifier = Modifier.height(12.dp))
                Column(modifier = Modifier.padding(horizontal = HorizontalSpacing)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Card {
                            Text(
                                text = movie.rated ?: "",
                                style = MoviesVerseTheme.typography.subTitle,
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                            )
                        }
                        Card {
                            Text(
                                text = movie.genre ?: "",
                                style = MoviesVerseTheme.typography.subTitle,
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(15.dp))

                    Text(
                        text = movie.title ?: "",
                        style = MoviesVerseTheme.typography.title,
                        color = MoviesVerseTheme.colors.text
                    )

                    Text(text = movie.plot ?: "")
                }
            }
            Toolbar(
                title = {},
                navigationIcon = {
                    IconButton(onClick = { navigator.popBackStack() }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = Color.Transparent)
            )
        }
    }
}

@Preview
@Composable
fun MovieDetailsScreenPrev() {
    //MovieDetailsScreen()
}
