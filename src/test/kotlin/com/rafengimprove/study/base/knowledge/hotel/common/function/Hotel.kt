package com.rafengimprove.study.base.knowledge.hotel.common.function

import com.rafengimprove.study.base.knowledge.hotel.model.dto.*
import com.rafengimprove.study.base.knowledge.hotel.model.dto.HotelRoomStatus.*
import com.rafengimprove.study.base.knowledge.hotel.model.dto.HotelRoomType.*

fun createHotel() = Hotel(
    "Metropolis", "Very expensive hotel", 10, 150, 20, 50, 20,80,
    mutableListOf(
        createHotelRoomBy(SINGLE),
        createHotelRoomBy(DOUBLE)
    )
)

