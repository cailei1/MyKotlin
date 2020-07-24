package com.example.client

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.concurrent.thread

/**
 * 每一个协程构造器都会向其代码域中添加一个CoroutineScope 实例
 */
fun main() = runBlocking {
   repeat(10000){
       thread {
           Thread.sleep(1000)
           println("A")
       }
   }
    println("Hello World")
}