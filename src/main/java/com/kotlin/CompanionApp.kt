package com.kotlin

class CompanionApp {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            args.iterator().forEach { s: String -> println(s) }
        }
    }
}