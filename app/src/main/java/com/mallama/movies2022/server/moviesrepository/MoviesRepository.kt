package com.mallama.movies2022.server.moviesrepository

import com.mallama.movies2022.server.MovieDB

class MoviesRepository {

    private val apiKey ="591efd87f27bfb08ffe3fc4d6ed1813a"

    suspend fun getMovies() = MovieDB.retrofit.getTopRated(apiKey)
}