package com.rafengimprove.study.base.knowledge.book.chapter7


class PersonWithMapAttributes {
    private val _attributes = hashMapOf<String, String>()

    fun setAttribute(attrName: String, value: String) {
        _attributes[attrName] = value
    }

    val name: String
        get() = _attributes["name"]!!
}

// we can use delegate to use its getValue SetValue

class PersonWithMapAttributesByDelegate {
    private val _attributes = hashMapOf<String, String>()

    fun setAttribute(attrName: String, value: String) {
        _attributes[attrName] = value
    }

    val name: String by _attributes // the name of the key that will be in data
    val company: String by _attributes
}
fun main() {
    val p = PersonWithMapAttributes()
    val data = mapOf("name" to "Dmitry", "company" to "JetBrains")

    for ((attrName, value) in data) p.setAttribute(attrName, value)
    println(p.name)

    val pByDelegate = PersonWithMapAttributesByDelegate()
    for ((attrName, value) in data) pByDelegate.setAttribute(attrName, value)
    println(pByDelegate.company)

}



