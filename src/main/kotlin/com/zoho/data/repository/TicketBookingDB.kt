package com.zoho.data.repository

import com.zoho.model.*

class TicketBookingDB {
    companion object {
        private var localDB: TicketBookingDB? = null
        fun getInstance(): TicketBookingDB = kotlin.run {
            if(localDB != null) {
                localDB!!
            } else {
                localDB = TicketBookingDB()
                localDB!!
            }
        }
    }
    val MOVIES_DB: MutableList<MovieModel> = mutableListOf()
    val MOVIES_NETWORK = mutableListOf(
        MovieModel("Titanic", Genre.Romance, Language.English, ShowTime.Night, 140),
        MovieModel("Jurassic Park", Genre.Action, Language.Tamil, ShowTime.Evening, 200),
        MovieModel("Finding Nemo", Genre.Comedy, Language.Hindi, ShowTime.Morning, 100),
        MovieModel("Evil Dead", Genre.Horror, Language.English, ShowTime.Night, 180),
        MovieModel("Karate Kid", Genre.Action, Language.Tamil, ShowTime.Afternoon, 300),
        MovieModel("Jumanji", Genre.Comedy, Language.Hindi, ShowTime.Morning, 150),
        MovieModel("KGF 2", Genre.Action, Language.Tamil, ShowTime.Morning, 500),
        MovieModel("Avengers", Genre.Action, Language.Hindi, ShowTime.Afternoon, 110),
    )

    val THEATRES_DB: MutableList<TheatreModel> = mutableListOf()
    val THEATRES_NETWORK = mutableListOf(
        TheatreModel("Ram Theatre", "Tirunelveli", 10),
        TheatreModel("Muthu Ram Theatre", "Madurai", 15)
//        TheatreModel("Muthu Ram Theatre", "Madurai", 15, MOVIES_NETWORK.dropLast(4) as MutableList<MovieModel>)
    )
}
