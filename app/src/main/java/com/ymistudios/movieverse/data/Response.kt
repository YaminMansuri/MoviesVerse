package com.ymistudios.movieverse.data

sealed class Response<T>(
    val data: T? = null, val error: String? = null
) {
    class Success<T>(data: T?) : Response<T>(data)
    class Error<T>(error: String?) : Response<T>(error = error)
}
