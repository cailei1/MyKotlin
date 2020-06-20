package com.example.client

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun main() {
    //协程构建器 不阻塞当前线程 在后台创建一个新的协程
   GlobalScope.launch {
       //协程
       delay(1000)
       print("我是路飞")

   }

    println("Hello ")
    Thread.sleep(2000)

    println(" \nworld")


}

