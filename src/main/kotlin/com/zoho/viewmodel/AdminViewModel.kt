package com.zoho.viewmodel

import com.zoho.model.*

class AdminViewModel {
    private val bookingViewModel = BookingViewModel()

    fun adminAddNewTheatre(theatreName: String, location: String, totalSeats: Int): String {
        bookingViewModel.theatres.add(TheatreModel(theatreName, location, totalSeats, mutableListOf()))
        return "Theatre $theatreName was added successfully!"
    }

    fun adminRemoveTheatre(theatreId: Int): String {
        bookingViewModel.theatres.find { it.id == theatreId }?.let {
            bookingViewModel.theatres.remove(it)
            return "${it.name} successfully removed!"
        }
        return "Remove failed!"
    }

    fun adminAddNewMovie(theatreId: Int, movieName: String, genre: Genre, language: Language, showTime: ShowTime, price: Int): String {
        bookingViewModel.theatres[theatreId - 1].movies.add(MovieModel(movieName, genre, language, showTime, price))
        return "Movie $movieName is successfully added!"
    }

    fun adminRemoveMovie(theatreId: Int, movieId: Int): String {
        bookingViewModel.theatres[theatreId - 1].movies.find { it.id == movieId }?.let {
            bookingViewModel.theatres[theatreId - 1].movies.remove(it)
            return "${it.name} removed successfully!"
        }
        return "Remove failed!"
    }
}