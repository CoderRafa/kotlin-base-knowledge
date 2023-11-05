package com.rafengimprove.study.base.knowledge.book.chapter3

fun String.lastChar(): Char = this[this.length - 1]

// this can be taken out

fun String.lastCharWithoutThis(): Char = get(length - 1)

// in another package in order to use an extension function it should be imported
// import chapter3.lastChar()
// import chapter3.*
// also you can rename the imported extension function by
// import chapter3.lastChar() as last

fun <T> Collection<T>.joinToString(
    separator: String = ",",
    prefix: String = "",
    postfix: String = ""
): String {
    val result = StringBuilder(prefix)

    for ((index, element) in this.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }

    result.append(postfix)
    return result.toString()
}

// this extension function can be used for a certain type

fun Collection<String>.join(
    separator: String = ",",
    prefix: String = "",
    postfix: String = ""
) = joinToString(separator, prefix, postfix)

//Overriding inherited function
open class View() {
    open fun click() = println("View clicked")
}

class Button(): View() {
    override fun click() = println("Button clicked")
}

fun main() {
    val list = listOf(1, 2, 3)
//    println(list.joinToString(" "))

    val line = listOf("I", "want", "to", "go")
//    println(line.join(" "))

    val view: View = Button()
    println(view.click())
    // The result here is "Button clicked" because although the view is of type View but it is an object of Button()

// But extension can't be overridden. Each type should have an extension function
    fun View.ShowOff() = println("I am a view")
    fun Button.ShowOff() = println("I am a button")
}


