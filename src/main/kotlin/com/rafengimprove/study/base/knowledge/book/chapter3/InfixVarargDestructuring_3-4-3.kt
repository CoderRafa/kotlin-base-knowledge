package com.rafengimprove.study.base.knowledge.book.chapter3

val map = mapOf(1 to "one", 2 to "two", 3 to "three")

// to here is an infix function

// extension function form 1.to("one")

fun Any.to(other: String) = Pair(this, other)

// infix function form 1 to "one"
infix fun Any.to(other: Any) = Pair(this, other)

// Destructuring
fun main() {
    val (number, name) = 1 to "one"
    println(number)
}
