package com.example;

import java.io.Serializable;

public class Singleton implements Serializable, Cloneable {

    private static Singleton singleton;

    private Singleton() {

    }

    protected Object readResolve() {

        System.out.println("Serializing Singleton. Returning singleton instance");
        return singleton;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {

        System.out.println("Cloning Singleton. Returning singleton instance");
        return singleton;
    }

    public static Singleton getInstance() {

        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }

        return singleton;
    }
}
