package com.rafengimprove.study.base.knowledge.book.chapter3

const val regExLine = "123,5-4,8"

fun parsePath(path: String) {
    val directory = path.substringBeforeLast("/")
    val fullName = path.substringAfterLast("/")

    val fileName = fullName.substringBeforeLast(".")
    val extension = fullName.substringAfterLast(".")

    println("Dir: $directory, name: $fileName, ext: $extension")
}

const val path = "/User/yole/kotlin-book/chapter.adoc"

fun parsePathWithRegEx(path: String) {
    val regex = """(.+)/(.+)\.(.+)"""
    val matchResult = path.matches(regex.toRegex())
    if(matchResult != null) {
//        val(directory, filename, extension) = matchResult.
    }
}

fun main() {
//    println(regExLine.split(",","-"))

    parsePath(path)


}

