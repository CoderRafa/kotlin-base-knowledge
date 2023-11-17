package com.rafengimprove.study.base.knowledge.book.chapter6

// we can check if a nullable property is null through standard extension functions

fun verifyUserInput(input: String?) {
    if (input.isNullOrEmpty()) {  // here we don't need to use 'input?' because the extension function does the check
        println("Please fill in the field")
    }
    if (input.isNullOrBlank()) {
        println("Please fill the filed with letters")
    }
}