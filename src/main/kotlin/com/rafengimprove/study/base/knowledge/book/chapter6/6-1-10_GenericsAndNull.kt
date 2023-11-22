package com.rafengimprove.study.base.knowledge.book.chapter6

// when we use generic types by default they are Any?, so they can also be null
fun <T> printHashCode(t: T) {
    println(t?.hashCode())    // we need to use a safe call operator because T can be null
}

// to avoid null for a generic type we should
fun <T: Any> printNonNullHashCode(t: T) {// we eliminated the possibility of null values,
                                         // and we don't need the safe call operator
    println(t.hashCode())
}