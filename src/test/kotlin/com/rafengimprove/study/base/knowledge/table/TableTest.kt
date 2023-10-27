package com.rafengimprove.study.base.knowledge.table

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.*
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension

@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
@ExtendWith(MockitoExtension::class)
class TableTest {

    private val table = Table(10.0, 5.0)
    private val lamp = Item("lamp", "cool lamp", 5.0, 5.0)
    private val monitor = Item("monitor", "big monitor", 10.0, 10.0)

    @Order(1)
    @Test
    fun `Happy pass - an item can be put on the table with positive length and width`() {
        assertThat(table.putItemOnTable(lamp)).isEqualTo(25.0)
        assertThat(table.countItems()).isEqualTo(1)
    }

    @Order(2)
    @Test
    fun `Negative pass - an item cannot be put on the table`() {
        assertThat(table.putItemOnTable(lamp)).isEqualTo(25.0)
        assertThat(table.countItems()).isEqualTo(1)
        assertThrows<RuntimeException> { table.putItemOnTable(monitor) }
    }


    @Order(3)
    @Test
    fun `Negative pass - a table's width or height is below zero`() {
        assertThrows<IllegalArgumentException>("Table has not enough space") { Table(0.0, 5.0) }
        assertThat(table.countItems()).isEqualTo(0)
    }
}