package com.example.client

import kotlin.concurrent.thread

fun main() {
//    val thread=Thread{
//
//    }
//    thread.start()


    thread(isDaemon = true){
        Thread.sleep(1000)
        print("我是海贼王")
    }

    print("Hello")
    Thread.sleep(200)
    print("\nWorld")
}