package com.example;

public class Stack {

    private Node top;

    public Stack() {

    }

    public boolean isEmpty() {

        return top == null;
    }

    public void push(int data) {

        System.out.println("Pushing element to stack " + data);
        Node node;
        if (this.isEmpty()) {
            node = new Node(data, null);
        } else {
            node = new Node(data, top);
        }
        top = node;
    }

    public Node pop() {

        if (this.isEmpty()) {
            System.out.println("Popping element from stack. Stack is empty");
            return null;
        }

        Node node = top;
        top = top.getNext();
        System.out.println("Popping element from stack " + node.getData());
        return node;
    }

    public Node peek() {

        if (this.isEmpty()) {
            System.out.println("Peeking in stack. Stack is empty");
            return null;
        }

        System.out.println("Peeking in stack. Top element is " + top.getData());
        return top;
    }

    public int search(int data) {

        Node start = top;
        int count = -1;

        int index = -1;
        while (start != null) {

            count++;
            if (start.getData() == data) {
                index = count;
                break;
            }

            start = start.getNext();
        }

        if (index == -1) {
            System.out.println("Element " + data + " not found ");
        } else {
            System.out.println("Found element " + data + " at index " + index);
        }

        return index;
    }
}
