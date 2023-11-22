package com.rafengimprove.study.base.knowledge.hotel.service

import com.rafengimprove.study.base.knowledge.hotel.common.createHotel
import com.rafengimprove.study.base.knowledge.hotel.model.dto.Hotel
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class HotelService {
    private val log = LoggerFactory.getLogger(HotelService::class.java)
    private val hotel = createHotel("Our hotel", "The best hotel in the world")

    fun takeHotel(): Hotel {
        log.debug("Take hotel from service")
        return hotel
    }
}
