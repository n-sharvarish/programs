package com.test;

import com.example.Stack;
import org.testng.annotations.Test;

public class StackTest {

    @Test
    public void testStack() {

        Stack stack = new Stack();

        System.out.println();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println();
        stack.search(2);
        stack.peek();
        stack.pop();

        System.out.println();
        stack.search(3);
        stack.peek();
        stack.pop();

        System.out.println();
        System.out.println("Stack Empty " + stack.isEmpty());
        stack.search(1);
        stack.peek();
        stack.pop();

        System.out.println();
        System.out.println("Stack Empty " + stack.isEmpty());
        stack.search(1);
        stack.peek();
        stack.pop();

        System.out.println();
        stack.push(4);
        stack.push(5);

        System.out.println();
        stack.search(5);
        stack.peek();
        stack.pop();

        System.out.println();
        System.out.println("Stack Empty " + stack.isEmpty());
        stack.search(4);
        stack.peek();
        stack.pop();

        System.out.println();
        System.out.println("Stack Empty " + stack.isEmpty());
        stack.search(4);
        stack.peek();
        stack.pop();
    }
}
