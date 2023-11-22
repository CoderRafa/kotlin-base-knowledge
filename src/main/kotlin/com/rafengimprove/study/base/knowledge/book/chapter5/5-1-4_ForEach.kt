package com.rafengimprove.study.base.knowledge.book.chapter5

// we can access the function parameters inside the lambda which is in the body
fun printMessageWithPrefix(messages: Collection<String>, prefix: String) {
    messages.forEach {
        println("$prefix $it")
    }
}

// we can also change the local variables in lambda

fun printProblemCounts(responses: Collection<String>) {
    var clientErrors = 0
    var serverErrors = 0

    responses.forEach {
        if (it.startsWith("4")) {
            clientErrors++
        } else if (it.startsWith("5")) {
            serverErrors++
        }
    }

    println(
        "$clientErrors client ${
            if (clientErrors > 1) {
                print("errors")
            } else {
                print("error")
            }
        }, $serverErrors server errors"
    )
}

// member references
val getAge = { p: Person -> p.age }

// we can do the same with member reference
val getAgeWithReference = Person::age

// also we can get a reference to a function of a higher level
fun salute() = println("Salute!")

// sometimes it's useful to refer(delegate) to another function instead of a lambda expression
val action = { person: Person, message: String -> sendMail(person, message) }

// also we can use this instead
val newAction = ::sendMail
val actionWithReference = { person: Person, message: String -> newAction(person, message) }

// we can also save or postpone a class object initialisation
val createPerson = ::Person
val p = createPerson("Alice", 29)


fun sendMail(person: Person, message: String) {
}

fun main() {
    val errors = listOf("403 Forbidden", "404 Not Found")

    printMessageWithPrefix(errors, "Error: ")

    val responses = listOf("200 OK", "418 I'm a teapot", "500 Internal Server Error")
    printProblemCounts(responses)

    run(::salute)
}