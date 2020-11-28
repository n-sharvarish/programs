package com.example;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    protected BaseTest() {

    }

    @BeforeClass
    public void setUp() {

        System.out.println("--------------------------------------------------------------");
        System.out.println("Starting Test " + this.getClass().getName());
    }

    @AfterClass
    public void tearDown() {

        System.out.println("Completed Test " + this.getClass().getName());
        System.out.println("--------------------------------------------------------------");
    }
}
