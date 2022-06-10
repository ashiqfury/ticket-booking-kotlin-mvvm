package com.zoho.view

import com.zoho.model.MovieModel
import com.zoho.model.TheatreModel
import com.zoho.viewmodel.MovieViewModel
import com.zoho.viewmodel.TheatreViewModel
import java.util.*

class MovieView {
    val movieViewModel = MovieViewModel()
//    val theatreViewModel = TheatreViewModel()
    val theatreView = TheatreView()

    fun showAllMovies() {
        val scanner = Scanner(System.`in`)
        var startIndex = 0
        val endIndex = 2
        var fetchedMoviesCount = 2

        theatreView.showTheatresNames()
        println("Enter theatre id: ")

//        val theatreId = scanner.nextInt()
//        theatreViewModel.getTheatresList().find { it.id == theatreId }?.let {theatre ->
            movieViewModel.getMovieList().subList(startIndex, endIndex).forEach { movie ->
                printMovieDetail(movie)
            }
            var choice = 0
            startIndex++
            do {
                println("\n1. Show more\n2. Exit\n")
                choice = scanner.nextInt()
                if (choice == 1) {
                    ++fetchedMoviesCount
                    showNextAllMovies(++startIndex)
                    if (movieViewModel.getMovieList().size <= fetchedMoviesCount) break
                }
            } while (choice != 2)
//        } ?: println("Invalid theatre id!")
    }

    private fun showNextAllMovies(index: Int) {
        movieViewModel.getMovieList()[index].also { movie ->
            printMovieDetail(movie)
        }
    }

    fun printAllMovies() {
        movieViewModel.getMovieList().forEach { printMovieDetail(it) }
    }

    private fun printMovieDetail(movie: MovieModel) {
        println("""
                Movie id: ${movie.id}
                Movie name: ${movie.name}
                Movie language: ${movie.language}
                Movie genre: ${movie.genre}
                Movie time: ${movie.showTime}
                Movie price: Rs. ${movie.price}/-
            """.trimIndent())
    }

    fun showAllMoviesNames() {
//        theatres.find { it.id == theatreId }?.let {theatre ->
//            theatre.movies.forEach {
//                println("${it.id}. ${it.name}")
//            }
//        } ?: println("Invalid theatre id!")

        movieViewModel.getMovieList().forEach {
            println("${it.id}. ${it.name}")
        }
    }
}