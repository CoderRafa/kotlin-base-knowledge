package com.rafengimprove.study.base.knowledge.book.chapter3

fun main() {

    val set = hashSetOf(1, 7, 53)
//    println(set.javaClass)
//    println(set)

    fun <T> joinToString(
        collection: Collection<T>,
        separator: String,
        prefix: String,
        postfix: String
    ): String {
        val result = StringBuilder(prefix)

        for ((index, element) in collection.withIndex()) {
            if (index > 0) result.append(separator)
            result.append(element)
        }
        result.append(postfix)
        return result.toString()
    }

    val list = listOf(1, 3, 5)
    println(joinToString(list, ";", "(", ")"))
    // named arguments
    println(joinToString(list, separator = ";", prefix = "(", postfix = ")"))
    // If you use named arguments you should name all the arguments to avoid confusion

    // default parameters
    fun <T> joinToStringWithDefaultParameters(
        collection: Collection<T>,
        separator: String = ",",
        prefix: String = "",
        postfix: String = ""
    ): String {
        val result = StringBuilder(prefix)

        for ((index, element) in collection.withIndex()) {
            if (index > 0) result.append(separator)
            result.append(element)
        }

        result.append(postfix)
        return result.toString()
    }
    //When call this function and don't give parameters the default values will be used.
}