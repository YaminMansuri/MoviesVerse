package com.ymistudios.movieverse.data.pojo

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie(
    @SerializedName("Title")
    val title: String? = null,

    @SerializedName("Poster")
    val poster: String? = null,

    @SerializedName("Type")
    val type: String? = null,

    @SerializedName("Released")
    val releaseDate: String? = null,

    @SerializedName("Rated")
    val rated: String? = null,

    @SerializedName("Runtime")
    val runTime: String? = null,

    @SerializedName("Genre")
    val genre: String? = null,

    @SerializedName("Director")
    val director: String? = null,

    @SerializedName("Writer")
    val writer: String? = null,

    @SerializedName("Actors")
    val actors: String? = null,

    @SerializedName("Plot")
    val plot: String? = null,

    @SerializedName("Language")
    val language: String? = null,

    @SerializedName("Country")
    val country: String? = null,

    @SerializedName("Awards")
    val awards: String? = null,

    @SerializedName("imdbRating")
    val imdbRating: String? = null,

    @SerializedName("Error")
    val error: String? = null
) : Parcelable