package com.rafengimprove.study.base.knowledge.hotel.function

import com.rafengimprove.study.base.knowledge.hotel.model.dto.*
import com.rafengimprove.study.base.knowledge.hotel.model.dto.FurnitureType.*
import com.rafengimprove.study.base.knowledge.hotel.model.dto.HotelRoomType.*
import com.rafengimprove.study.base.knowledge.hotel.model.dto.RoomType.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class CreateHotelRoomTest {

    @Test
    fun `Happy pass - create a hotel room with furniture`() {
        val singleRoom = createHotelRoomBy(SINGLE)
        val doubleRoom = createHotelRoomBy(DOUBLE)
        val luxuryRoom = createHotelRoomBy(LUXURY)
        val penthouseRoom = createHotelRoomBy(PENTHOUSE)
        val specialSingleRoom = createHotelRoom(SINGLE, listOf(BATHROOM, BEDROOM), baseToLuxuryModifier)
    }
}