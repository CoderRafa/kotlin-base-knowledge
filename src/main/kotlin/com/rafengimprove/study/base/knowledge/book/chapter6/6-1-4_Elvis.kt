package com.rafengimprove.study.base.knowledge.book.chapter6

// with the Elvis operator we can give a value to a property if it's null
fun foo(s: String?) {
    val t: String = s ?: "s is null but t is String. Type mismatch"
}

// the Elvis operator is often used with the safe call operator
fun strLenWithElvis(s: String?) = s?.length ?: "It's null and can't have length"

// the countryName function from the Null file we can write much shorter
fun Person.countryNameElvis() = company?.address?.country ?: "Unknown"

// we can also throw an exception if the property is null in Elvis
fun printShippingLabel(person: Person) {
    val address = person?.company?.address
        ?: throw IllegalArgumentException("No address")
    with(address) {
        println(streetAddress)
        println("$zipcode $city, $country")
    }
}