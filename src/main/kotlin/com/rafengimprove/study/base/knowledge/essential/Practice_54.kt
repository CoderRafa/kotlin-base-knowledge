package com.rafengimprove.study.base.knowledge.essential

fun Any?.print() {
    print(this)
}
fun main() {
    fun printNumberSign(num: Int) {
        if (num < 0) {
            "Negative"
        } else if (num > 0) {
            "Positive"
        } else {
            "Zero"
        }.print()
    }
}

