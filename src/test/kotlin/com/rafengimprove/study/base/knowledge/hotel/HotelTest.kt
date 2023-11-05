package com.rafengimprove.study.base.knowledge.hotel

import com.rafengimprove.study.base.knowledge.hotel.model.dto.*
import com.rafengimprove.study.base.knowledge.hotel.model.dto.HotelRoomType.*
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class HotelTest {
    @Order(1)
    @Test
    fun `Happy pass - create a hotel`() {
        val hotel = createHotel()
        assertThat(hotel.name).isEqualTo("Metropolis")
        assertThat(hotel.description).isEqualTo("Very expensive hotel")
        assertThat(hotel.numberOfFloors).isEqualTo(10)
        assertThat(hotel.numberOfRooms).isEqualTo(150)
        assertThat(hotel.numberOfSingleRooms).isEqualTo(20)
        assertThat(hotel.numberOfDoubleRooms).isEqualTo(50)
        assertThat(hotel.numberOfPenthouses).isEqualTo(80)
        assertThat(hotel.hotelRooms.size).isEqualTo(2)
    }

    private fun changeRooms(hotel: Hotel, oldHotelRoom: HotelRoom, newHotelRoom: HotelRoom) {
        if(hotel.hotelRooms.contains(oldHotelRoom)) {
            hotel.hotelRooms.remove(oldHotelRoom)

//            when(oldHotelRoom.hotelRoomType) {
//                PENTHOUSE -> hotel.hotelRooms.add(newHotelRoom)
//            }


        }else{
            throw RuntimeException("There isn't such a room in this hotel")
        }
    }
    private fun createHotel() = Hotel(
        "Metropolis", "Very expensive hotel", 10, 150, 20, 50, 80,
        mutableListOf(
            HotelRoom(
                SINGLE,
                listOf<Room>(
                    Room(
                        RoomType.BEDROOM,
                        listOf<Furniture>(
                            Furniture(FurnitureType.SINGLE_BED, 1),
                            Furniture(FurnitureType.BEDSIDE_CABINET, 2),
                            Furniture(FurnitureType.TABLE, 1),
                            Furniture(FurnitureType.CHAIR, 2),
                        )
                    ),
                    Room(
                        RoomType.BATHROOM,
                        listOf<Furniture>(
                            Furniture(FurnitureType.RUG, 1),
                            Furniture(FurnitureType.BATHROOM_CABINET, 1)
                        )
                    )
                )
            ),
            HotelRoom(
                DOUBLE,
                listOf<Room>(
                    Room(
                        RoomType.BEDROOM,
                        listOf<Furniture>(
                            Furniture(FurnitureType.DOUBLE_BED, 1),
                            Furniture(FurnitureType.BEDSIDE_CABINET, 2),
                            Furniture(FurnitureType.TABLE, 1),
                            Furniture(FurnitureType.CHAIR, 2),
                            Furniture(FurnitureType.WARDROBE, 1),
                        )
                    ),
                    Room(
                        RoomType.BATHROOM,
                        listOf<Furniture>(
                            Furniture(FurnitureType.RUG, 1),
                            Furniture(FurnitureType.BATHROOM_CABINET, 2)
                        )
                    )
                )
            )
        )
    )
}