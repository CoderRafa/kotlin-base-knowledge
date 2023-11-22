package com.rafengimprove.study.base.knowledge.hotel.model.dto

import com.rafengimprove.study.base.knowledge.hotel.model.dto.HotelRoomType.*

data class Hotel(
    val name: String,
    val description: String,
    val numberOfFloors: Int,
    val numberOfRooms: Int,
    val numberOfSingleRooms: Int,
    val numberOfDoubleRooms: Int,
    var numberOfLuxuries: Int,
    val numberOfPenthouses: Int,
    val hotelRooms: MutableList<HotelRoom>
)

fun Hotel.changeTo(
    hotelRoomType: HotelRoomType,
    changeToHotelRoomType: HotelRoomType
) {
    this.hotelRooms.removeIf { it.hotelRoomType == hotelRoomType }

    List(numberOfRooms - this.hotelRooms.size) {
        createHotelRoomBy(changeToHotelRoomType)
    }.also { this.hotelRooms.addAll(it) }
}


interface ExchangeHotelRoomRuleStrategy {
    fun exchange(numberOfLuxuryToExchange: Int? = null): ExchangeHotelRoomRule
    fun reverse(numberOfSinglesToChange: Int?): ExchangeHotelRoomRule
}

interface ExchangeHotelRoomRule {
    fun exchange(hotel: Hotel): Hotel
}

class LuxuryToSingleExchangeHotelRoomRuleStrategy(
    private val ratio: Int = 3
) : ExchangeHotelRoomRuleStrategy {
    override fun exchange(numberOfLuxuryToExchange: Int?): ExchangeHotelRoomRule {
        var howManyRepeat = numberOfLuxuryToExchange
        return object : ExchangeHotelRoomRule {
            override fun exchange(hotel: Hotel): Hotel {
                hotel.hotelRooms.removeIf {
                    if (it.hotelRoomType == LUXURY
                        && numberOfLuxuryToExchange != null
                        && numberOfLuxuryToExchange > 0
                    ) {
                        howManyRepeat = howManyRepeat!! - 1
                        true
                    } else if (numberOfLuxuryToExchange == null && it.hotelRoomType == LUXURY) {
                        true
                    } else {
                        false
                    }
                }
                if (hotel.numberOfLuxuries != hotel.hotelRooms.filter { it.hotelRoomType == LUXURY }.size) {
                    repeat(
                        numberOfLuxuryToExchange ?: hotel.numberOfLuxuries
                    ) { hotel.hotelRooms.addAll(List(ratio) { createHotelRoomBy(SINGLE) }) }
                }
                return hotel
            }
        }
    }

    override fun reverse(numberOfSinglesToChange: Int?): ExchangeHotelRoomRule {
        return object : ExchangeHotelRoomRule {
            override fun exchange(hotel: Hotel): Hotel {
                if (numberOfSinglesToChange != null && numberOfSinglesToChange < ratio) return hotel
                val repetition = numberOfSinglesToChange ?: hotel.numberOfSingleRooms
                hotel.hotelRooms.asSequence().filter { it.hotelRoomType == SINGLE }.take(repetition).toSet().also { hotel.hotelRooms.removeAll(it) }

                val count = hotel.hotelRooms.count { it.hotelRoomType == SINGLE }
                if (count != hotel.numberOfSingleRooms && hotel.numberOfSingleRooms - count >= ratio) {

                }
                return hotel
            }

        }
        TODO("Not yet implemented")
    }
}

//class LuxuryToAnotherTypeRuleStrategy(private var numberOfLuxuryToExchange: Int? = null) :
//    ExchangeHotelRoomRuleStrategy {
//
//    var ratio: Int = 1
//    val n: Int = 1
//    override fun exchange(): ExchangeHotelRoomRule {
//        return object : ExchangeHotelRoomRule {
//            override fun exchange(hotel: Hotel): Hotel {
//                when (to) {
//                    SINGLE -> ratio = 3
//                    DOUBLE -> ratio = 2
//                    FAMILY -> ratio = 1
//                    else -> println("No other conversions are available")
//                }
//                hotel.hotelRooms.removeIf {
//                    if (it.hotelRoomType == LUXURY
//                        && numberOfLuxuryToExchange != null
//                        && numberOfLuxuryToExchange!! > 0
//                    ) {
//                        numberOfLuxuryToExchange = numberOfLuxuryToExchange!! - 1
//                        true
//                    } else {
//                        false
//                    }
//                }
//
//                val beforeChangeNumberOfLuxuries = hotel.numberOfLuxuries
//                val afterChangeNumberOfLuxuries = hotel.hotelRooms.filter { it.hotelRoomType == LUXURY }.size
//                val repeatArgument = beforeChangeNumberOfLuxuries - afterChangeNumberOfLuxuries
//
//                if (beforeChangeNumberOfLuxuries != afterChangeNumberOfLuxuries) {
//                    repeat(repeatArgument) {
//                        hotel.hotelRooms.addAll(List(ratio) { createHotelRoomBy(to) })
//                    }
//
//                    hotel.numberOfLuxuries = afterChangeNumberOfLuxuries
//                }
//
//                return hotel
//            }
//
//        }
//    }
//
//    override fun reverse(): ExchangeHotelRoomRule {
//        TODO("Not yet implemented")
//    }
//}