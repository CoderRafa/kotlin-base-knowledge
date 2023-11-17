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

fun createHotelRoomBy(hotelRoomType: HotelRoomType) = when(hotelRoomType) {
    HotelRoomType.SINGLE -> createHotelRoom(HotelRoomType.SINGLE, listOf(RoomType.BATHROOM, RoomType.BEDROOM))
    HotelRoomType.DOUBLE -> createHotelRoom(HotelRoomType.DOUBLE, listOf(RoomType.BATHROOM, RoomType.BEDROOM), baseToDoubleModifier)
    HotelRoomType.LUXURY -> createHotelRoom(
        HotelRoomType.LUXURY, listOf(
            RoomType.LIVING_ROOM,
            RoomType.BATHROOM,
            RoomType.BEDROOM
        ), baseToLuxuryModifier)
    HotelRoomType.FAMILY -> createHotelRoom(
        HotelRoomType.FAMILY, listOf(
            RoomType.BEDROOM,
            RoomType.BATHROOM,
            RoomType.BEDROOM
        ), baseToDoubleModifier)
    HotelRoomType.PENTHOUSE -> createHotelRoom(
        HotelRoomType.PENTHOUSE, listOf(
            RoomType.LIVING_ROOM,
            RoomType.BATHROOM,
            RoomType.BEDROOM
        ), baseToPenthouseModifier)
}

val baseToDoubleModifier: (hotelRoom: HotelRoom) -> Unit = { hotelRoom ->
    hotelRoom.rooms
        .find { it.roomType == RoomType.BEDROOM }
        ?.let {
            it.deleteFurniture(FurnitureType.SINGLE_BED)
            it.addFurniture(Furniture(FurnitureType.DOUBLE_BED, 1))
        }
}

val baseToLuxuryModifier: (hotelRoom: HotelRoom) -> Unit = { hotelRoom ->
    hotelRoom.changeFurnitureAmount(RoomType.BEDROOM, FurnitureType.SINGLE_BED, changeTo(FurnitureType.QUEEN_SIZE_BED, 1))
    hotelRoom.changeFurnitureAmount(RoomType.BATHROOM, FurnitureType.RUG, changeAmountOfFurniture(2))
    hotelRoom.changeFurnitureAmount(RoomType.BATHROOM, FurnitureType.BATHROOM_CABINET, changeAmountOfFurniture(4))
}

val baseToPenthouseModifier: (hotelRoom: HotelRoom) -> Unit = {hotelRoom ->
    hotelRoom.takeRoom(RoomType.BEDROOM)
        .forEach {
            it.deleteFurniture(FurnitureType.SINGLE_BED)
            it.addFurniture(Furniture(FurnitureType.KING_SIZE_BED, 1))
            it.deleteFurniture(FurnitureType.WARDROBE)
            it.addFurniture(Furniture(FurnitureType.WARDROBE, 2))
            it.addFurniture(Furniture(FurnitureType.TV, 1))
        }
    hotelRoom.takeRoom(RoomType.LIVING_ROOM)
        .forEach {
            it.deleteFurniture(FurnitureType.CHAIR)
            it.addFurniture(Furniture(FurnitureType.CHAIR, 8))
        }
    hotelRoom.takeRoom(RoomType.BATHROOM)
        .forEach {
            it.deleteFurniture(FurnitureType.RUG)
            it.addFurniture(Furniture(FurnitureType.RUG, 3))
            it.deleteFurniture(FurnitureType.BATHROOM_CABINET)
            it.addFurniture(Furniture(FurnitureType.BATHROOM_CABINET, 4))
        }
}

fun createHotelRoom(
    hotelRoomType: HotelRoomType,
    roomTypes: List<RoomType>,
    modifier: ((hotelRoom: HotelRoom) -> Unit)? = null,
    status: HotelRoomStatus = HotelRoomStatus.AVAILABLE
): HotelRoom {
    val hotelRoom = HotelRoom(hotelRoomType, createRooms(roomTypes), status)
    modifier?.let { it(hotelRoom) }
    return hotelRoom
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
