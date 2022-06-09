package com.zoho.view

import com.zoho.model.Genre
import com.zoho.model.Language
import com.zoho.model.ShowTime
import com.zoho.viewmodel.AdminViewModel
import java.util.*

class AdminView {
    private val adminViewModel = AdminViewModel()
    private val theatreView = TheatreView()
    private val bookingView = BookingView()
    private enum class AdminChoices(val text: String) {
        SHOW_THEATRES_LIST("Show theatres list"),
        SHOW_MOVIES_LIST("Show movies list"),
        ADD_THEATRE("Add a new theatre"),
        REMOVE_THEATRE("Remove a theatre"),
        ADD_MOVIE("Add a new movie"),
        REMOVE_MOVIE("Remove a movie"),
        BOOK_TICKET("Book a ticket"),
        EXIT("Exit")
    }

    private fun adminAddNewTheatre() {
        val scanner = Scanner(System.`in`)

        println("ADD A NEW THEATRE: ")
        println("\nEnter theatre name: ")
        val theatreName = scanner.next()
        println("Enter location: ")
        val location = scanner.next()
        println("Enter total seat capacity: ")
        val totalSeats = scanner.nextInt()
        if (totalSeats > 0) {
            val result = adminViewModel.adminAddNewTheatre(theatreName, location, totalSeats)
            println(result)
        } else println("Total seat must be greater than 0!")
    }

    private fun adminRemoveTheatre() {
        val scanner = Scanner(System.`in`)

        theatreView.showTheatresNames()
        println("Enter theatre id: ")
        val theatreId = scanner.nextInt()
        if (bookingView.bookingViewModel.theatres.any { it.id == theatreId }) {
            val result = adminViewModel.adminRemoveTheatre(theatreId)
            println(result)
        } else println("Invalid theatre id!")
    }

    private fun adminAddNewMovie() {
        val scanner = Scanner(System.`in`)

        val genre: Genre
        val language: Language
        val showTime: ShowTime
        theatreView.showTheatresNames()
        println("Enter theatre id: ")
        val theatreId = scanner.nextInt()
        if (bookingView.bookingViewModel.theatres.any { it.id == theatreId }) {
            println("Enter movie name: ")
            val movieName = scanner.next()

            Genre.values().forEach { println("${it.ordinal + 1}. $it") }
            println("Enter genre id: ")
            val genreId = scanner.nextInt()
            if (Genre.values().any { it.ordinal + 1 == genreId })
                genre = Genre.values().filter { it.ordinal + 1 == genreId }[0]
            else return println("Invalid genre id!")

            Language.values().forEach { println("${it.ordinal + 1}. $it") }
            println("Enter language id: ")
            val languageId = scanner.nextInt()
            if (Language.values().any { it.ordinal + 1 == languageId })
                language = Language.values().filter { it.ordinal + 1 == languageId }[0]
            else return println("Invalid language id!")

            ShowTime.values().forEach { println("${it.ordinal + 1}. $it") }
            println("Enter time id: ")
            val timeId = scanner.nextInt()
            if (ShowTime.values().any { it.ordinal + 1 == timeId })
                showTime = ShowTime.values().filter { it.ordinal + 1 == timeId }[0]
            else return println("Invalid show time id!")

            println("Enter ticket price: ")
            val price = scanner.nextInt()
            if (price < 0) return println("Price must be greater than 0!")
            val result = adminViewModel.adminAddNewMovie(theatreId, movieName, genre, language, showTime, price)
            println(result)
        } else println("Invalid theatre id!")
    }

    private fun adminRemoveMovie() {
        val scanner = Scanner(System.`in`)

        theatreView.showTheatresNames()
        println("Enter theatre id: ")
        val theatreId = scanner.nextInt()
        bookingView.bookingViewModel.theatres.find { it.id == theatreId }?.let {
            theatreView.showAllMoviesNames(theatreId, bookingView.bookingViewModel.theatres)
            println("Enter movie id: ")
            val movieId = scanner.nextInt()
            if (bookingView.bookingViewModel.theatres[theatreId - 1].movies.any { it.id == movieId }) {
                val result = adminViewModel.adminRemoveMovie(theatreId, movieId)
                println(result)
            } else println("Invalid movie id!")

        } ?: return println("Invalid movie id")
    }

    fun adminChoices() {
        val scanner = Scanner(System.`in`)
        println("Enter password: ")
        val password = scanner.nextInt()
        if (password == 12345) {
            do {
                AdminChoices.values().forEach {
                    println("${it.ordinal + 1}. ${it.text}")
                }
                val choice = scanner.nextInt()
                adminMakeDecision(choice)
            } while(choice != 8)
        } else println("Password incorrect!")
    }

    private fun adminMakeDecision(paramChoice: Int) {
        when (paramChoice) {
            1 -> theatreView.showAllTheatres()
            2 -> theatreView.showAllMovies()
            3 -> adminAddNewTheatre()
            4 -> adminRemoveTheatre()
            5 -> adminAddNewMovie()
            6 -> adminRemoveMovie()
            7 -> bookingView.getBookingDetails()
            else -> println("Something went wrong!")
        }
    }
}