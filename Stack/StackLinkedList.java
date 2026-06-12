package com.example.Stack;


public class StackLinkedList<T> {
    private int size;
    private Node<T> front;

    public StackLinkedList() {
        front = null;
        size = 0;
    }

    public void push(T element) {
        Node<T> newNode = new Node<>(element);
        newNode.setNext(front);
        front = newNode;

        size++;
    }

    public T pop() {
        if (!isEmpty()) {
            Node<T> top = front;
            front = front.getNext();
            size--;
            return top.getElement();
        }
        else
            return null;
    }

    public T peek(){
        if (!isEmpty())
            return front.getElement();
        else
            return null;
    }
    public int Size(){
        return size;
    }
    public boolean isEmpty(){
        return (front==null);
    }
}
