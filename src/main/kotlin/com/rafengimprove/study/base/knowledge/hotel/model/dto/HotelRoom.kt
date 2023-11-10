package com.rafengimprove.study.base.knowledge.hotel.model.dto

data class HotelRoom(
    val hotelRoomType: HotelRoomType,
    val rooms: List<Room>,
    val status: HotelRoomStatus = HotelRoomStatus.AVAILABLE
)

fun HotelRoom.takeRoom(roomType: RoomType): List<Room> = rooms.filter { it.roomType == roomType }