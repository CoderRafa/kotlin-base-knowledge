package com.rafengimprove.study.base.knowledge.book.chapter6

// when a function doesn't get a null parameter, but it is possible that null can be passed
// we can use 'let' with lambda expression which will be done only if the parameter is not null
fun sendEmail(email: String) {}

// in order to send and email we need to make sure that it's not null

val email: String? = "null"

fun main() {
    if (email != null) sendEmail(email)
    // with 'let' it wil be
    email?.let { email -> sendEmail(email) }
    // because the email is the only argument we can substitute with 'it'
    email?.let { sendEmail(it) }
}



