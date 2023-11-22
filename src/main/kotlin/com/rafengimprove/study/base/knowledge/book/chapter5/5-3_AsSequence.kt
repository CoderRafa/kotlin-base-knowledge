package com.rafengimprove.study.base.knowledge.book.chapter5

import java.io.File

val peopleToBeSequenced = peopleGroupedBy
val namesWithA = peopleToBeSequenced
    .map { it.name }
    .filter { it.startsWith('A') }
// in this case we create collections on each step. First with map, and then with filter.
// If the initial collection is big then creating two collections in order to find people with A will be heavy
// in these cases we can use Sequences. It will postpone (lazy implementation)
// the implementation of the map and filter in this case
// and won't create any collections in the middle

val peopleAsSequence = peopleToBeSequenced.asSequence()
    .map { it.name }
    .filter { it.startsWith('A') }
    .toList() // we have to finalize the action and make the sequence back to list

// In as sequence when the predicate is found the function stops iterating over other elements
// While when it's a list it should go over all elements and then give a result that meets the predicate
// With sequence in this case will quicker, more effective and easier for computing power

// For example: we have to first square the elements in a list and then find the first that is more than 3
val numbersList = listOf(1, 2, 3, 4)
    .map { it * it }
    .find { it > 3 }

// In this case we have to create a new list with squares, then go over it and find the one that meets our predicate
// while in sequence we will do the operation of squaring and checking if the element meets the predicate
// with each element in sequence. So when we reach 2 and square it, it will already meet our predicate being more
// than 3 and the operation will stop without doing anything with the elements 3 and 4.

val numbersListSequenced = listOf(1, 2, 3, 4).asSequence()
    .map { it * it }
    .find { it > 3 }

// we can also generate sequences
val numbersToGenerate = generateSequence(0) { it + 1 }
val numbersUntil100 = numbersToGenerate.takeWhile { it <= 100 }

val file = File("demo.txt")

// we can generate a sequence of parent directories and check if a file is in a certain directory
fun File.isInsideHiddenDirectory() =
    generateSequence(this) { it.parentFile }.any { it.name == "svtk" }
val fileIsInHiddenDir = File("User/svtk/.HiddenDir/a.txt")

fun main() {
    println(fileIsInHiddenDir.isInsideHiddenDirectory())
}


