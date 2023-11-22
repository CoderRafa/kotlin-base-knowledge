package com.rafengimprove.study.base.knowledge.book.chapter7

operator fun Point.get(index: Int): Int {
    return when(index) {
        0 -> x
        1 -> y
        else -> throw IndexOutOfBoundsException("Invalid coordinate at $index")
    }
}

data class MutablePoint(var x: Int, var y: Int)

operator fun MutablePoint.set(index: Int, value: Int) {
    return when(index) {
        0 -> x = value
        1 -> y = value
        else -> throw IndexOutOfBoundsException("Invalid coordinate at $index")
    }
}

fun main() {
    val p = Point(10, 20)
    println(p[0])
    val mutablePoint = MutablePoint(10, 20)
    mutablePoint[0] = 30
}