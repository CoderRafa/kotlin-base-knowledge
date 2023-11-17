package com.rafengimprove.study.base.knowledge.book.chapter7

// unary operators are
// +a: unaryPlus
// -a: unaryMinus
// !a: not
// ++a, a++: inc
// --a, a--: dec

// we can override these operators
operator fun Point.unaryMinus(): Point {
    return Point(-x, -y)
}

fun main() {
    val p = Point(10, 20)
    println(-p)
}