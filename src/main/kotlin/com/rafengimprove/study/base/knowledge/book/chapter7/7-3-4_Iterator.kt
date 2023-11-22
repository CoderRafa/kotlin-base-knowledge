package com.rafengimprove.study.base.knowledge.book.chapter7

import java.time.LocalDate

// for (x in list) { } calls an operator list.iterator()

operator fun ClosedRange<LocalDate>.iterator(): Iterator<LocalDate> {
    return object: Iterator<LocalDate> {
        var current = start

        override fun hasNext() =
            current <= endInclusive

        override fun next() = current.apply {
            current = plusDays(1)
        }
    }
}

fun main() {
    val newYear= LocalDate.ofYearDay(2017, 1)
    val daysOff = newYear.minusDays(1)..newYear
    for (dayOff in daysOff) { println(dayOff) }
}