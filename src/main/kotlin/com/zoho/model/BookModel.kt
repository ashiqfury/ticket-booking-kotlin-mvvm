package com.zoho.model

data class BookModel(
    val theatre: TheatreModel,
    val movie: MovieModel,
    val noOfSeats: Int,
    val username: String,
    val phoneNumber: Long
)