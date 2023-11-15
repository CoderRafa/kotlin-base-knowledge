package com.rafengimprove.study.base.knowledge.book.chapter5

val listInList = listOf(listOf(1, 2, 3), listOf(4, 5, 6))
val combinedList = listInList.flatMap { it.map { number: Int -> number * 2 } }
val flattenedList = listInList.flatten()

val strings = listOf("abc", "def")
val stringFlattened = strings.flatMap { it.toList() } // toList breaks up the string into list with characters
class Book(val title: String, val author: List<String>)
val books = listOf(
    Book("Thursday Next", listOf("Jasper Ford")),
    Book("Mort", listOf("Terry Pratchett")),
    Book("Good Omens", listOf("Terry Pratchett", "Neil Gaiman"))
)

val authors = books.flatMap { it.author }.toSet()
fun main() {
    println(combinedList)
    println(flattenedList)
    println(stringFlattened)
    println(authors)
}