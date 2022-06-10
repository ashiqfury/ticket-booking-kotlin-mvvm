package com.zoho.view

import com.zoho.model.*
import com.zoho.viewmodel.BookingViewModel
import com.zoho.viewmodel.TheatreViewModel
import java.lang.reflect.MalformedParameterizedTypeException
import java.util.*

class BookingView {
    val bookingViewModel = BookingViewModel()
    val theatreView = TheatreView()
    val movieView = MovieView()

    fun getBookingDetails(paramTheatreId: Int? = null, paramMovieId: Int? = null) {
        val theatreId = paramTheatreId ?:getTheatreIdWithShowTheatres()
        println("Second id: $theatreId")
        val movieId = paramMovieId ?: getMovieIdWithShowMovies()
        val seats = getSeatsCount()
        val username = getUsername()
        val phoneNumber = getUserNumber()
        bookingViewModel.bookTicket(seats, theatreId, movieId, username, phoneNumber)?.let {
            showBookedDetails(it)
        }
    }

    fun getTheatreId(): Int {
        val scanner = Scanner(System.`in`)
        println("Enter theatre id: ")
        return scanner.nextInt()
    }

    fun getTheatreIdWithShowTheatres(): Int {
//        theatreView.showTheatresNames()
        theatreView.showAllTheatres()
        val scanner = Scanner(System.`in`)
        println("Enter theatre id: ")
        return scanner.nextInt()
    }

    fun getMovieId(): Int {
        val scanner = Scanner(System.`in`)
        movieView.printAllMovies()
        println("Enter movie id: ")
        return scanner.nextInt()
    }

    fun getMovieIdWithShowMovies(): Int {
        val scanner = Scanner(System.`in`)
//        movieView.showAllMoviesNames()
        movieView.showAllMovies()
        println("Enter movie id: ")
        return scanner.nextInt()
    }

    fun getSeatsCount(): Int {
        val scanner = Scanner(System.`in`)
        println("Enter number of seats: ")
        return scanner.nextInt()
    }

    fun getUsername(): String {
        val scanner = Scanner(System.`in`)
        println("Enter your name: ")
        return scanner.next()
    }

    fun getUserNumber(): Long {
        val scanner = Scanner(System.`in`)
        println("Enter your phone number: ")
        return scanner.nextLong()
    }

    fun showBookedDetails(bookDetail: BookModel) {
        val (theatre, movie, seats, username, phoneNumber) = bookDetail
        println(
            """
                Booking successful! 🔥
                        
                DETAILS:
                User name: $username
                Phone number: $phoneNumber
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