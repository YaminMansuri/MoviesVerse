package com.ymistudios.movieverse.ui.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ymistudios.movieverse.R
import com.ymistudios.movieverse.data.pojo.Movie
import com.ymistudios.movieverse.ui.destinations.MovieDetailsScreenDestination
import com.ymistudios.movieverse.ui.movie.MovieCard
import com.ymistudios.movieverse.ui.movie.movietype.MovieTypeList
import com.ymistudios.movieverse.ui.theme.MoviesVerseTheme

@Destination(start = true)
@Composable
fun HomeScreen(
    navigator: DestinationsNavigator,
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    val uiState by homeViewModel.uiState.collectAsStateWithLifecycle()
    Scaffold { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            HomeScreen(
                uiState = uiState,
                onEvent = homeViewModel::onEvent,
                onMovieItemClick = {
                    navigator.navigate(MovieDetailsScreenDestination(it))
                }
            )
        }
    }
}

@Composable
private fun HomeScreen(
    uiState: HomeViewModel.UIState,
    onEvent: (event: HomeEvent) -> Unit,
    onMovieItemClick: (movie: Movie) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = stringResource(id = R.string.app_name),
            style = MoviesVerseTheme.typography.title,
            modifier = Modifier.padding(start = HorizontalSpacing)
        )
        Spacer(modifier = Modifier.height(10.dp))
        TextField(
            value = uiState.search,
            onValueChange = { onEvent(HomeEvent.OnSearchChanged(it)) },
            placeholder = {
                Text(text = stringResource(R.string.hint_search))
            },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Search, contentDescription = "")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = HorizontalSpacing),
            shape = RoundedCornerShape(8.dp),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            keyboardActions = KeyboardActions(onSearch = {
                onEvent(HomeEvent.GetMovieList)
            }),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search)
        )
        Spacer(modifier = Modifier.height(12.dp))

        MovieTypeList(
            movieTypeList = uiState.movieTypeList,
            onMovieTypeClick = { movieType ->
                onEvent(HomeEvent.OnMovieTypeSelected(movieType))
            }, selectedMovieType = uiState.selectedMovieType
        )

        when {
            uiState.movie != null -> {
                Spacer(modifier = Modifier.height(8.dp))
                MovieCard(
                    movie = uiState.movie,
                    modifier = Modifier.padding(horizontal = HorizontalSpacing),
                    onMovieItemClick = onMovieItemClick
                )
            }

            uiState.error != null -> {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text(
                        text = uiState.error,
                        modifier = Modifier.padding(horizontal = HorizontalSpacing),
                        textAlign = TextAlign.Center
                    )
                }
            }

            uiState.loading -> {

            }

            else -> {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text(
                        text = stringResource(R.string.message_search_the_movie_to_start_watching_amazing_content),
                        modifier = Modifier.padding(horizontal = HorizontalSpacing),
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}

val HorizontalSpacing = 20.dp

@Preview
@Composable
fun HomeScreenPrev() {
    HomeScreen(uiState = HomeViewModel.UIState(), onEvent = {}, onMovieItemClick = {})
}
