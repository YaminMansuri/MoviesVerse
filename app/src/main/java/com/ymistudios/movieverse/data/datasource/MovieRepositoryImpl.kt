package com.ymistudios.movieverse.data.datasource

import com.ymistudios.movieverse.data.Response
import com.ymistudios.movieverse.data.pojo.Movie
import com.ymistudios.movieverse.data.repository.MovieRepository
import com.ymistudios.movieverse.data.service.MovieService
import com.ymistudios.movieverse.di.DiConstants
import javax.inject.Inject
import javax.inject.Named

class MovieRepositoryImpl @Inject constructor(
    private val movieService: MovieService,
    @Named(DiConstants.API_KEY) private val apiKey: String
) : MovieRepository {

    override suspend fun getMovieList(search: String, page: Int): Response<Movie> {
        return try {
            val response = movieService.getMovieList(
                apiKey = apiKey,
                search = search,
                page = page
            )
            Response.Success(response)
        } catch (e: Exception) {
            Response.Error(error = e.message)
        }
    }
}