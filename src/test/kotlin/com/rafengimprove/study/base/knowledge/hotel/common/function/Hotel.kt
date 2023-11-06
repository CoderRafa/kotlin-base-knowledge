package com.rafengimprove.study.base.knowledge.hotel.common.function

import com.rafengimprove.study.base.knowledge.hotel.model.dto.*

fun createHotel() = Hotel(
    "Metropolis", "Very expensive hotel", 10, 150, 20, 50, 80,
    mutableListOf(
        HotelRoom(
            HotelRoomType.SINGLE,
            listOf(
                Room(
                    RoomType.BEDROOM,
                    listOf(
                        Furniture(FurnitureType.SINGLE_BED, 1),
                        Furniture(FurnitureType.BEDSIDE_CABINET, 2),
                        Furniture(FurnitureType.TABLE, 1),
                        Furniture(FurnitureType.CHAIR, 2),
                    )
                ),
                Room(
                    RoomType.BATHROOM,
                    listOf(
                        Furniture(FurnitureType.RUG, 1),
                        Furniture(FurnitureType.BATHROOM_CABINET, 1)
                    )
                )
            )
        ),
        HotelRoom(
            HotelRoomType.DOUBLE,
            listOf(
                Room(
                    RoomType.BEDROOM,
                    listOf(
                        Furniture(FurnitureType.DOUBLE_BED, 1),
                        Furniture(FurnitureType.BEDSIDE_CABINET, 2),
                        Furniture(FurnitureType.TABLE, 1),
                        Furniture(FurnitureType.CHAIR, 2),
                        Furniture(FurnitureType.WARDROBE, 1),
                    )
                ),
                Room(
                    RoomType.BATHROOM,
                    listOf(
                        Furniture(FurnitureType.RUG, 1),
                        Furniture(FurnitureType.BATHROOM_CABINET, 2)
                    )
                )
            )
        )
    )
)

