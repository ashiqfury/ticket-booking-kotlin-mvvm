package com.zoho.viewmodel

import com.zoho.data.repository.theatres.TheatreRepo
import com.zoho.model.TheatreModel

class TheatreViewModel {
    private val theatreRepo = TheatreRepo()
    var theatres: MutableList<TheatreModel> = theatreRepo.getTheaterList()

    fun getTheatresList(): MutableList<TheatreModel> {
        return theatres
    }

    fun getTheatreFromId(theatreId: Int): TheatreModel? {
        return getTheatresList().find { it.id == theatreId }
    }
}