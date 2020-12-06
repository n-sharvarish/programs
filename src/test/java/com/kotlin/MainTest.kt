package com.kotlin

import org.testng.annotations.AfterClass
import org.testng.annotations.BeforeClass
import org.testng.annotations.Test

class MainTest {

    @BeforeClass
    fun setUp() {
        println("--------------------------------------------------------------")
        println("Starting Test " + this.javaClass.name)
    }

    @AfterClass
    fun tearDown() {
        println("Completed Test " + this.javaClass.name)
        println("--------------------------------------------------------------")
    }

    @Test
    fun testMain() {

        val main = Main();

        println()
        main.main(arrayOf("Main Test"))
    }
}