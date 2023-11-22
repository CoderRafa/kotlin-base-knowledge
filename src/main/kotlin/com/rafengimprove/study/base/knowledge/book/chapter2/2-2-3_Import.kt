package com.rafengimprove.study.base.knowledge.book.chapter2

import kotlin.random.Random

class Rectangle1(private val height: Int, private val width: Int) {
    val isSquare: Boolean
        get() = height == width
}

fun createRandomRectangle(): Rectangle {
    return Rectangle(Random.nextInt(), Random.nextInt())
}

fun main() {
    val rect = createRandomRectangle()
    println("""
        The height is ${rect.height}
        The width is ${rect.width}
        Is it square: ${rect.isSquare}
        """.trimIndent())
}