package com.rafengimprove.study.base.knowledge.table

data class Item(
    val name: String,
    val description: String,
    val length: Double,
    val width: Double
) {
    val area by lazy { length * width }
}