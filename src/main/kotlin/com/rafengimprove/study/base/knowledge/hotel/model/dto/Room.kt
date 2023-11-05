package com.rafengimprove.study.base.knowledge.hotel.model.dto

data class Room(
    val roomType: RoomType,
    val furnitureList: List<Furniture>
)