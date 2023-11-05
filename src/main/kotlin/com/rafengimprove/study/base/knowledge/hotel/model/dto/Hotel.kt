package com.rafengimprove.study.base.knowledge.hotel.model.dto

data class Hotel(
    val name: String,
    val description: String,
    val numberOfFloors: Int,
    val numberOfRooms: Int,
    val numberOfSingleRooms: Int,
    val numberOfDoubleRooms: Int,
    val numberOfPenthouses: Int,
    val hotelRooms: MutableList<HotelRoom>
)