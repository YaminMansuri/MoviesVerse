package com.ymistudios.movieverse.data.service

import com.ymistudios.movieverse.data.pojo.Movie
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {

    @GET("/")
    suspend fun getMovieList(
        @Query("apikey") apiKey: String,
        @Query("t") search: String,
        @Query("type") type: String
    ): Movie
}