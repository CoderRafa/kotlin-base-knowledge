package com.rafengimprove.study.base.knowledge.book.chapter4

class Client(val name: String, val postCode: Int)

// if we try to print an object of Class it will show only the address in memory and not the object fields
// we need to override the toString method in order to see the fields

class Client1(val name: String, val postcode: Int) {
    override fun toString(): String {
        return "name = $name, postcode = $postcode"
    }
}

// in order to compare if two objects of Client are equal we also need to override the equal method
// because if we don't do this two objects with the same fields won't be equal because they will have
// different memory addresses

class Client2(val name: String, val postcode: Int) {
    override fun equals(other: Any?): Boolean {
        if (other == null || other !is Client2)
            return false
        return other.name == name && other.postcode == postcode
    }

    override fun toString(): String {
        return "name = $name, postcode = $postcode"
    }
}

class Client3(val name: String, val postcode: Int) {
    override fun equals(other: Any?): Boolean {
        if (other == null || other !is Client3)
            return false
        return other.name == name && other.postcode == postcode
    }

    override fun hashCode(): Int {
        return name.hashCode()*31 + postcode
    }

    override fun toString(): String {
        return "name = $name, postcode = $postcode"
    }
}

fun main() {
    println(Client("Raf", 9003))
    println(Client1("Raf", 9003))

    val client1 = Client("Raf", 9003)
    val client2 = Client("Raf", 9003)
    println(client1 == client2)
}