package com.example.client

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    //协程构建器 不阻塞当前线程 在后台创建一个新的协程
   GlobalScope.launch {
       //协程
       delay(1000)
       print("我是路飞")

   }

    println("Hello ")

    //创建新的协程并且阻塞主线程
    runBlocking {
        delay(2000)
    }

    println(" \nworld")


}

