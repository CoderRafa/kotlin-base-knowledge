package com.rafengimprove.study.base.knowledge.book.chapter4

interface User {
    val nickname: String
}

class PrivateUser(override val nickname: String): User // we can override the abstract property in the constructor

class SubscribingUser(private val email: String): User {
    override val nickname: String
        get() = email.substringBefore('@') // we can override the abstract property with customizing the get method
}

class FacebookUser(private val accountId: Int): User {
    override val nickname = getFacebookName(accountId) // we can just initialize the abstract property
}

fun getFacebookName(id: Int): String = id.toString()

// Apart from containing abstract properties an interface can also contain their access methods
// as long as the property doesn't access the memory and doesn't have a state
interface User3 {
    val email: String
    val nickname: String
        get() = email.substringBefore('@')
}