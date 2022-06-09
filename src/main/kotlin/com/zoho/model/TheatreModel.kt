package com.zoho.model

import com.zoho.data.repository.movies.MOVIES

data class TheatreModel(
    val name: String,
    val location: String,
    val capacity: Int,
    var movies: MutableList<MovieModel> = MOVIES,
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