package com.example;

public class Queue {

    private Node front;
    private Node rear;

    public Queue() {

    }

    public boolean isEmpty() {

        return front == null && rear == null;
    }

    public void enqueue(int data) {

        System.out.println("Adding element to queue " + data);
        Node node = new Node(data, null);
        if (this.isEmpty()) {
            front = node;
        } else {
            rear.setNext(node);
        }
        rear = node;
    }

    public Node dequeue() {

        if (front == null) {
            System.out.println("Removing element from queue. Queue is empty");
            return null;
        }

        Node oldFront = front;
        System.out.println("Removing " + oldFront.getData() + " from queue");
        front = front.getNext();

        if (front == null) {
            rear = null;
            System.out.println("Queue is empty now");
        } else {
            System.out.println("Front " + front.getData() + " Rear " + rear.getData());
        }

        return oldFront;
    }

    public Node peek() {

        if (this.isEmpty()) {
            System.out.println("Peeking into the queue. Queue is empty");
            return null;
        }

        System.out.println("Front " + front.getData() + " Rear " + rear.getData());
        return front;
    }

    public int search(int data) {

        Node start = front;
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