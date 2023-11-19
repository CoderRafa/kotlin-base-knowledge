package com.rafengimprove.study.base.knowledge.hotel.model.dto

import com.rafengimprove.study.base.knowledge.hotel.model.dto.HotelRoomType.LUXURY
import com.rafengimprove.study.base.knowledge.hotel.model.dto.HotelRoomType.SINGLE

data class Hotel(
    val name: String,
    val description: String,
    val numberOfFloors: Int,
    val numberOfRooms: Int,
    val numberOfSingleRooms: Int,
    val numberOfDoubleRooms: Int,
    val numberOfPenthouses: Int,
    val numberOfLuxuries: Int,
    val hotelRooms: MutableList<HotelRoom>
)

fun Hotel.changeTo(
    hotelRoomType: HotelRoomType,
    changeToHotelRoomType: HotelRoomType
): List<HotelRoom> {
    this.hotelRooms.removeIf { it.hotelRoomType == hotelRoomType }
    return List(numberOfRooms - this.hotelRooms.size) {
        createHotelRoomBy(changeToHotelRoomType)
    }.also { this.hotelRooms.addAll(it) }
}

interface ExchangeHotelRoomRuleStrategy {
    fun exchange(from: HotelRoomType, to: HotelRoomType): ExchangeHotelRoomRule
}

interface ExchangeHotelRoomRule {
    fun exchange(hotel: Hotel): Hotel
}

class LuxuryToSingleExchangeHotelRoomRuleStrategy(private val ratio: Int = 3, private var numberOfLuxuryToExchange: Int? = null) : ExchangeHotelRoomRuleStrategy {
    override fun exchange(from: HotelRoomType, to: HotelRoomType): ExchangeHotelRoomRule {
        return object : ExchangeHotelRoomRule {
            override fun exchange(hotel: Hotel): Hotel {
                hotel.hotelRooms.removeIf {
                    if (it.hotelRoomType == LUXURY && numberOfLuxuryToExchange != null && numberOfLuxuryToExchange!! > 0) {
                        numberOfLuxuryToExchange = numberOfLuxuryToExchange!! - 1
                        true
                    } else if (numberOfLuxuryToExchange == null && it.hotelRoomType == LUXURY) {
                        true
                    } else {
                        false
                    }
                }
                if (hotel.numberOfLuxuries != hotel.hotelRooms.filter { it.hotelRoomType == LUXURY }.size) {
                    repeat(numberOfLuxuryToExchange ?: hotel.numberOfLuxuries) { hotel.hotelRooms.addAll(List(ratio) { createHotelRoomBy(SINGLE) }) }
                }
                return hotel
            }
        }
    }
}