package com.example.client

import android.util.ArrayMap

fun main(vararg args: String) {
    println("${args[1]}");
    if (args.size < 3) {
        println(
            """
            please do not
            print len 3
            number 
        """.trimIndent()
        )
    }


    val opMap: MutableMap<String, (Int, Int) -> Int> = mutableMapOf("+" to ::add)

    opMap.put("-", ::sub)
    opMap.put("*", ::mul)
    opMap.put("/", ::div)

    val operation = funOperation(opMap, args[1])

    println("Input:${args.joinToString("")}")

    println("last result:${operation!!(args[0].toInt(), args[2].toInt())}")
}


fun funOperation(opMap: MutableMap<String, (Int, Int) -> Int>, op: String): ((Int, Int) -> Int)? {
    return opMap[op]
}

fun add(a: Int, b: Int): Int {
    return a + b;
}

fun sub(a: Int, b: Int): Int {
    return a - b;
}

fun mul(a: Int, b: Int): Int {
    return a * b;
}

fun div(a: Int, b: Int): Int {
    return a / b;
}