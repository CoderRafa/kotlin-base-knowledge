package com.rafengimprove.study.base.knowledge.book.chapter2

interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr

fun eval(e: Expr): Int =
    if (e is Num) {
        e.value
    } else if (e is Sum) {
        eval(e.left) + eval(e.right)
    } else {
        throw IllegalArgumentException("Unknown expression")
    }

fun evalW(e: Expr): Int =
    when (e) {
        is Num -> e.value
        is Sum -> evalW(e.left) + evalW(e.right)
        else -> throw IllegalArgumentException("Unknown expression")
    }

fun main() {
    println(eval( Sum (Sum (Sum ( Num(2), Num(4) ), Sum ( Num(3), Num(5) )), Num(5))))
}

