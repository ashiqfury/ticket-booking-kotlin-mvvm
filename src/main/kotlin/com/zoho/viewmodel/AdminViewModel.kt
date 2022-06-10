package com.zoho.viewmodel

import com.zoho.model.*

class AdminViewModel {
    private val theatreViewModel = TheatreViewModel()
    val movieViewModel = MovieViewModel()

    fun adminAddNewTheatre(theatreName: String, location: String, totalSeats: Int): String {
//        theatreViewModel.getTheatresList().add(TheatreModel(theatreName, location, totalSeats, mutableListOf()))
        theatreViewModel.getTheatresList().add(TheatreModel(theatreName, location, totalSeats))
        return "Theatre $theatreName was added successfully!"
    }

    fun adminRemoveTheatre(theatreId: Int): String {
        theatreViewModel.getTheatresList().find { it.id == theatreId }?.let {
            theatreViewModel.getTheatresList().remove(it)
            return "${it.name} successfully removed!"
        }
        return "Remove failed!"
    }

    fun adminAddNewMovie(movieName: String, genre: Genre, language: Language, showTime: ShowTime, price: Int): String {
        movieViewModel.getMovieList().add(MovieModel(movieName, genre, language, showTime, price))
        return "Movie $movieName is successfully added!"
    }

    fun adminRemoveMovie(movieId: Int): String {
        movieViewModel.getMovieFromMovieId(movieId)?.let {
            movieViewModel.getMovieList().remove(it)
            return "${it.name} removed successfully!"
        }
        return "Remove failed!"
    }
}