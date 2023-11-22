package com.rafengimprove.study.base.knowledge.book.chapter2

import java.io.BufferedReader
import java.io.StringReader

fun main() {
    fun percentage(percentage: Int) =
    if(percentage in 0..100) {
        println(percentage)
    }else{
        throw IllegalArgumentException("The percentage must be between 0 and 100")
    }

//    percentage(0)

    fun readNumber(reader: BufferedReader): Int? {
        return try {
            val line = reader.readLine()
            Integer.parseInt(line)
        } catch (e: NumberFormatException) {
            null
        } finally {
            reader.close()
        }
    }

    val reader = BufferedReader(StringReader("Hello"))
//    println(readNumber(reader))

    // try can be an expression

    fun readNumberExpression(reader: BufferedReader){
        val number = try {
            Integer.parseInt(reader.readLine())
        } catch (e: NumberFormatException) {
            return // because the catch block doesn't return anything the program will stop if an exception is caught
            // To avoid this the catch block should return something for example null
            // The result is the last expression in each block
        }
    }

}
