package com.rafengimprove.study.base.knowledge.hotel.function

import com.rafengimprove.study.base.knowledge.hotel.model.dto.*
import com.rafengimprove.study.base.knowledge.hotel.model.dto.FurnitureType.*
import com.rafengimprove.study.base.knowledge.hotel.model.dto.RoomType.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class CreateHotelRoomTest {

    @Test
    fun `Happy pass - create a hotel room with furniture`() {

        val singleRoom = createHotelRoom(HotelRoomType.SINGLE, listOf(BATHROOM, BEDROOM))
        val doubleRoom = createHotelRoom(HotelRoomType.DOUBLE, listOf(BATHROOM, BEDROOM), baseToDoubleModifier)
        val luxuryRoom = createHotelRoom(HotelRoomType.LUXURY, listOf(LIVING_ROOM, BATHROOM, BEDROOM), baseToLuxuryModifier)
        val penthouseRoom = createHotelRoom(HotelRoomType.PENTHOUSE, listOf(LIVING_ROOM, BATHROOM, BEDROOM), baseToPenthouseModifier)
        val specialSingleRoom = createHotelRoom(HotelRoomType.SINGLE, listOf(BATHROOM, BEDROOM), baseToLuxuryModifier)
    }
}

val baseToDoubleModifier: (hotelRoom: HotelRoom) -> Unit = { hotelRoom ->
    hotelRoom.rooms
        .find { it.roomType == BEDROOM }
        ?.let {
            it.deleteFurniture(SINGLE_BED)
            it.addFurniture(Furniture(DOUBLE_BED, 1))
        }
}

val baseToLuxuryModifier: (hotelRoom: HotelRoom) -> Unit = { hotelRoom ->
    hotelRoom.takeRoom(BEDROOM)
        .forEach {
            it.deleteFurniture(SINGLE_BED)
            it.addFurniture(Furniture(QUEEN_SIZE_BED, 1))
        }
    hotelRoom.rooms
        .find { it.roomType == BATHROOM }
        ?.furnitureList
        ?.find { it.furnitureType == RUG }?.let { it.amount = 2 }
    hotelRoom.rooms
        .find { it.roomType == BATHROOM }
        ?.furnitureList
        ?.find { it.furnitureType == BATHROOM_CABINET }?.let { it.amount = 4 }
    hotelRoom.changeFurnitureAmount(BATHROOM, RUG, changeAmountOfFurniture(hotelRoom.rooms.))
}

val baseToPenthouseModifier: (hotelRoom: HotelRoom) -> Unit = {hotelRoom ->
    hotelRoom.takeRoom(BEDROOM)
        .forEach {
            it.deleteFurniture(SINGLE_BED)
            it.addFurniture(Furniture(KING_SIZE_BED, 1))
            it.deleteFurniture(WARDROBE)
            it.addFurniture(Furniture(WARDROBE, 2))
            it.addFurniture(Furniture(TV, 1))
        }
    hotelRoom.takeRoom(LIVING_ROOM)
        .forEach {
            it.deleteFurniture(CHAIR)
            it.addFurniture(Furniture(CHAIR, 8))
        }
    hotelRoom.takeRoom(BATHROOM)
        .forEach {
            it.deleteFurniture(RUG)
            it.addFurniture(Furniture(RUG, 3))
            it.deleteFurniture(BATHROOM_CABINET)
            it.addFurniture(Furniture(BATHROOM_CABINET, 4))
        }
}



fun createHotelRoom(
    hotelRoomType: HotelRoomType,
    roomTypes: List<RoomType>,
    modifier: ((hotelRoom: HotelRoom) -> Unit)? = null,
    status: HotelRoomStatus = HotelRoomStatus.AVAILABLE
) {
    val hotelRoom = HotelRoom(hotelRoomType, createRooms(roomTypes), status)
    modifier?.let { it(hotelRoom) }
}

fun createRooms(roomTypes: List<RoomType>): List<Room> {
    return roomTypes.map(::createRoom)
}

fun createRoom(roomType: RoomType): Room = when (roomType) {
    BEDROOM -> Room(
        BEDROOM,
        mutableListOf(
            Furniture(SINGLE_BED, 1),
            Furniture(BEDSIDE_CABINET, 2),
            Furniture(TABLE, 1),
            Furniture(CHAIR, 2),
            Furniture(FurnitureType.WARDROBE, 1),
        )
    )

    LIVING_ROOM -> Room(
        LIVING_ROOM,
        mutableListOf(
            Furniture(TABLE, 1),
            Furniture(CHAIR, 4),
            Furniture(TV, 1),
            Furniture(RUG, 1),
        )
    )

    BATHROOM -> Room(
        BATHROOM,
        mutableListOf(
            Furniture(RUG, 1),
            Furniture(BATHROOM_CABINET, 1)
        )
    )
}