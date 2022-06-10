package com.zoho.view

import com.zoho.model.*
import com.zoho.viewmodel.TheatreViewModel
import java.util.Scanner

class TheatreView {
    val theatreViewModel = TheatreViewModel()

    fun showAllTheatres() {
        theatreViewModel.getTheatresList().forEach { theatre ->
            printTheatreDetail(theatre)
        }
    }
    private fun printTheatreDetail(theatre: TheatreModel) {
        val (name, location, capacity) = theatre
        println("""
            Id: ${theatre.id}
            Name: $name
            Location: $location
            Total seats: $capacity
            Seats available: ${theatre.seats}       
        """.trimIndent())
//        Movies: ${theatre.movies.joinToString(", ") { it.name }}
    }

    fun showTheatresNames()  {
        theatreViewModel.getTheatresList().forEach {
            println("${it.id}. ${it.name}")
        }
    }
}