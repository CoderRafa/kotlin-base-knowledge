package com.rafengimprove.study.base.knowledge.hotel.model.dto

data class Room(
    val roomType: RoomType,
    val furnitureList: MutableList<Furniture>
)

fun Room.takeFurniture(furnitureType: FurnitureType) = furnitureList.filter { it.furnitureType == furnitureType }
fun Room.addFurniture(furniture: Furniture) =
    furnitureList.firstOrNull() { it.furnitureType == furniture.furnitureType }
        ?.apply { this.amount += furniture.amount }
fun Room.deleteFurniture(furnitureType: FurnitureType) = furnitureList.removeIf { it.furnitureType == furnitureType }
