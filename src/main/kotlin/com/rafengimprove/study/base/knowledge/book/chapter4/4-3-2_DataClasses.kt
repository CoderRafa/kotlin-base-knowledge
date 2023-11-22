package com.rafengimprove.study.base.knowledge.book.chapter4

// In data classes toString, equals and hashCode functions are already overridden by default

data class Client4(val name: String, val postcode: Int)

// in data classes there is an opportunity to copy a class and make some changes in a new one

// if there wasn't a default copy function in order to achieve this we should have done this in a class

class Client5(val name: String, val postcode: Int) {
    fun copy(name: String = this.name, postcode: Int = this.postcode) {
        Client5(name, postcode)
    }
}

// but with data class it's easier

val clientJohn = Client4("John", 1230)
val clientHenry = clientJohn.copy(postcode = 123456)

fun main() {
    println(Client4("Georgi", 123) == Client4("Georgi", 123))
}