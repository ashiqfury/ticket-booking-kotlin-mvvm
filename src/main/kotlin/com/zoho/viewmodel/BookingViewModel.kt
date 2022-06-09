package com.zoho.viewmodel

import com.zoho.data.repository.theatres.THEATRES
import com.zoho.model.BookModel
import com.zoho.model.TheatreModel
import com.zoho.model.UserModel
import com.zoho.view.BookingView

class BookingViewModel {
    var theatres: MutableList<TheatreModel> = THEATRES

    fun bookTicket(seats: Int, theatreId: Int, movieId: Int, user: UserModel): String {
        theatres.find { it.id == theatreId }?.let { theatre ->
            theatre.movies.find { it.id == movieId }?.let { movie ->
                if ((theatre.seats > 0) && (theatre.seats >= seats)) {
                    BookingView().showBookedDetails(BookModel(theatre, movie, seats, user))
                    seats.also { theatre.seats = it }
                    return "Success!"
                } else return "Seats unavailable! seats available:  ${theatre.seats}"
            }
        } ?: return ""
    }
}