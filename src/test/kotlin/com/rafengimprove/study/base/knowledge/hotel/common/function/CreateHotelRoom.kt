package com.rafengimprove.study.base.knowledge.hotel.common.function

import com.rafengimprove.study.base.knowledge.hotel.model.dto.*

fun createSingleHotelRoom(status: HotelRoomStatus): HotelRoom {
    return HotelRoom(
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
    ),
        status
    )
}

fun createDoubleHotelRoom(status: HotelRoomStatus): HotelRoom {
    return HotelRoom(
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
        ),
        status
    )
}

fun createLuxuryHotelRoom(status: HotelRoomStatus): HotelRoom {
    return HotelRoom(
        HotelRoomType.LUXURY,
        listOf(
            Room(
                RoomType.BEDROOM,
                listOf(
                    Furniture(FurnitureType.QUEEN_SIZE_BED, 1),
                    Furniture(FurnitureType.BEDSIDE_CABINET, 2),
                    Furniture(FurnitureType.TABLE, 1),
                    Furniture(FurnitureType.CHAIR, 2),
                    Furniture(FurnitureType.WARDROBE, 1),
                )
            ),
            Room(
                RoomType.BEDROOM,
                listOf(
                    Furniture(FurnitureType.QUEEN_SIZE_BED, 1),
                    Furniture(FurnitureType.BEDSIDE_CABINET, 2),
                    Furniture(FurnitureType.TABLE, 1),
                    Furniture(FurnitureType.CHAIR, 2),
                    Furniture(FurnitureType.WARDROBE, 1),
                )
            ),
            Room(
                RoomType.LIVING_ROOM,
                listOf(
                    Furniture(FurnitureType.TABLE, 1),
                    Furniture(FurnitureType.CHAIR, 4),
                    Furniture(FurnitureType.TV, 1),
                    Furniture(FurnitureType.RUG, 1),
                )
            ),
            Room(
                RoomType.BATHROOM,
                listOf(
                    Furniture(FurnitureType.RUG, 2),
                    Furniture(FurnitureType.BATHROOM_CABINET, 4)
                )
            )
        ),
        status
    )
}

fun createPenthouseHotelRoom(status: HotelRoomStatus): HotelRoom {
    return HotelRoom(
        HotelRoomType.PENTHOUSE,
        listOf(
            Room(
                RoomType.BEDROOM,
                listOf(
                    Furniture(FurnitureType.KING_SIZE_BED, 1),
                    Furniture(FurnitureType.BEDSIDE_CABINET, 2),
                    Furniture(FurnitureType.TABLE, 1),
                    Furniture(FurnitureType.CHAIR, 2),
                    Furniture(FurnitureType.WARDROBE, 2),
                    Furniture(FurnitureType.TV, 1),
                )
            ),
            Room(
                RoomType.BEDROOM,
                listOf(
                    Furniture(FurnitureType.KING_SIZE_BED, 1),
                    Furniture(FurnitureType.BEDSIDE_CABINET, 2),
                    Furniture(FurnitureType.TABLE, 1),
                    Furniture(FurnitureType.CHAIR, 2),
                    Furniture(FurnitureType.WARDROBE, 2),
                    Furniture(FurnitureType.TV, 1),
                )
            ),
            Room(
                RoomType.LIVING_ROOM,
                listOf(
                    Furniture(FurnitureType.TABLE, 1),
                    Furniture(FurnitureType.CHAIR, 8),
                    Furniture(FurnitureType.TV, 1),
                    Furniture(FurnitureType.RUG, 1),
                )
            ),
            Room(
                RoomType.BATHROOM,
                listOf(
                    Furniture(FurnitureType.RUG, 3),
                    Furniture(FurnitureType.BATHROOM_CABINET, 4)
                )
            )
        ),
        status
    )
}

