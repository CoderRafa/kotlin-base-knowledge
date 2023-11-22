package com.rafengimprove.study.base.knowledge.book.chapter2

import com.rafengimprove.study.base.knowledge.book.chapter2.Color.*

enum class Color(
    private val r: Int, private val g: Int, private val b: Int
) {
    RED(255, 0, 0), ORANGE(255, 165, 0), YELLOW(255, 255, 0),
    GREEN(0, 255, 0), BLUE(0, 0, 255), INDIGO(75, 0, 130),
    VIOLET(238, 130, 238);

    fun rgb() = (r * 256 + g) * 256 + b
}

fun getMnemonic(color: Color) =
    when (color) {
        RED -> "Каждый"
        ORANGE -> "Охотник"
        YELLOW -> "Желает"
        GREEN -> "Знать"
        BLUE -> "Где"
        INDIGO -> "Сидит"
        VIOLET -> "Фазан"
    }

fun getWarmth(color: Color) =
    when (color) {
        RED, ORANGE, YELLOW -> "Теплый"
        GREEN -> "Нейтральный"
        BLUE, INDIGO, VIOLET -> "Холодный"
    }

fun mix(c1: Color, c2: Color) {
    when (setOf(c1, c2)) {
        setOf(RED, YELLOW) -> ORANGE
        setOf(YELLOW, BLUE) -> GREEN
        setOf(BLUE, VIOLET) -> INDIGO
        else -> throw Exception("Dirty color")
    }
}

fun mixOptimized(c1: Color, c2: Color) =
    when {
        (c1 == RED && c2 == YELLOW) || (c1 == YELLOW && c2 == RED) -> ORANGE
        (c1 == YELLOW && c2 == BLUE) || (c1 == BLUE && c2 == YELLOW) -> GREEN
        (c1 == BLUE && c2 == VIOLET) || (c1 == VIOLET && c2 == BLUE) -> INDIGO
        else -> throw Exception("Dirty color")
    }

fun main() {
//    println(BLUE.rgb())
//    println(getMnemonic(BLUE))
//    println(getWarmth(BLUE))
    println(mixOptimized(RED,YELLOW))
    println(mix(RED, BLUE))
}
