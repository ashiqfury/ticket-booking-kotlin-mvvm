package com.zoho.data.repository.theatres

import com.zoho.data.repository.TicketBookingDB
import com.zoho.model.TheatreModel

class TheatreRepo {

    fun getTheaterList(): MutableList<TheatreModel> {
        return fetchTheatreListFromNetwork()
    }

    private fun fetchTheatreListFromNetwork(): MutableList<TheatreModel> {
        //In the future, we'll fetch it from actual DB / json / txt / Local Storage
        return TicketBookingDB.getInstance().THEATRES_NETWORK
    }

    private fun fetchTheatreListFromDB() {
        //In the future we'll fetch it from actual DB / json / txt / Local Storage
        TicketBookingDB.getInstance().THEATRES_DB
    }

//    fun getTheater(id: Int): TheatreModel? {
//        //Theater Object
//        return TicketBookingDB.getInstance().THEATRES_NETWORK.find { it.id == id }
//    }
}