package com.ymistudios.movieverse.ui.home

sealed class HomeEvent {
    data class OnSearchChanged(val search: String) : HomeEvent()
    object GetMovieList : HomeEvent()
}