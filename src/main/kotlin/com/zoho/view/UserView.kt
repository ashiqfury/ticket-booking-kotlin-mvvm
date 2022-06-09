package com.zoho.view

import java.util.Scanner

class UserView {
    private val theatreView = TheatreView()
    private val bookingView = BookingView()

    enum class UserChoices(val text: String) {
        SHOW_ALL_THEATRES("Show theatres list"),
        SHOW_ALL_MOVIES("Show movies list"),
        BOOK_TICKET("Book ticket"),
        EXIT("Exit")
    }

    fun userChoices() {
        val scanner = Scanner(System.`in`)
        do {
            UserChoices.values().forEach {
                println("${it.ordinal + 1}. ${it.text}")
            }
            println("Enter your choice: ")
            val choice = scanner.nextInt()

            navigate(choice)
        } while (choice != 4)
    }

    private fun navigate(choice: Int) {
        when (choice) {
            1 -> theatreView.showAllTheatres()
            2 -> theatreView.showAllMovies()
            3 -> bookingView.getBookingDetails()
        }
    }
}