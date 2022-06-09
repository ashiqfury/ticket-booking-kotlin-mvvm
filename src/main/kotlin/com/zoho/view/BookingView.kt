package com.zoho.view

import com.zoho.model.*
import com.zoho.viewmodel.BookingViewModel
import java.util.*

open class BookingView {
    val bookingViewModel = BookingViewModel()
    private val theatreView = TheatreView()

    fun getBookingDetails() {
        val scanner = Scanner(System.`in`)

        println("Enter your name: ")
        val name = scanner.next()
        println("Enter your phone number: ")
        val number = scanner.nextLong()
        val user = UserModel(name, number)

        theatreView.showTheatresNames()
        println("Enter theatre id: ")
        val theatreId = scanner.nextInt()
        theatreView.showAllMoviesNames(theatreId, bookingViewModel.theatres)
        println("Enter movie id: ")
        val movieId = scanner.nextInt()
        if (bookingViewModel.theatres[theatreId - 1].movies.any {it.id == movieId}) {
            println("Enter number of seats: ")
            val seats = scanner.nextInt()
            val message = bookingViewModel.bookTicket(seats, theatreId, movieId, user)
            println(message)
        } else return println("Invalid movie id!")
    }

    fun showBookedDetails(bookDetail: BookModel) {

        val (theatre, movie, seats, user) = bookDetail

        println(
            """
                    Booking successful! 🔥

                        DETAILS:
                        User name: ${user.username}
                        Phone number: ${user.phoneNumber}
                        Theatre id: ${theatre.id}
                        Theatre name: ${theatre.name}
                        Location: ${theatre.location}
                        Movie id: ${movie.id}
                        Movie name: ${movie.name}
                        Genre: ${movie.genre}
                        Language: ${movie.language}
                        Ticket Price: Rs. ${movie.price}/-
                        Total Price: Rs. ${movie.price * seats}/-
                        Time: ${movie.showTime}

                    Thank you...!

                    """.trimIndent()
        )
    }
}