package com.rafengimprove.study.base.knowledge.table

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class TableTest {

    private val table = Table(10.0, 5.0)
    private val lamp = Item("lamp", "cool lamp", 5.0, 5.0)
    private val monitor = Item("monitor", "big monitor", 10.0, 10.0)

    @Test
    fun `Happy pass - an item can be put on the table with positive length and width`() {

        Assertions.assertTrue(table.putItemOnTable(lamp) == 25.0)
    }

    @Test
    fun `Negative pass - an item that has a bigger area than available space on the table can't be put on the table`() {
        Assertions.assertTrue(table.putItemOnTable(monitor) == 50.0)
    }

    @Test
    fun `Negative pass - a table's width or height is below zero`() {
        val zeroTable = Table(0.0, 5.0)
        Assertions.assertThrows(IllegalArgumentException, zeroTable, "Failed requirement")
    }
}