package com.example.client

import java.io.File
import java.util.*

fun main(args: Array<String>) {
    val ints = intArrayOf(1, 2, 3)
    ints.forEach {
        println("Hello $it")
    }

    val runnable = Runnable { println("thread is start") }
    val thread = Thread(object : Runnable {
        override fun run() {

        }
    })

    thread.start()

    File("build.gradle").readText().toCharArray().filter {!it.isWhitespace()}.groupBy {it}.map {
        it.key to it.value.size
    }.let {
        print(it)
    }

}