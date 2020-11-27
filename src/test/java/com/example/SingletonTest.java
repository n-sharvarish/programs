package com.example;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.*;
import java.lang.reflect.Constructor;

public class SingletonTest {

    @BeforeClass
    public void setUp() {
        TestUtils.setUpMessage(this.getClass());
    }

    @AfterClass
    public void tearDown() {
        TestUtils.tearDownMessage(this.getClass());
    }

    @Test
    public void testSingleton() {

        Singleton singleton1 = Singleton.getInstance();
        System.out.println("singleton1 hashCode: " + singleton1.hashCode());

        Singleton singleton2 = Singleton.getInstance();
        System.out.println("singleton2 hashCode: " + singleton2.hashCode());

        Assert.assertEquals(singleton1.hashCode(), singleton2.hashCode(), "singleton1 hashCode and singleton2 hashCode should be same");

        System.out.println();
        breakSingletonWithSerialization();

        System.out.println();
        breakSingletonWithCloning();

        System.out.println();
        breakSingletonWithReflection();
    }

    private void breakSingletonWithSerialization() {

        System.out.println("Breaking Singleton With Serialization");

        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = null;

        try {
            ObjectOutput out = new ObjectOutputStream(new FileOutputStream("src/test/resources/singleton.txt"));
            out.writeObject(singleton1);
            out.close();

            ObjectInput in = new ObjectInputStream(new FileInputStream("src/test/resources/singleton.txt"));
            singleton2 = (Singleton) in.readObject();
            in.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("singleton1 hashCode: " + singleton1.hashCode());
        System.out.println("singleton2 hashCode: " + singleton2.hashCode());

        Assert.assertEquals(singleton1.hashCode(), singleton2.hashCode(), "singleton1 hashCode and singleton2 hashCode should be same");
    }

    private void breakSingletonWithCloning() {

        System.out.println("Breaking Singleton With Cloning");

        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = null;

        try {
            singleton2 = (Singleton) singleton1.clone();
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("singleton1 hashCode: " + singleton1.hashCode());
        System.out.println("singleton2 hashCode: " + singleton2.hashCode());

        Assert.assertEquals(singleton1.hashCode(), singleton2.hashCode(), "singleton1 hashCode and singleton2 hashCode should be same");
    }

    private void breakSingletonWithReflection() {

        System.out.println("Breaking Singleton With Reflection");

        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = null;

        try {
            Constructor[] constructors = Singleton.class.getDeclaredConstructors();
            for (Constructor constructor : constructors) {

                constructor.setAccessible(true);
                singleton2 = (Singleton) constructor.newInstance();
                break;
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("singleton1 hashCode: " + singleton1.hashCode());
        System.out.println("singleton2 hashCode: " + singleton2.hashCode());

        Assert.assertNotEquals(singleton1.hashCode(), singleton2.hashCode(), "singleton1 hashCode and singleton2 hashCode should not be same");

        System.out.println();
        System.out.println("Recovering Singleton with SingletonEnum");

        SingletonEnum singletonEnum1 = SingletonEnum.SINGLETON_INSTANCE;
        SingletonEnum singletonEnum2 = SingletonEnum.SINGLETON_INSTANCE;

        System.out.println("singletonEnum1 hashCode: " + singletonEnum1.hashCode());
        System.out.println("singletonEnum2 hashCode: " + singletonEnum2.hashCode());

        Assert.assertEquals(singletonEnum1.hashCode(), singletonEnum2.hashCode(), "singletonEnum1 hashCode and singletonEnum2 hashCode should be same");
    }
}
