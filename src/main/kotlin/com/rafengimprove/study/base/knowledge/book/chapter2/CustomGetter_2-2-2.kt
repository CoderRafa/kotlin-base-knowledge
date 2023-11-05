package com.rafengimprove.study.base.knowledge.book.chapter2

class Rectangle(val height: Int, val width: Int) {
    val isSquare: Boolean
    get() {
        return height == width
    }
}

class SimpleGetterSetter(val lastname: String) {
    var name = "Rafayel"
        get() {
            return "$field $lastname"
        }
        set(value) {
            field = "It's not me $value"
            println("You are not allowed to change my name. Shame on you!")
        }
}

fun Rectangle.isSqrt() = height == width
fun main() {
    val rec = Rectangle(5,5)
//    println(rec.isSquare)
//    println(rec.isSqrt())
    val name = SimpleGetterSetter("Khachatryan")
    println(name.name)
    name.name = "John"
    println(name.name)
}

