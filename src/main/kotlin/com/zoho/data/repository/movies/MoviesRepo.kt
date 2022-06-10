package com.zoho.data.repository.movies

import com.zoho.data.repository.TicketBookingDB
import com.zoho.model.MovieModel

class MoviesRepo {
    fun getMoviesList(): MutableList<MovieModel> {
        return fetchMoviesListFromNetwork()
    }

    private fun fetchMoviesListFromNetwork(): MutableList<MovieModel> {
        //In the future, we'll fetch it from actual DB / json / txt / Local Storage
        return TicketBookingDB.getInstance().MOVIES_NETWORK
    }

    private fun fetchMoviesListFromDB() = run {
        //In the future we'll fetch it from actual DB / json / txt / Local Storage
        TicketBookingDB.getInstance().MOVIES_DB
    }

//    fun getMovie(id: Int): MovieModel? {
//        //Theater Object
//        return TicketBookingDB.getInstance().MOVIES_NETWORK.find { it.id == id }
//    }
}