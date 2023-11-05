package com.rafengimprove.study.base.knowledge.book.chapter1

data class Person(val name: String, val age: Int? = null) {
}

//fun findAlice() = findPerson { it.name == "Alice" }

fun main() {
    val persons = listOf(Person("Alice"), Person("Bob", 29))
    val oldest = persons.maxBy { it.age ?: 0 }

    println("The oldest is: ${oldest.name} who is ${oldest.age}")
}