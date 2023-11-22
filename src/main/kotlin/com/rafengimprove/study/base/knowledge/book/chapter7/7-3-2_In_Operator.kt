package com.rafengimprove.study.base.knowledge.book.chapter7

data class Rectangle(val lowerLeft: Point, val upperRight: Point)

operator fun Rectangle.contains(p: Point): Boolean {
    return p.x in lowerLeft.x until upperRight.x &&
            p.y in lowerLeft.y until upperRight.y
}

fun main() {
    val rect = Rectangle(Point(10, 20), Point(50, 50))
    println(Point(20, 30) in rect)
    println(Point(5, 5) in rect)
}
