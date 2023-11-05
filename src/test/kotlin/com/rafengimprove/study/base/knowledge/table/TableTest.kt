package com.rafengimprove.study.base.knowledge.table

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class TableTest {
    private val table = Table(10.0, 10.0)
    private val lamp = Item("lamp", "nice lamp", 5.0, 5.0)
    private val mouse = Item("mouse", "nice mouse", 2.0, 2.0)
    private val monitor = Item("monitor", "big monitor", 12.0, 12.0)
    private val zeroItem = Item("zeroItem", "item has zero width", 5.0, 0.0)

    @Order(1)
    @Test
    fun `Happy pass - an item can be put on the table`() {
        assertThat(table.putItemOnTable(lamp)).isEqualTo(75.0)
        assertThat(table.countItems()).isEqualTo(1)
    }

    @Order(5)
    @Test
    fun `Happy pass - put multiple items on the table and show their amount`() {
        assertThat(table.putItemOnTable(lamp)).isEqualTo(75.0)
        assertThat(table.putItemOnTable(mouse)).isEqualTo(71.0)
        assertThat(table.putItemOnTable(mouse)).isEqualTo(67.0)
        assertThat(table.countItems()).isEqualTo(3)

    }

    @Order(10)
    @Test
    fun `Negative pass - the item is bigger than the available space on the table`() {
        assertThrows<ThereIsNotEnoughSpaceOnTheTable> { table.putItemOnTable(monitor) }
    }

    @Order(15)
    @Test
    fun `Negative pass - the item has 0 width`() {
        assertThrows<ItemWithoutAreaException> { table.putItemOnTable(zeroItem) }
    }

    @Order(20)
    @Test
    fun `Negative pass - the table has zero area`() {
        assertThrows<IllegalArgumentException> { Table(0.0, 5.0) }
    }

    @Order(25)
    @Test
    fun `Negative pass - the second item's area is bigger than the available space`() {
        assertThat(table.putItemOnTable(lamp)).isEqualTo(75.0)
        assertThrows<ThereIsNotEnoughSpaceOnTheTable> { table.putItemOnTable(monitor) }
    }
}