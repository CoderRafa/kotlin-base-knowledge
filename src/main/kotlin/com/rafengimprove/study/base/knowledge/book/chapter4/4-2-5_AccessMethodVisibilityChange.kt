package com.rafengimprove.study.base.knowledge.book.chapter4

class LengthCounter() {

    var counter: Int = 0
        private set  // because we made the set private we can't change 'counter' outside the class

    fun addWord(word: String) {
        counter += word.length
    }
}

fun main() {
    val count = LengthCounter()
    count.addWord("Hello")
    println(count.counter)
    count.addWord("World")
    println(count.counter)

}