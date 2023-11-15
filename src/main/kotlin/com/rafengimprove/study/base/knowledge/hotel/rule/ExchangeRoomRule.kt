package com.rafengimprove.study.base.knowledge.hotel.rule

import com.rafengimprove.study.base.knowledge.hotel.model.dto.Hotel
import com.rafengimprove.study.base.knowledge.hotel.model.dto.HotelRoom
import com.rafengimprove.study.base.knowledge.hotel.model.dto.HotelRoomStatus.READY
import com.rafengimprove.study.base.knowledge.hotel.model.dto.HotelRoomType.*

interface RuleFactory {
    fun createHotelRoomExchangeRule(): ExchangeRule
    fun createServicesRule(): ServiceRule
}

class BasicRuleFactoryImpl : RuleFactory {
    override fun createHotelRoomExchangeRule(): ExchangeRule {
        return object : ExchangeRule {
            override fun exchange(room: HotelRoom, hotel: Hotel): HotelRoom {
                return hotel.hotelRooms.firstOrNull { it.hotelRoomType == room.hotelRoomType && it.status == READY }
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
        return object : ExchangeRule {
            override fun exchange(room: HotelRoom, hotel: Hotel): HotelRoom {
                return when (room.hotelRoomType) {
                    SINGLE -> hotel.hotelRooms.firstOrNull {
                        it.hotelRoomType == DOUBLE && it.status == READY
                    } ?: throw HotelRoomNotFoundException()

                    DOUBLE, -> hotel.hotelRooms.firstOrNull {
                        it.hotelRoomType == LUXURY && it.status == READY
                    } ?: throw HotelRoomNotFoundException()

                    LUXURY, PENTHOUSE -> hotel.hotelRooms.firstOrNull {
                        it.hotelRoomType == PENTHOUSE && it.status == READY
                    } ?: throw HotelRoomNotFoundException()
                    else -> throw HotelRoomNotFoundException()
                }
            }
        }
    }

    override fun createServicesRule(): ServiceRule {
        return object : ServiceRule {
            override fun isWelcomeBucketNeeded(): Boolean = false
            override fun isBreakfastFree(): Boolean = true
            override fun discountForServicesRate(): Int = 10
        }
    }

}

class LuxuryRuleFactoryImpl : RuleFactory {
    private var isExtraServicesEnabled = false
    private var canImproveHotelRoom: Boolean = false
    override fun createHotelRoomExchangeRule(): ExchangeRule {
        return object : ExchangeRule {
            override fun exchange(room: HotelRoom, hotel: Hotel): HotelRoom {
                val isAvailable = hotel.hotelRooms.firstOrNull { it.hotelRoomType == PENTHOUSE && it.status == READY }
                if (isAvailable != null) {
                    canImproveHotelRoom = true
                    return isAvailable
                }
                if (!canImproveHotelRoom) isExtraServicesEnabled = true
                throw HotelRoomNotFoundException()
            }
        }
    }

    override fun createServicesRule(): ServiceRule {
        return if (isExtraServicesEnabled) {
            object : ServiceRule {
                override fun isWelcomeBucketNeeded(): Boolean = true
                override fun isBreakfastFree(): Boolean = true
                override fun discountForServicesRate(): Int = 60
                override fun isPersonalDriver(): Boolean = true
                override fun isOperaTickets(): Boolean = true
            }
        } else {
            object : ServiceRule {
                override fun isWelcomeBucketNeeded(): Boolean = true
                override fun isBreakfastFree(): Boolean = true
                override fun discountForServicesRate(): Int = 25
            }
        }
    }
}


interface ExchangeRule {
    fun exchange(room: HotelRoom, hotel: Hotel): HotelRoom
}

interface ServiceRule {
    fun isWelcomeBucketNeeded(): Boolean
    fun isBreakfastFree(): Boolean
    fun discountForServicesRate(): Int
    fun isPersonalDriver(): Boolean = false
    fun isOperaTickets(): Boolean = false
}

class HotelRoomNotFoundException(message: String = "Room was not found") : RuntimeException(message)





















