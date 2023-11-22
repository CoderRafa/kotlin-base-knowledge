package com.rafengimprove.study.base.knowledge.book.chapter5

val peopleGroupedBy = listOf(
    Person("Alice", 29), Person("Bob", 31), Person("Mike", 31)
)

val groupedByAge = peopleGroupedBy.groupBy { it.age }

val listOfLetters = listOf("a", "ab", "b")
val groupedListOfLetters = listOfLetters.groupBy { it.first() }

fun main() {
    println(groupedByAge.keys)
    println(groupedByAge.values)
    println(groupedByAge.values.map { it.filter { p: Person -> p.name == "Mike" } })
    println(groupedListOfLetters)
}