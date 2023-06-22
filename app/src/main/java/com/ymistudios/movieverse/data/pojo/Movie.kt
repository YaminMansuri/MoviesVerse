package com.ymistudios.movieverse.data.pojo

import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("Title")
    val title: String? = null,

    @SerializedName("Poster")
    val poster: String? = null,

    @SerializedName("Type")
    val type: String? = null,

    @SerializedName("Released")
    val releaseDate: String? = null,

    @SerializedName("Error")
    val error: String? = null
)