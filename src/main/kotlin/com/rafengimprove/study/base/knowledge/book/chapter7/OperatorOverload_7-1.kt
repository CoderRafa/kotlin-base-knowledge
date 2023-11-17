package com.rafengimprove.study.base.knowledge.book.chapter7

import kotlin.reflect.typeOf

data class Point(val x: Int, val y: Int) {
    operator fun plus(other: Point): Point {
        return Point(x + other.x, y + other.y)
    }
}

// we can override the 'plus' operator for our class

var p1 = Point(1, 2)
val p2 = Point(2, 3)

// we can also do it by using an extension function

operator fun Point.plus(other: Point): Point {
    return Point(x + other.x, y + other.y)
}

// we can override
// plus:  a + b
// minus: a - b
// times: a * b
// div:   a / b
// mod:   a % b

// also we can do overriding with different operands

operator fun Point.times(scale: Double): Point {
    return Point((x*scale).toInt(), (y*scale).toInt())
}

// also we can return a different type
operator fun Char.times(count: Int): String {
    return toString().repeat(count)
}
// this will create a string with a repeating character count times


fun main() {
    println(p1 + p2)
    println(p1.plus(p2))
    // when we override the 'plus' operator it also supports '+=' assignment operator
    p1 += p2
    println(p1)

    // by using += we can add an element to a MutableList or an Array
    val mutableList = mutableListOf(1, 2)
    mutableList += 3
    println(mutableList)

    // if we use += on a List it will create a new list including the new element
    // and the variable representing this list should be var
    var list = listOf(1, 2)
    list += 3
    println(list)

    // if we use 'plus' on two lists it will result into creating a new list with the elements from both
    val newList = list + listOf(4, 5)
    println(newList)

    // to check the type of a variable we can use ::class
    val x = 7
    print((x::class).simpleName)
}