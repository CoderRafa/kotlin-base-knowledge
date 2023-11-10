package com.rafengimprove.study.base.knowledge.book.chapter5

val canBeInClub27 = { p:Person -> p.age >= 27 }
val peopleClub27 = listOf(Person("Alice", 27), Person("Bob", 31))

fun main() {
    println(peopleClub27.all(canBeInClub27))
    // all checks that all the collection elements meet a certain condition
    // it returns Boolean

    // if we need to check if any of the collection elements meet the condition
    // we use any

    println(peopleClub27.any(canBeInClub27))

    // to know how many elements meet the condition we use count
    println(peopleClub27.count(canBeInClub27))

    // we can also check the count of elements meeting the condition by
    peopleClub27.filter(canBeInClub27).size
    // but in this case an additional collection will be created
    // while count only counts the number without creating collections that's why it's more effective


}