package com.rafengimprove.study.base.knowledge.table

import org.slf4j.LoggerFactory

class Table(
    private val length: Double,
    private val width: Double,
    private var area: Double = length * width,
    private val items: MutableList<Item> = mutableListOf()
) {
    private val log = LoggerFactory.getLogger(Table::class.java)

    init {
        require(length > 0.0 && width > 0.0)
    }

    fun putItemOnTable(item: Item): Double {
        if (item.area == 0.0) {
            throw ItemWithoutAreaException("This item doesn't exist and can't be put on the table")
        }

        val availableSpace = area - item.area
        return if (availableSpace >= 0) {
            items.add(item)
            area = availableSpace
            area
        } else {
            throw ThereIsNotEnoughSpaceOnTheTable("There is not enough space on the table")
        }
    }

    fun removeItemFromTable(item: Item): Double {
        val availableSpace = area + (item.length * item.width)

        items.remove(item)
        area = availableSpace
        return area
    }

    override fun toString(): String {
        return if (items.isEmpty()) {
            "The table is empty"
        } else {
            "Table(items=${items.joinToString()})"
        }
    }

    fun countItems(): Int {
        log.debug("Count items on the table")
        return items.size
    }
}

class ItemWithoutAreaException(message: String): RuntimeException(message)
class ThereIsNotEnoughSpaceOnTheTable(message: String): RuntimeException(message)

