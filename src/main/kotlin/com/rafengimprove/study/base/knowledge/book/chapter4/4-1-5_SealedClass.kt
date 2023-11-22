package com.rafengimprove.study.base.knowledge.book.chapter4

// A sealed class has a certain (limited set) number of subclasses which are included in a superclass.

interface Expr

class Num(val value: Int): Expr
class Sum(val left: Int, val right: Int): Expr

fun eval(e: Expr): Int =
    when(e) {
        is Num -> e.value
        is Sum -> e.left + e.right
        else -> throw IllegalArgumentException("Unknown expression")
    }

// Now let's do the same with a sealed class

sealed class ExprSealed {
    class Num(val value: Int): ExprSealed()
    class Sum(val left: Int, val right: Int): ExprSealed()
}

fun evalSealed(e: ExprSealed): Int =
    when(e) {
        is ExprSealed.Num -> e.value
        is ExprSealed.Sum -> e.left + e.right
        // Here we don't need to put the 'else' case because the sealed class ensures that no other
        // options are possible.
    }