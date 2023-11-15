package com.rafengimprove.study.base.knowledge.hotel.model.dto

data class HotelRoom(
    val hotelRoomType: HotelRoomType,
    val rooms: List<Room>,
    val status: HotelRoomStatus = HotelRoomStatus.AVAILABLE
)

fun HotelRoom.takeRoom(roomType: RoomType): List<Room> = rooms.filter { it.roomType == roomType }

fun HotelRoom.changeFurnitureAmount(roomType: RoomType, furnitureType: FurnitureType, modifier: (Furniture)->Furniture): List<Furniture> {
    val furnitureList = rooms.filter { it.roomType == roomType }
        .flatMap { it.takeFurniture(furnitureType) }
    return furnitureList.map { modifier(it) }
}

fun changeAmountOfFurniture(amount: Int) = { furniture: Furniture ->
    if (furniture.amount == amount) furniture.amount = amount
    furniture
}

fun changeTo(furnitureType: FurnitureType, amount: Int) = { furniture: Furniture ->
    furniture.furnitureType = furnitureType
    furniture.amount= amount
    furniture
}