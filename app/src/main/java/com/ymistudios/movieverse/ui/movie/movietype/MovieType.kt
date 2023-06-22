package com.ymistudios.movieverse.ui.movie.movietype

data class MovieType(
    val type: String,
    val image: String,
    var isSelected: Boolean = false
)