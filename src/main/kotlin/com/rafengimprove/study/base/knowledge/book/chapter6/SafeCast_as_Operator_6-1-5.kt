package com.rafengimprove.study.base.knowledge.book.chapter6

// to check if we cast a property into a certain type we can use 'as'
// but if the property is impossible to cast to the type we will get an exception
// to avoid this we can use the safe cast operator 'as?'
// in this case if it is possible to cast the property into a type it will do it
// if not it will return null
// adding the Elvis operator to this we can return a value in case of null
class PersonForSafeCast(val firstname: String, val lastname: String) {
    override fun equals(other: Any?): Boolean {
        val otherPerson = other as? PersonForSafeCast ?: return false

        return otherPerson.firstname == firstname && otherPerson.lastname == lastname
    }

    override fun hashCode(): Int {
        return firstname.hashCode()*37 + lastname.hashCode()
    }
}