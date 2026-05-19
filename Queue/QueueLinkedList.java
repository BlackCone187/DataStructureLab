package com.example.Queue;

public class QueueLinkedList<T> {
    private Node<T> front,rear;

    public QueueLinkedList() {
        front = rear = null;
    }

    public boolean isEmpty() {
        return (front == null);
    }

    public T front(){
        if (isEmpty()) {
            System.out.println("Error: cannot return front from empty queue");
            return null;
        }
        return front.getElement();
    }

    public void enQueue(T element) {
        Node<T> newNode = new Node<>(element);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.setNext(newNode);
            rear = newNode;
        }
    }

    public T deQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        } else {
            T data = front.getElement();
            front = front.getNext();
            return data;
        }
    }
}
