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
        val luxuryRoom = createHotelRoom(HotelRoomType.LUXURY, listOf(LIVING_ROOM, BATHROOM, BEDROOM), baseToLuxuryModifier)
        val singleRoom = createHotelRoom(HotelRoomType.SINGLE, listOf(BATHROOM, BEDROOM), baseToLuxuryModifier)
        val specialSingleRoom = createHotelRoom(HotelRoomType.SINGLE, listOf(BATHROOM, BEDROOM), baseToLuxuryModifier)
        val doubleRoom = createHotelRoom(HotelRoomType.DOUBLE, listOf(BATHROOM, BEDROOM), baseToLuxuryModifier)
    }
}

val baseToLuxuryModifier: (hotelRoom: HotelRoom) -> Unit = { hotelRoom ->
    hotelRoom.takeRoom(BEDROOM)
        .forEach {
            it.deleteFurniture(DOUBLE_BED)
            it.addFurniture(Furniture(QUEEN_SIZE_BED, 1))
        }
}

fun createHotelRoom(
    hotelRoomType: HotelRoomType,
    roomTypes: List<RoomType>,
    modifier: ((hotelRoom: HotelRoom) -> Unit)? = null
) {
    val hotelRoom = HotelRoom(hotelRoomType, createRooms(roomTypes))
    modifier?.let { it(hotelRoom) }
}

fun createRooms(roomTypes: List<RoomType>): List<Room> {
    return roomTypes.map(::createRoom)
}

fun createRoom(roomType: RoomType): Room = when (roomType) {
    BEDROOM -> Room(
        BEDROOM,
        mutableListOf(
            Furniture(DOUBLE_BED, 1),
            Furniture(BEDSIDE_CABINET, 2),
            Furniture(TABLE, 1),
            Furniture(CHAIR, 2),
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
            Furniture(BATHROOM_CABINET, 2)
        )
    )
}