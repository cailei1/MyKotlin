package com.example.client
//泛型

class MyGeneric<T>(t: T) {
    var myT: T = t

}

fun main() {
    val myGeneric=MyGeneric("string")
    println(myGeneric.myT)
}

//协变 与 逆变
