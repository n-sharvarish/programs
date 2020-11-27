package com.example;

public class TestUtils {

    public static void setUpMessage(Class clazz) {

        System.out.println("--------------------------------------------------------------");
        System.out.println("Starting Test " + clazz.getName());
    }

    public static void tearDownMessage(Class clazz) {

        System.out.println("Completed Test " + clazz.getName());
        System.out.println("--------------------------------------------------------------");
    }
}
