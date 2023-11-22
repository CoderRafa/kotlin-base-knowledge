package com.rafengimprove.study.base.knowledge.book.chapter3

val String.lastChar: Char
//    get() = this[length - 1]
    get() = get(length - 1)

var StringBuilder.changeLastChar: Char
    get() = get(length - 1)
    set(value: Char) {
        this[length - 1] = value
    }

var string: String = ""
    get() {
        return "$field + "
    }

class Line() {
    lateinit var line: String
}

fun Line.showPlus(): String {
    return "${this.line} + "
}

var line = Line()


fun main() {
//    val kotlin = "Kotlin"
//    println(kotlin.lastChar)
//
//    var string = StringBuilder("kotlin")
//    string.changeLastChar = 'm'
//    println(string)

    string = "Hello"
    println(string)

    line.line = "Hello"
    println(line.showPlus())
}