package com.rafengimprove.study.base.knowledge.book.chapter4

import com.rafengimprove.study.base.knowledge.book.chapter1.Person
import java.io.File

// Objects create a class and its only instance at the same time.
// Object is the equivalent of a singleton in Java
// Through Object we have access to the private fields

object Payroll {
    val allEmployees = arrayListOf<Person>()

    private var salary: Int = 0
    fun calculateSalary(): Int {
        for (person in allEmployees) {
            ++salary
        }
        return salary
    }
}

object CaseInsensitiveFileComparator : Comparator<File> {
    override fun compare(file1: File, file2: File): Int {
        return file1.path.compareTo(file2.path, ignoreCase = true)
    }
}

data class PersonObject(val name: String) {
    object NameComparator : Comparator<PersonObject> {
        override fun compare(p1: PersonObject, p2: PersonObject): Int {
            return p1.name.compareTo(p2.name)
        }
    }
}

// you can create companion object in a class (equivalent of static fields in Java)
// it can be nameless, and you can access it through the class without creating an instance of a class

class A {
    companion object {
        fun bar() {
            println("Companion object was called")
        }
    }
}

class User4 {
    var nickname: String = ""

    constructor(email: String) {
        nickname = email.substringBefore('@')
    }

    constructor(facebookAccountId: Int) {
        nickname = getFacebookName(facebookAccountId)
    }
}

// Alternatively we can use a companion object for previous class

class User5 private constructor(val nickname: String) {
    companion object { // we can add several functions in a companion object
        fun newSubscribingUser(email: String) =
            User5(email.substringBefore('@'))

        fun newFacebookUser(accountId: Int) =
            User5(getFacebookName(accountId))
    }
}

class PersonJson(val name: String) {
    companion object Loader { // a companion object can have a name.
        // We can use it to access its methods or access methods directly from the class
        fun fromJSON(jsonText: String): PersonJson {
            return PersonJson(jsonText)
        }
    }
}

// We can also implement interfaces in companion objects

interface JSONFactory<T> {
    fun fromJSON(jsonText: String): T
}

class PersonJsonInterface(val name: String) {
    companion object: JSONFactory<PersonJsonInterface> {
        override fun fromJSON(jsonText: String): PersonJsonInterface {
            TODO("Not yet implemented")
        }
    }
}

// Then if you have a loader function
fun <T> loadFromJSON(factory: JSONFactory<T>) {}

// And then we will do loadFromJSON(PersonJsonInterface)

// Companion object extension

class PersonExtension(val firstName: String, val lastName: String) {
    companion object { // we declare an empty companion object

    }
}

// now let's create an extension function

fun PersonExtension.Companion.fromJSON(json: String): PersonExtension {
    return PersonExtension("name", "lastname")
}

// anonymous objects

// window.addMouseListener(
//      object: MouseAdapter() { // here an anonymous object implements MouseAdapter()
//          override fun mouseClicked(e: MouseEvent)
//      }
// )

fun main() {
    Payroll.allEmployees.add(Person("Freddy", 25))
    println(Payroll.calculateSalary())

    println(CaseInsensitiveFileComparator.compare(File("/User"), File("/user")))
    val files = listOf(File("/Z"), File("/a"))
    println(files.sortedWith(CaseInsensitiveFileComparator))

    val persons = listOf(PersonObject("Alice"), PersonObject("Bob"))
    println(persons.sortedWith(PersonObject.NameComparator))

    A.bar()

    val subscribingUser = User5.newSubscribingUser("john@gmail.com")
    val facebookUser = User5.newFacebookUser(15)
    println(subscribingUser.nickname)

    val person = PersonJson.Loader.fromJSON("{name: 'Dmitry'}")
    println(person.name)

    val person1 = PersonJson.fromJSON("{name: 'Brent'}")

    val personExtension = PersonExtension.fromJSON("json")

}


