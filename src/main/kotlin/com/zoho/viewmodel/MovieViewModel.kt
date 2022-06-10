package com.zoho.viewmodel

import com.zoho.data.repository.movies.MoviesRepo
import com.zoho.model.MovieModel

class MovieViewModel {
    private val movieRepo = MoviesRepo()
    var movies: MutableList<MovieModel> = movieRepo.getMoviesList()

    fun getMovieList(): MutableList<MovieModel> {
        return movies
    }

    fun getMovieFromMovieId(movieId: Int): MovieModel? {
        return getMovieList().find { it.id == movieId }
    }
}