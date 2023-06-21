package com.ymistudios.movieverse.data.pojo

import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("Title")
    val name: String? = null,

    @SerializedName("Poster")
    val image: String? = null,

    @SerializedName("Type")
    val type: String? = null,

    @SerializedName("Released")
    val releaseDate: String? = null
)