package com.rafengimprove.study.base.knowledge.hotel.model.dto

import com.rafengimprove.study.base.knowledge.hotel.common.createRoom

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
    roomType: RoomType,
    changeToRoomType: RoomType
): List<HotelRoom> {

    val hotelRooms = this.hotelRooms
        .filter { it.hotelRoomType == hotelRoomType }

    val rooms = hotelRooms
            .map { it.rooms }

    rooms.map { it.removeIf { room -> room.roomType == roomType } }
    rooms.map { it.add(createRoom(changeToRoomType)) }

    return hotelRooms
}