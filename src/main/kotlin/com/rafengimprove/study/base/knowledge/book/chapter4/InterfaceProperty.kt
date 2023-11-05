package com.rafengimprove.study.base.knowledge.book.chapter4

interface User {
    val nickname: String
}

class PrivateUser(override val nickname: String): User

class SubscribingUser(private val email: String): User {
    override val nickname: String
        get() = email.substringBefore('@')
}

class FacebookUser(private val accountId: Int): User {
    override val nickname = getFacebookName(accountId)
}

fun getFacebookName(id: Int): String = id.toString()