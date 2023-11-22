package com.rafengimprove.study.base.knowledge.book.chapter5

// we use with instead of the name of an object to make some actins

fun alphabet(): String {
    val result = StringBuilder()
    for (letter in 'A'..'Z') {
        result.append(letter)
    }
    result.append("\nNow I know the alphabet")
    return result.toString()
}

// let's do the same with 'with'

fun alphabetWith(): String {
    val stringBuilder = StringBuilder()
    return with(stringBuilder) {
        for (letter in 'A'..'Z') {
            this.append(letter)
        }
        this.append("\nNow I know the alphabet")
        this.toString()
    }
}

// we can omit creating a variable of StringBuilder type and do it directly
// also we can drop 'this'

fun alphabetWithDirect() = with(StringBuilder()) {
    for (letter in 'A'..'Z') {
        append(letter)
    }
    append("\nNow I know the alphabet")
    toString()
}

// 'apply' is similar to with. It returns the object on which it was called

fun alphabetApply() = StringBuilder().apply {
    for (letter in 'A'..'Z') {
        append(letter)
    }
    append("\nNow I know the alphabet")
    toString()
}
fun main() {
    println(alphabet())
    println(alphabetWith())
    println(alphabetWithDirect())
    println(alphabetApply())
}