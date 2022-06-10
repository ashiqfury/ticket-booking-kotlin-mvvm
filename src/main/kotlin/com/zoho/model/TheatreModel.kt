package com.zoho.model

import com.zoho.data.repository.movies.MoviesRepo

data class TheatreModel(
    val name: String,
    val location: String,
    val capacity: Int,
//    var movies: MutableList<MovieModel> = mutableListOf(),
//    var movies: MutableList<MovieModel> = MoviesRepo().getMoviesList() // It shows stackoverflow exception.
) {
    var id: Int
    private var _seats: Int = 0
    var seats: Int
        get() = _seats
        set(value) { _seats -= value }

    companion object {
        var theatreId = 0
    }

    init {
        theatreId += 1
        this.id = theatreId
        this._seats = capacity
    }
}