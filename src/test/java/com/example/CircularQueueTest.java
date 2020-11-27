package com.example;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CircularQueueTest {

    @BeforeClass
    public void setUp() {
        TestUtils.setUpMessage(this.getClass());
    }

    @AfterClass
    public void tearDown() {
        TestUtils.tearDownMessage(this.getClass());
    }

    @Test
    public void testQueue() {

        CircularQueue queue = new CircularQueue();

        System.out.println();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println();
        Assert.assertTrue(!queue.isEmpty(), "queue should not be empty");
        Assert.assertTrue(queue.search(1) > -1, "1 should be present in queue");
        Assert.assertTrue(queue.search(2) > -1, "2 should be present in queue");
        Assert.assertTrue(queue.search(3) > -1, "3 should be present in queue");

        System.out.println();
        Assert.assertEquals(queue.peek().getData(), 1, "1 should be the front");
        Assert.assertEquals(queue.dequeue().getData(), 1, "1 should be dequeued");

        System.out.println();
        Assert.assertTrue(!queue.isEmpty(), "queue should not be empty");
        Assert.assertTrue(queue.search(1) == -1, "1 should not be present in queue");

        System.out.println();
        Assert.assertEquals(queue.peek().getData(), 2, "2 should be the front");
        Assert.assertEquals(queue.dequeue().getData(), 2, "2 should be dequeued");

        System.out.println();
        Assert.assertTrue(!queue.isEmpty(), "queue should not be empty");
        Assert.assertTrue(queue.search(2) == -1, "2 should not be present in queue");

        System.out.println();
        Assert.assertEquals(queue.peek().getData(), 3, "3 should be the front");
        Assert.assertEquals(queue.dequeue().getData(), 3, "3 should be dequeued");

        System.out.println();
        Assert.assertTrue(queue.isEmpty(), "queue should be empty");
        Assert.assertTrue(queue.search(3) == -1, "3 should not be present in queue");

        System.out.println();
        Assert.assertEquals(queue.peek(), null, "null should be front");
        Assert.assertEquals(queue.dequeue(), null, "null should be dequeued");

        System.out.println();
        queue.enqueue(4);
        queue.enqueue(5);

        System.out.println();
        Assert.assertTrue(!queue.isEmpty(), "queue should not be empty");
        Assert.assertTrue(queue.search(4) > -1, "4 should be present in queue");
        Assert.assertTrue(queue.search(5) > -1, "5 should be present in queue");

        System.out.println();
        Assert.assertEquals(queue.peek().getData(), 4, "4 should be the front");
        Assert.assertEquals(queue.dequeue().getData(), 4, "4 should be dequeued");

        System.out.println();
        Assert.assertTrue(!queue.isEmpty(), "queue should not be empty");
        Assert.assertTrue(queue.search(4) == -1, "4 should not be present in queue");

        System.out.println();
        Assert.assertEquals(queue.peek().getData(), 5, "5 should be the front");
        Assert.assertEquals(queue.dequeue().getData(), 5, "5 should be dequeued");

        System.out.println();
        Assert.assertTrue(queue.isEmpty(), "queue should be empty");
        Assert.assertTrue(queue.search(5) == -1, "5 should not be present in queue");

        System.out.println();
        Assert.assertEquals(queue.peek(), null, "null should be front");
        Assert.assertEquals(queue.dequeue(), null, "null should be dequeued");
    }
}
