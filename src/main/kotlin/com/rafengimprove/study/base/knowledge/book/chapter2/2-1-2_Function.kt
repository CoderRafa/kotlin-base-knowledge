package com.rafengimprove.study.base.knowledge.book.chapter2

//It is possible to import a function from another class and package

// Block body
fun max(a: Int, b: Int): Int {
    return if (a > b) a else b
}

// Expression body
fun maxExpression(a: Int, b: Int): Int = if (a > b) a else b

// Type inference
fun maxTypeInference(a: Int, b: Int) = if (a > b) a else b

fun main() {
    println(createRandomRectangle().height)
}