package com.rafengimprove.study.base.knowledge.table

class Table(
    private val length: Double,
    private val width: Double,
    private var area: Double = length * width,
    private val items: MutableList<Item> = mutableListOf()
) {

    init {
        require(length > 0.0 && width > 0.0)
    }

    fun putItemOnTable(item: Item): Double {
        if (area == 0.0) {
            println("Nothing can be put on this table")
            return 0.0
        } else if (item.area == 0.0) {
            println("This item doesn't exist and can't be put on the table")
            return area
        }

        val availableSpace = area - item.area
        return if (availableSpace >= 0) {
            items.add(item)
            area = availableSpace
            area
        } else {
            println("There is not enough space on the table")
            area
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
}

data class Item(
    val name: String,
    val description: String,
    val length: Double,
    val width: Double
) {
    val area by lazy { length * width }
}

fun main() {
    val table = Table(10.0, 5.0)
    table.putItemOnTable(
        Item(
            "Monitor",
            "Very expensive",
            10.0,
            2.0
        )
    )

    table.putItemOnTable(
        Item(
            "Lamp",
            "Very expensive",
            10.0,
            3.0
        )
    )

    println(table)

    table.removeItemFromTable(
        Item(
            "Lamp",
            "Very expensive",
            10.0,
            3.0
        )
    )
    println(table)

    val anotherTable = Table(10.0, 10.0)
    anotherTable.putItemOnTable(
        Item(
            "Lamp",
            "Very expensive",
            0.0,
            0.0
        )
    )

    println(anotherTable)

    val zeroTable = Table(1.0, 0.0)

}

