package com.rafengimprove.study.base.knowledge.hotel.model.dto

import com.rafengimprove.study.base.knowledge.hotel.common.function.createHotel
import com.rafengimprove.study.base.knowledge.hotel.model.dto.*
import com.rafengimprove.study.base.knowledge.hotel.model.dto.HotelRoomType.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class HotelTest {

    private val hotel = createHotel()

    @Order(1)
    @Test
    fun `Happy pass - create a hotel`() {
        assertThat(hotel.name).isEqualTo("Metropolis")
        assertThat(hotel.description).isEqualTo("Very expensive hotel")
        assertThat(hotel.numberOfFloors).isEqualTo(10)
        assertThat(hotel.numberOfRooms).isEqualTo(150)
        assertThat(hotel.numberOfSingleRooms).isEqualTo(20)
        assertThat(hotel.numberOfDoubleRooms).isEqualTo(50)
        assertThat(hotel.numberOfLuxuries).isEqualTo(20)
        assertThat(hotel.numberOfPenthouses).isEqualTo(80)
        assertThat(hotel.hotelRooms.size).isEqualTo(2)
    }

    @Order(5)
    @Test
    fun `Happy pass - A luxury room is exchanged to 3 single rooms`() {
        val luxuryToSingle = LuxuryToAnotherTypeRuleStrategy(1)
        val changedHotel = luxuryToSingle.exchange(LUXURY, SINGLE).exchange(hotel)
        assertThat(changedHotel.numberOfLuxuries == 19)
        assertThat(changedHotel.hotelRooms.filter { it.hotelRoomType == SINGLE }.size == 23)
    }

    @Order(10)
    @Test
    fun `Happy pass - 10 luxury rooms are exchanged to 30 single rooms`() {
        val luxuryToSingle = LuxuryToAnotherTypeRuleStrategy(10)
        val changedHotel = luxuryToSingle.exchange(LUXURY, SINGLE).exchange(hotel)
        assertThat(changedHotel.numberOfLuxuries == 10)
        assertThat(changedHotel.hotelRooms.filter { it.hotelRoomType == SINGLE }.size == 50)
    }

    @Order(15)
    @Test
    fun `Happy pass - A luxury room ia exchanged to 2 doubles rooms`() {
        val luxuryToSingle = LuxuryToAnotherTypeRuleStrategy(1)
        val changedHotel = luxuryToSingle.exchange(LUXURY, DOUBLE).exchange(hotel)
        assertThat(changedHotel.numberOfLuxuries == 19)
        assertThat(changedHotel.hotelRooms.filter { it.hotelRoomType == DOUBLE }.size == 52)
    }
}