package com.kotlin

import org.testng.annotations.AfterClass
import org.testng.annotations.BeforeClass
import org.testng.annotations.Test

class AppTest {

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

        val app = App

        println()
        app.main(arrayOf("App Test"))
    }
}