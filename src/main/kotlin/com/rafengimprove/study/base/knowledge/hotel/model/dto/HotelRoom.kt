package com.rafengimprove.study.base.knowledge.hotel.model.dto

data class HotelRoom(
    val hotelRoomType: HotelRoomType,
    val roomList: List<Room>
)