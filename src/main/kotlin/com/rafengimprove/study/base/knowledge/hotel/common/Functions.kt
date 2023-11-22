package com.rafengimprove.study.base.knowledge.hotel.common

import com.rafengimprove.study.base.knowledge.hotel.model.dto.*

fun createHotel(name: String = "Metropolis", description: String = "Very expensive hotel") = Hotel(
    name, description, 10, 150, 20, 50, 20, 80,
    mutableListOf<HotelRoom>().apply {
        this.addAll(List(20) { createHotelRoomBy(HotelRoomType.SINGLE) })
        this.addAll(List(50) { createHotelRoomBy(HotelRoomType.DOUBLE) })
    }
)


fun createHotelRoom(
    hotelRoomType: HotelRoomType,
    roomTypes: List<RoomType>,
    modifier: ((hotelRoom: HotelRoom) -> Unit)? = null,
    status: HotelRoomStatus = HotelRoomStatus.AVAILABLE
) {
    val hotelRoom = HotelRoom(hotelRoomType, createRooms(roomTypes), status)
    modifier?.let { it(hotelRoom) }
}

fun createRooms(roomTypes: List<RoomType>): MutableList<Room> {
    return roomTypes.map(::createRoom).toMutableList()
}

fun createRoom(roomType: RoomType): Room = when (roomType) {
    RoomType.BEDROOM -> Room(
        RoomType.BEDROOM,
        mutableListOf(
            Furniture(FurnitureType.SINGLE_BED, 1),
            Furniture(FurnitureType.BEDSIDE_CABINET, 2),
            Furniture(FurnitureType.TABLE, 1),
            Furniture(FurnitureType.CHAIR, 2),
            Furniture(FurnitureType.WARDROBE, 1),
        )
    )

    RoomType.LIVING_ROOM -> Room(
        RoomType.LIVING_ROOM,
        mutableListOf(
            Furniture(FurnitureType.TABLE, 1),
            Furniture(FurnitureType.CHAIR, 4),
            Furniture(FurnitureType.TV, 1),
            Furniture(FurnitureType.RUG, 1),
        )
    )

    RoomType.BATHROOM -> Room(
        RoomType.BATHROOM,
        mutableListOf(
            Furniture(FurnitureType.RUG, 1),
            Furniture(FurnitureType.BATHROOM_CABINET, 1)
        )
    )
}