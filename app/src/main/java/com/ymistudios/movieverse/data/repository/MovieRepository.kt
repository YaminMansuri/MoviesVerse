package com.ymistudios.movieverse.data.repository

import com.ymistudios.movieverse.data.Response
import com.ymistudios.movieverse.data.pojo.Movie

interface MovieRepository {

    suspend fun getMovieList(search: String, type: String): Response<Movie>
}