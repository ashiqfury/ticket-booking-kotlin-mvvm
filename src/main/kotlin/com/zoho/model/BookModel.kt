package com.zoho.model

data class BookModel(
    val theatre: TheatreModel,
    val movie: MovieModel,
    val noOfSeats: Int,
    val user: UserModel,
)