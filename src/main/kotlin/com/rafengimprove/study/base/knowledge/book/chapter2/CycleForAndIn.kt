package com.rafengimprove.study.base.knowledge.book.chapter2

import java.util.*

fun main() {

fun fizzBuzz(i: Int) =
    when {
        i % 15 == 0 -> "FizzBuzz"
        i % 3 == 0 -> "Fizz"
        i % 5 == 0 -> "Buzz"
        else -> "$i"
    }

// 1..100 - closed range, includes the last number
// 1 until 100 - semi-closed range, doesn't include the last number

//    for (i in 1..100) {
//        println(fizzBuzz(i))
//    }
//
//    for (i in 100 downTo 1 step 2) {
//        println(fizzBuzz(i))
//    }

// Collection iteration

val binaryRep = TreeMap<Char, String>()

    for (c in 'A'..'F') {
        val binary = Integer.toBinaryString(c.code)
        binaryRep[c] = binary
        // this is the equivalent to binaryRep.put(c, binary)
    }

//    for ((letter, binary) in binaryRep) {
//        println("$letter = $binary")
//    }

    // iteration with index
//    val list = arrayListOf("10", "11", "1001")
//    for ((index,element) in list.withIndex()) {
//        println("$index: $element")
//    }

    // in operator is also used to check if the element is in some range

    fun isLetter(c: Char) = c in 'a'..'z' || c in 'A'..'Z'
    fun isNotDigit(c: Char) = c !in '0'..'9'

//    println(isLetter('a'))
//    println(isNotDigit('c'))

    fun recognize(c: Char) = when(c) {
        in '0'..'9' -> "It's a digit"
        in 'a'..'z', in 'A'..'Z' -> "It's a letter"
        else -> "I don't know"
    }

    println(recognize('D'))

    // in operator is also used to check if the element is in the collection
    println("Kotlin" in "Java".."Scala")
    // Interface Comparable is used. It compares by the alphabet so "Kotlin" is in this range. true
    // Now let's use in operator in a collection
    println("Kotlin" in setOf("Java", "Scala"))
    // This collection doesn't contain "Kotlin", so this will be false.

}
