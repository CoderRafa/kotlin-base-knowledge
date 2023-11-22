package com.rafengimprove.study.base.knowledge.book.chapter7

// in data classes it's possible to do destructuring when we assign class parameters to multiple variables
val p = Point(10, 20)

// we can also create this functionality for non data classes by using 'component'

class PointNonData(val x: Int, val y: Int) {
    operator fun component1() = x
    operator fun component2() = y
}

val pNonData = PointNonData(30, 40)

data class NameComponents(val name: String, val extension: String)
fun splitFileName(fullName: String): NameComponents {
    val result = fullName.split('.', limit = 2)
    return NameComponents(result[0], result[1])
}
// because the function 'component' is present in arrays and collections we can simply put

fun splitFileNameSimply(fullName: String): NameComponents {
    val(name, extension) = fullName.split('.', limit = 2)
    return NameComponents(name, extension)
}
fun main() {
    val (x, y) = p
    println(x)
    println(y)

    val (a, b) = pNonData
    println(a)
    println(b)

    val (name, ext) = splitFileName("example.kt")
    println(name)
    println(ext)
}
