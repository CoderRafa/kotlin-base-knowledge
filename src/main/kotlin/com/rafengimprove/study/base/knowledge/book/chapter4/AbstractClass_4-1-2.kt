package com.rafengimprove.study.base.knowledge.book.chapter4

abstract class Animated {
    abstract fun animate() // abstract function should be overridden

    open fun stopAnimating() { // this function is open that's why it can be overridden

    }

    fun animateTwice() { // this function is final by default and can't be overridden

    }
}