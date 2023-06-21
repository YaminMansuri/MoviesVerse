package com.ymistudios.movieverse.data

object URLManager {

    fun getBaseUrl(apiKey: String) = "http://www.omdbapi.com/?apikey=$apiKey&"
}