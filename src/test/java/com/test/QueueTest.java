package com.test;

import com.example.Queue;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class QueueTest {

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

    @Test
    public void testQueue() {

        Queue queue = new Queue();

        System.out.println();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println();
        queue.search(2);
        queue.peek();
        queue.dequeue();

        System.out.println();
        queue.search(1);
        queue.peek();
        queue.dequeue();

        System.out.println();
        System.out.println("Queue Empty " + queue.isEmpty());
        queue.search(3);
        queue.peek();
        queue.dequeue();

        System.out.println();
        System.out.println("Queue Empty " + queue.isEmpty());
        queue.search(3);
        queue.peek();
        queue.dequeue();

        System.out.println();
        queue.enqueue(4);
        queue.enqueue(5);

        System.out.println();
        queue.search(4);
        queue.peek();
        queue.dequeue();

        System.out.println();
        System.out.println("Queue Empty " + queue.isEmpty());
        queue.search(5);
        queue.peek();
        queue.dequeue();

        System.out.println();
        System.out.println("Queue Empty " + queue.isEmpty());
        queue.search(5);
        queue.peek();
        queue.dequeue();
    }
}
