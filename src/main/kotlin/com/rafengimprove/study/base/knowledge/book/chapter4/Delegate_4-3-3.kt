package com.rafengimprove.study.base.knowledge.book.chapter4

import kotlin.properties.Delegates

class Example {
    val expensiveData by lazy {
        println("Initializing expensiveData") // This message will only be printed once
        calculateExpensiveData()
    }

    private fun calculateExpensiveData(): Int {
        println("Calculating expensive data...")
        // Simulate a time-consuming calculation
        Thread.sleep(2000)
        return 42
    }
}

interface Downloader {
    fun download()
}

interface Player {
    fun play()
}

class MediaFile(private val downloader: Downloader, private val player: Player):
    Downloader by downloader, Player by player
//{
//    override fun download() {
//        downloader.download()
//    }
//
//    override fun play() {
//        player.play()
//    }
//}

class FileDownloader(private val file: String): Downloader {
    override fun download() {
        println("$file has been downloaded")
    }
}

class FilePlayer(val file: String): Player {
    override fun play() {
        println("$file is playing")
    }
}

var name by Delegates.observable("Initial Value") { _, oldName, newName ->
    println("Name changed from $oldName to $newName")
}

class CountingSet<T>(
    val innerSet: MutableCollection<T> = HashSet<T>()
): MutableCollection<T> by innerSet {

    var objectsAdded = 0

    override fun add(element: T): Boolean {
        objectsAdded++
        return innerSet.add(element)
    }

    override fun addAll(c: Collection<T>): Boolean {
        objectsAdded += c.size
        return innerSet.addAll(c)
    }
}
fun main() {
//    val example = Example()
//
//    // At this point, "expensiveData" is not yet initialized
//    println("Before accessing expensiveData")
//
//    // When we access "expensiveData" for the first time, it will be initialized
//    val result = example.expensiveData
//    println("After accessing expensiveData: $result")
//
//    // Subsequent access to "expensiveData" will not trigger its initialization
//    val cachedResult = example.expensiveData
//    println("After accessing expensiveData again: $cachedResult")

    val file: String = "File1.mkv"

    val mediaFile = MediaFile(FileDownloader(file), FilePlayer(file))
    mediaFile.download()
    mediaFile.play()

    name = "Rafayel"

    val cset = CountingSet<Int>()
    cset.addAll(listOf(1,1,2))
    println("${cset.objectsAdded} objects were added, from those are ${cset.size} left")
}

