package com.rafengimprove.study.base.knowledge.hotel.service

import com.rafengimprove.study.base.knowledge.hotel.model.dto.Hotel
import com.rafengimprove.study.base.knowledge.hotel.model.dto.HotelRoomType
import com.rafengimprove.study.base.knowledge.hotel.model.dto.LuxuryToAnotherTypeRuleStrategy
import org.springframework.stereotype.Service

@Service
class ExchangeRoomService(private val hotelService: HotelService) {
    fun exchangeRoom(fromType: HotelRoomType, toType: HotelRoomType, amount: Int): Hotel {
        val exchangeRoom = LuxuryToAnotherTypeRuleStrategy(amount)

        return exchangeRoom.exchange(fromType, toType).exchange(hotelService.takeHotel())
    }
}