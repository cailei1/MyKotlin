package com.example.fanxin

interface Source<out T>{
   fun getT():T
}

fun main(){

}


fun test(src:Source<Int>){
   var des:Source<Number> = src
}