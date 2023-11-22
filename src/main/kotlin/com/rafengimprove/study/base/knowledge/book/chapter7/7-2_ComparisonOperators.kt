package com.rafengimprove.study.base.knowledge.book.chapter7

// equals operator

class PointEquals(val x: Int, val y: Int) {
    override fun equals(other: Any?): Boolean {
        if (other === this) return true
        if (other !is Point) return false
        return other.x == x && other.y == y
    }
}

// we have overridden the equals operator
// notice that we didn't use 'operator' because it's already implemented in the Any class

// compareTo
class PersonName(val firstname: String, val lastname: String): Comparable<PersonName> {
    override fun compareTo(other: PersonName): Int {
        return compareValuesBy(this, other, PersonName::lastname, PersonName::firstname)
    }
}
// compareValuesBy takes this and other and first compares them by the lastname
// if they are equal it will compare firstname
// as with equals we don't use 'operator' because it has already been used in Comparable

fun main() {
    val p1 = PersonName("Alice", "Smith")
    val p2 = PersonName("Bob", "Johnson")
    println(p1 < p2)


}