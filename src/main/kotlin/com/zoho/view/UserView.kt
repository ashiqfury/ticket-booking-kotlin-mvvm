package com.zoho.view

import java.util.Scanner

class UserView {
    private val theatreView = TheatreView()
//    private val movieView = MovieView()
    private val bookingView = BookingView()

//    private enum class UserChoices(val text: String) {
//        SHOW_ALL_THEATRES("Show theatres list"),
//        SHOW_ALL_MOVIES("Show movies list"),
//        BOOK_TICKET("Book ticket"),
//        BACK("Back")
//    }

    fun userChoices() {
        val scanner = Scanner(System.`in`)
        do {
            theatreView.showAllTheatres()
            println("0. Back")
            println("Enter theatre id: ")
            val theatreId = scanner.nextInt()
            println("First id: $theatreId")
            bookingView.getBookingDetails(theatreId)
//            userNavigation(choice)
        } while(theatreId != 0)
//        do {
//            UserChoices.values().forEach {
//                println("${it.ordinal + 1}. ${it.text}")
//            }
//            println("Enter your choice: ")
//            val choice = scanner.nextInt()
//            userNavigation(choice - 1)
//        } while (choice != UserChoices.values().size)
    }

//    private fun userNavigation(choice: String) {
//        val scanner = Scanner(System.`in`)
//        when(choice) {
//            1 -> bookingView.getBookingDetails()
//            2 -> return
//        }


//        when (UserChoices.values()[choice]) {
//            UserChoices.SHOW_ALL_THEATRES -> theatreView.showAllTheatres()
//            UserChoices.SHOW_ALL_MOVIES -> theatreView.MovieView().showAllMovies()
//            UserChoices.BOOK_TICKET -> bookingView.getBookingDetails()
//            UserChoices.BACK -> return
//        }
//    }
}