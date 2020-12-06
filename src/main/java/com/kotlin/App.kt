package com.kotlin

object App {

    //@JvmStatic
    fun main(args: Array<String>) {
        args.iterator().forEach { s: String -> println(s) }
    }
}