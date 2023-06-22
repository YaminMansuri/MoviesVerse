package com.ymistudios.movieverse.ui.home

import com.ymistudios.movieverse.ui.movie.movietype.MovieType

sealed class HomeEvent {
    data class OnSearchChanged(val search: String) : HomeEvent()
    data class OnMovieTypeSelected(val movieType: MovieType) : HomeEvent()
    object GetMovieList : HomeEvent()
}