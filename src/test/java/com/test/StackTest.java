package com.test;

import com.example.Stack;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class StackTest {

    @BeforeClass
    public void setUp() {
        TestUtils.setUpMessage(this.getClass());
    }

    @AfterClass
    public void tearDown() {
        TestUtils.tearDownMessage(this.getClass());
    }

    @Test
    public void testStack() {

        Stack stack = new Stack();

        System.out.println();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println();
        Assert.assertTrue(!stack.isEmpty(), "stack should not be empty");
        Assert.assertTrue(stack.search(1) > -1, "1 should be present on stack");
        Assert.assertTrue(stack.search(2) > -1, "2 should be present on stack");
        Assert.assertTrue(stack.search(3) > -1, "3 should be present on stack");

        System.out.println();
        Assert.assertEquals(stack.peek().getData(), 3, "3 should be top");
        Assert.assertEquals(stack.pop().getData(), 3, "3 should be popped");

        System.out.println();
        Assert.assertTrue(!stack.isEmpty(), "stack should not be empty");
        Assert.assertTrue(stack.search(3) == -1, "3 should not be present on stack");

        System.out.println();
        Assert.assertEquals(stack.peek().getData(), 2, "2 should be top");
        Assert.assertEquals(stack.pop().getData(), 2, "2 should be popped");

        System.out.println();
        Assert.assertTrue(!stack.isEmpty(), "stack should not be empty");
        Assert.assertTrue(stack.search(2) == -1, "2 should not be present on stack");

        System.out.println();
        Assert.assertEquals(stack.peek().getData(), 1, "1 should be top");
        Assert.assertEquals(stack.pop().getData(), 1, "1 should be popped");

        System.out.println();
        Assert.assertTrue(stack.isEmpty(), "stack should be empty");
        Assert.assertTrue(stack.search(1) == -1, "1 should not be present on stack");

        System.out.println();
        Assert.assertEquals(stack.peek(), null, "null should be top as stack is empty");
        Assert.assertEquals(stack.pop(), null, "null should be popped as stack is empty");

        System.out.println();
        stack.push(4);
        stack.push(5);

        System.out.println();
        Assert.assertTrue(!stack.isEmpty(), "stack should not be empty");
        Assert.assertTrue(stack.search(4) > -1, "4 should be present on stack");
        Assert.assertTrue(stack.search(5) > -1, "5 should be present on stack");

        System.out.println();
        Assert.assertEquals(stack.peek().getData(), 5, "5 should be top");
        Assert.assertEquals(stack.pop().getData(), 5, "5 should be popped");

        System.out.println();
        Assert.assertTrue(!stack.isEmpty(), "stack should not be empty");
        Assert.assertTrue(stack.search(5) == -1, "5 should not be present on stack");

        System.out.println();
        Assert.assertEquals(stack.peek().getData(), 4, "4 should be top");
        Assert.assertEquals(stack.pop().getData(), 4, "4 should be popped");

        System.out.println();
        Assert.assertTrue(stack.isEmpty(), "stack should be empty");
        Assert.assertTrue(stack.search(4) == -1, "4 should not be present on stack");

        System.out.println();
        Assert.assertEquals(stack.peek(), null, "null should be top as stack is empty");
        Assert.assertEquals(stack.pop(), null, "null should be popped as stack is empty");
    }
}
