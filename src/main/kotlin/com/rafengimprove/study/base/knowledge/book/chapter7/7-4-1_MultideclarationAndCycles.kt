package com.rafengimprove.study.base.knowledge.book.chapter7

// we can use multi declaration in cycles
fun printEntries(map: Map<String, String>) {
    for ((key, value ) in map) {
        println("$key -> $value")
    }
}

fun main() {
    val map = mapOf("Oracle" to "Java", "JetBrains" to "Kotlin")
    printEntries(map)
}