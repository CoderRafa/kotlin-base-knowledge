package com.rafengimprove.study.base.knowledge.book.chapter6

fun strLen(s: String) = s.length
// in this function we can't pass a null property it will cause an error
// to have an option to pass nul properties we have to ue '?' at the end of the type

fun strLenWithNullOption(s: String?) = s?.length
// now that we gave an option to pass a null property calling length on it is not safe
// because in case of null length will cause an error
// that's why we should use safe call operator '?' before calling length on a property
// in that case if it's not null a length function will be used
// if it's null it will return null and won't go further to length function

// this is the same if we do a nullability check
fun strLenWithNullCheck(s: String?): Int = if (s != null) s.length else 0

class Employee(val name: String, val manager: Employee?)
fun managerName(employee: Employee): String? = employee.manager?.name

val ceo = Employee("Da Boss", null)
val developer = Employee("Bob Smith", ceo )

// we can also combine several safe call operators
class Address(val streetAddress: String, val zipcode: Int, val city: String, val country: String)

class Company(val name: String, val address: Address?)

class Person(val name: String, val company: Company?)

fun Person.countryName(): String {
    val country = this.company?.address?.country
    return country ?: "Unknown"
}

fun main() {
    println(managerName(developer))
    println(managerName(ceo))
}