package com.zoho.data.repository.theatres

import com.zoho.model.*
import com.zoho.data.repository.movies.MOVIES

val THEATRES = mutableListOf(
    TheatreModel("Ram", "Tirunelveli", 10),
    TheatreModel("Muthu Ram", "Kerala", 15, MOVIES.dropLast(1) as MutableList<MovieModel>)
)