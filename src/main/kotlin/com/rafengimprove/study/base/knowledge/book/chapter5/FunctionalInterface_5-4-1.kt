package com.rafengimprove.study.base.knowledge.book.chapter5

// Functional interface it's an interface with one abstract method (so-called SAM - Single Abstract Method) which
// can be transformed into a lambda expression

fun interface IntPredicate {
    fun accept(i: Int): Boolean
}

val isEven = IntPredicate { it % 2 == 0 }

// Functional interface with a single abstract method
fun interface MathOperation {
    fun operate(a: Int, b: Int): Int
}

    // Implementing functional interface using lambda expression
    val addition  = MathOperation { a, b -> a + b }

    // Using the implemented functional interface
    val result = addition.operate(5, 3)

fun interface ToUpper {
    fun toUpper(s: String): String
}

val stringToUpper = ToUpper { it.first().uppercase() + it.substringAfter(it.first()) }
val rafayelToUpper = stringToUpper.toUpper("rafayel")

fun main() {
    println("Is 7 even? - ${isEven.accept(7)}")
    println("Result of addition: $result")
    println(rafayelToUpper)
}

