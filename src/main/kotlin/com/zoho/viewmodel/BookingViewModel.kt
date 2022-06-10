package com.zoho.viewmodel

import com.zoho.model.*
import com.zoho.view.BookingView

class BookingViewModel {
    val theatreViewModel = TheatreViewModel()
    val movieViewModel = MovieViewModel()

    fun bookTicket(seats: Int, theatreId: Int, movieId: Int, username: String, phoneNumber: Long): BookModel? {
        theatreViewModel.getTheatreFromId(theatreId)?.let {theatre ->
            movieViewModel.getMovieFromMovieId(movieId)?.let {movie ->
                if ((theatre.seats > 0) && (theatre.seats >= seats)) {
                    val bookDetails =  BookModel(theatre, movie, seats, username, phoneNumber)
                    seats.also { theatre.seats = it }
                    return bookDetails
                } else "Seats unavailable! seats available:  ${theatre.seats}"
            }
        }
        return null
    }
}