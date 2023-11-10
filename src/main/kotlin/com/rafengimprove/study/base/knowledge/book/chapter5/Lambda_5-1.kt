package com.rafengimprove.study.base.knowledge.book.chapter5

data class Person(val name: String, val age: Int)

fun findTheOldest(people: List<Person>) {
    var maxAge = 0
    var theOldest: Person? = null

    for (person in people) {
        if (person.age > maxAge) {
            maxAge = person.age
            theOldest = person
        }
    }
    println(theOldest)
}

// this can be done in a better way using lambda expression

fun lambda(people: List<Person>) {
    println(people.maxBy { it.age })
}

// also it can be written by using a member reference

fun memberReference(people: List<Person>) {
    println(people.maxBy(Person::age))
}

// lambda writing form { x: Int, y: Int -> x + y }
// we assign a lambda expression to a variable

val sum = { x: Int, y: Int -> x + y }

// if we write the full code without contractions
fun fullForm(people: List<Person>) {
    people.maxBy({ p: Person -> p.age })
    // we can take lam
    // bda out of parentheses
    people.maxBy() { p: Person -> p.age }
    // when lambda is the only argument in a function we can emit the parentheses
    people.maxBy { p: Person -> p.age }
    // we can also use a default parameter name 'it'
    people.maxBy { it.age }
    // when lambda is kept in a variable then the compiler doesn't have an information to get the type,
    // so we have to mention the type
    val getAge = { p: Person -> p.age }
    people.maxBy(getAge)
}

// lambda expression as a named argument
val people = listOf(Person("Alice", 29), Person("Bob", 32))
val names = people.joinToString(separator = " ", transform = { p: Person -> p.name } )
// we can take lambda out of parentheses
val namesOut = people.joinToString(separator = " ") { p: Person -> p.name }
// we can simplify this by emitting the type
val namesOutNoType = people.joinToString(separator = " ") { p -> p.name }

// when there are several lines in lambda the result of it will be the last line
val sumLastLine = { x: Int, y: Int ->
    println("We calculate $x + $y")
    x + y
}
fun main() {
    val people = listOf(Person("Mike", 5), Person("Dany", 15))

    findTheOldest(people)
    lambda(people)
    memberReference(people)

    println(sum(1, 2));

    // we can call lambda directly as well
    { println(42) }()

    println(names)

    println(sumLastLine(2,3))
}

