package com.example.client

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.concurrent.thread

fun main()= runBlocking {
    val myJob=GlobalScope.launch {
        delay(1000)
        println("kotlin coroutines")
    }

    println("Hello")

    myJob.join()

    println("World")
}