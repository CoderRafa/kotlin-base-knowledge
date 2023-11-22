package com.rafengimprove.study.base.knowledge.book.chapter7

import java.time.LocalDate


// rangeTo is an extension function for Comparable
// in other way we can put rangeTo as '..'

// let's create a range of dates and check if a specific date is in that range

val now = LocalDate.now()
val vacation = now..now.plusDays(10)
// this is the same as now.rangeTo(now.plusDays(10))

fun main() {
    println(now.plusWeeks(2) in vacation)
}
