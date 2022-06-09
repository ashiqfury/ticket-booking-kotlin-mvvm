package com.zoho.model

data class MovieModel(
    val name: String,
    val genre: Genre,
    val language: Language,
    val showTime: ShowTime,
    val price: Int,
) {
    val id: Int = ++movieId
    companion object {
        var movieId = 0
    }
}