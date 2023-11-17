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

fun Hotel.changeTo(
    hotelRoomType: HotelRoomType,
    changeToHotelRoomType: HotelRoomType
): List<HotelRoom> {
    this.hotelRooms.removeIf { it.hotelRoomType == hotelRoomType }
    return List(numberOfRooms - this.hotelRooms.size) {
        createHotelRoomBy(changeToHotelRoomType)
    }.also { this.hotelRooms.addAll(it) }
}