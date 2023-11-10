package com.rafengimprove.study.base.knowledge.book.chapter5

// there are library functions to work with collections
// one of this functions is filter
// it filters a collection according to a predicate or condition

val list = listOf(1, 2, 3, 4)

val peopleToBeFiltered = listOf(Person("Alice", 29), Person("Bob", 31))

// filter only eliminates some elements from the collection according to a condition,
// but it doesn't change them
// to do this we need to use map


fun main() {
    println(list.filter { it % 2 == 0 })
    println(peopleToBeFiltered.filter { it.age > 30 })

    // map

    println(list.map { it * 2 })
    println(peopleToBeFiltered.map { it.name })

    // we also can chain this functions
    println(peopleToBeFiltered.filter { it.age > 30 }.map(Person::name))

    // we can get the oldest person in the collection with maxBy
    println(peopleToBeFiltered.filter { it.age == peopleToBeFiltered.maxBy(Person::age).age } )

    // this code does the process of searching of max age for every member of the collection
    // if we have for example 100 people it will do 100 times which is not very good
    // a better solution is better because it counts the max age once
    val maxAge = peopleToBeFiltered.maxBy(Person::age).age
    println(peopleToBeFiltered.filter { it.age == maxAge } )

    // we can also use filter and map for Maps
    val numbers = mapOf(0 to "zero", 1 to "one")
    println(numbers.mapValues { it.value.uppercase() } )
}
