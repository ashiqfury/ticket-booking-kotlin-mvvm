package com.zoho.view

import com.zoho.model.MovieModel
import com.zoho.model.TheatreModel
import com.zoho.viewmodel.BookingViewModel
import kotlinx.coroutines.*
import java.util.Scanner

class TheatreView {
    private val bookingViewModel = BookingViewModel()

//    fun launch(selectedMenu: UserView.UserChoices) {
//        when(selectedMenu) {
//            UserView.UserChoices.SHOW_ALL_THEATRES -> showAllTheatres()
//            UserView.UserChoices.SHOW_ALL_MOVIES -> showAllTheatres()
//            //UserView.UserChoices.BOOK_TICKET -> bookingView.getBookingDetails()
//            else -> return
//        }
//    }

    fun showAllTheatres() {
        bookingViewModel.getTheatresList().forEach { theatre ->
            printTheatreDetail(theatre)
        }
    }
    fun printTheatreDetail(theatre: TheatreModel) {
        val (name, location, capacity) = theatre
        println("""
            Id: ${theatre.id}
            Name: $name
            Location: $location
            Total seats: $capacity
            Seats available: ${theatre.seats}
            Movies: ${theatre.movies.joinToString(", ") { it.name }} 
        """.trimIndent())
    }

    fun showTheatresNames()  {
        bookingViewModel.getTheatresList().forEach {
            println("${it.id}. ${it.name}")
        }
    }

    fun showAllMovies() {
        val scanner = Scanner(System.`in`)
        var startIndex = 0
        val endIndex = 2
        var fetchedMoviesCount = 2

        showTheatresNames()
        println("Enter theatre id: ")
        val theatreId = scanner.nextInt()
        bookingViewModel.getTheatresList().find { it.id == theatreId }?.let {theatre ->
            theatre.movies.subList(startIndex, endIndex).forEach { movie ->
                printMovieDetail(movie)
            }
            var choice  = 0
            startIndex++
            do {
                println("\n1. Show more\n2. Exit\n")
                choice = scanner.nextInt()
                if (choice == 1) {
                    ++fetchedMoviesCount
                    showNextAllMovies(theatre, ++startIndex)
                    if (theatre.movies.size <= fetchedMoviesCount) break
                }
            } while (choice != 2)
        } ?: println("Invalid theatre id!")
    }

    private fun showNextAllMovies(theatre: TheatreModel, index: Int) {
        theatre.movies[index].also { movie ->
            printMovieDetail(movie)
        }
    }

    fun printMovieDetail(movie: MovieModel) {
        println("""
                Movie id: ${movie.id}
                Movie name: ${movie.name}
                Movie language: ${movie.language}
                Movie genre: ${movie.genre}
                Movie time: ${movie.showTime}
                Movie price: Rs. ${movie.price}/-
            """.trimIndent())
    }

    fun showAllMoviesNames(theatreId: Int, theatres: MutableList<TheatreModel>) {
        theatres.find { it.id == theatreId }?.let {theatre ->
            theatre.movies.forEach {
                println("${it.id}. ${it.name}")
            }
        } ?: println("Invalid theatre id!")
    }
}