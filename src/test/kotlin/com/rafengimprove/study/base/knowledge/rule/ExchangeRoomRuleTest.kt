package com.rafengimprove.study.base.knowledge.rule

import com.rafengimprove.study.base.knowledge.hotel.common.function.*
import com.rafengimprove.study.base.knowledge.hotel.model.dto.HotelRoomStatus.*
import com.rafengimprove.study.base.knowledge.hotel.model.dto.HotelRoomType
import com.rafengimprove.study.base.knowledge.hotel.rule.BasicRuleFactoryImpl
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class ExchangeRoomRuleTest {

    private val hotel = createHotel()
    private val basicRuleFactory = BasicRuleFactoryImpl()

    private fun checkBasicServiceRule() {
        assertThat(basicRuleFactory.createServicesRule().isWelcomeBucketNeeded()).isEqualTo(false)
        assertThat(basicRuleFactory.createServicesRule().isBreakfastFree()).isEqualTo(false)
        assertThat(basicRuleFactory.createServicesRule().discountForServicesRate()).isEqualTo(3)
    }

    @Test
    fun `Happy pass - basic exchange rule for a single room`() {

        hotel.hotelRooms.addAll(List(2) { createSingleHotelRoom(READY) })
        val exchange = basicRuleFactory.createHotelRoomExchangeRule().exchange(hotel.hotelRooms.first(), hotel)


        assertThat(exchange.hotelRoomType).isEqualTo(HotelRoomType.SINGLE)
        checkBasicServiceRule()
    }

    @Test
    fun `Happy pass - basic exchange rule for a double room`() {

        hotel.hotelRooms.addAll(List(2) { createDoubleHotelRoom(READY) })
        val exchange = basicRuleFactory.createHotelRoomExchangeRule().exchange(hotel.hotelRooms.first(), hotel)


        assertThat(exchange.hotelRoomType).isEqualTo(HotelRoomType.DOUBLE)
        checkBasicServiceRule()
    }

    @Test
    fun `Happy pass - basic exchange rule for a luxury room`() {

        hotel.hotelRooms.addAll(List(2) { createLuxuryHotelRoom(READY) })
        val exchange = basicRuleFactory.createHotelRoomExchangeRule().exchange(hotel.hotelRooms.first(), hotel)


        assertThat(exchange.hotelRoomType).isEqualTo(HotelRoomType.LUXURY)
        checkBasicServiceRule()
    }

    @Test
    fun `Happy pass - basic exchange rule for a penthouse room`() {

        hotel.hotelRooms.addAll(List(2) { createPenthouseHotelRoom(READY) })
        val exchange = basicRuleFactory.createHotelRoomExchangeRule().exchange(hotel.hotelRooms.first(), hotel)


        assertThat(exchange.hotelRoomType).isEqualTo(HotelRoomType.PENTHOUSE)
        checkBasicServiceRule()
    }
}