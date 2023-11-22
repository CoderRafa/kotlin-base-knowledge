package com.rafengimprove.study.base.knowledge.book.chapter3

var opCount = 0

fun performOperation() {
    opCount++
}

fun reportOperationCount() {
    println("Operation performed $opCount times")
}

fun main() {
    for(count in 1..15) {
        performOperation()
    }

    reportOperationCount()
}