package com.example.Queue;

public class QueueArray<T> {
    private int front;
    private int rear;
    private int maxSize;
    private T[] queueArray;

    @SuppressWarnings("unchecked")
    public QueueArray(int maxSize) {
        front = rear = -1;
        this.maxSize = maxSize;
        queueArray = (T[]) new Object[maxSize];
    }

    public void enQueue(T element) {
        if (isFull())
            System.out.println("Queue is full");
        else if (isEmpty()) {
            front++;
            rear++;
            queueArray[rear] = element;
        }
        else {
            rear = (rear + 1) % maxSize;
            queueArray[rear] = element;
        }
    }

    public T deQueue() {
        T element = null;
        if (isEmpty())
            System.out.println("Queue is empty");
        else if (front == rear) {
            element = queueArray[front];
            front = rear = -1;
        }
        else {
            element = queueArray[front];
            front = (front + 1) % maxSize;
        }
        return element;
    }

    public boolean isEmpty() {
        return (front==-1 && rear==-1);
    }

    private boolean isFull() {
        return ((rear+1)% maxSize == front);
    }

    // returns front
    public T front(){
        if (isEmpty()) {
            System.out.println("Error: cannot return front from empty queue");
            return null;
        }
        return queueArray[front];
    }


}
