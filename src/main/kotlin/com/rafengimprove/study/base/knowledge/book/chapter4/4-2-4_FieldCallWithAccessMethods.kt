package com.rafengimprove.study.base.knowledge.book.chapter4

class User2(val name: String) {
    var address: String = "Unspecified"
        set(value: String) {
            println("""
                Address was changed for $name
                $field -> $value
            """.trimIndent())
            field = value
        }
}

fun main() {
    val user = User2("Rafael")
    user.address = "Ovech 8 st. , ap. 28"
    user.address = "Miami"
}