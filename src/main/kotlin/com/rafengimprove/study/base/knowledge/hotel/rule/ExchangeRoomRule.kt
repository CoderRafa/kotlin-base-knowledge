package com.rafengimprove.study.base.knowledge.hotel.rule

import com.rafengimprove.study.base.knowledge.hotel.model.dto.Hotel
import com.rafengimprove.study.base.knowledge.hotel.model.dto.HotelRoom
import com.rafengimprove.study.base.knowledge.hotel.model.dto.HotelRoomStatus

interface RuleFactory {
    fun createHotelRoomExchangeRule(): ExchangeRule
    fun createServicesRule(): ServiceRule
}

class BasicRuleFactoryImpl : RuleFactory {
    override fun createHotelRoomExchangeRule(): ExchangeRule {
        return object : ExchangeRule {
            override fun exchange(room: HotelRoom, hotel: Hotel): HotelRoom {
                return hotel.hotelRooms.firstOrNull { it.hotelRoomType == room.hotelRoomType && it.status == HotelRoomStatus.READY }
                    ?: throw HotelRoomNotFoundException()
            }

        }
    }

    override fun createServicesRule(): ServiceRule {
        return object : ServiceRule {
            override fun isWelcomeBucketNeeded(): Boolean = false

            override fun isBreakfastFree(): Boolean = false

            override fun discountForServicesRate(): Int = 3
        }
    }
}

class MediumRuleFactoryImpl : RuleFactory {
    override fun createHotelRoomExchangeRule(): ExchangeRule {
        TODO("Not yet implemented")
    }

    override fun createServicesRule(): ServiceRule {
        TODO("Not yet implemented")
    }

}

class LuxuryRuleFactoryImpl: RuleFactory {
    private var isExtraServicesEnabled = false
    override fun createHotelRoomExchangeRule(): ExchangeRule {
        val canImproveHotelRoom: Boolean = false
        if (!canImproveHotelRoom) isExtraServicesEnabled = true
        TODO("Not yet implemented")
    }

    override fun createServicesRule(): ServiceRule {
        if (isExtraServicesEnabled) {
            //somthing else
        } else {
            // one option
        }
        TODO("Not yet implemented")
    }

}

interface ExchangeRule {
    fun exchange(room: HotelRoom, hotel: Hotel): HotelRoom
}

interface ServiceRule {
    fun isWelcomeBucketNeeded(): Boolean
    fun isBreakfastFree(): Boolean
    fun discountForServicesRate(): Int
}

class HotelRoomNotFoundException(message: String = "Room was not found") : RuntimeException(message)