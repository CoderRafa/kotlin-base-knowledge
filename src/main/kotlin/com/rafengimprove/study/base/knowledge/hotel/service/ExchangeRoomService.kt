package com.rafengimprove.study.base.knowledge.hotel.service

import com.rafengimprove.study.base.knowledge.hotel.model.dto.Hotel
import com.rafengimprove.study.base.knowledge.hotel.model.dto.HotelRoomType
import com.rafengimprove.study.base.knowledge.hotel.model.dto.LuxuryToAnotherTypeRuleStrategy
import org.springframework.stereotype.Service

@Service
class ExchangeRoomService {
    fun exchangeRoom(hotel: Hotel, fromType: HotelRoomType, amount: Int, toType: HotelRoomType): Hotel {
        val exchangeRoom = LuxuryToAnotherTypeRuleStrategy(amount)

        return exchangeRoom.exchange(fromType, toType).exchange(hotel)
    }
}