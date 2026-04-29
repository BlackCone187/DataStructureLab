package com.example.CursorArray;

public class Node<T> {
    private T element;
    private int next;

    public Node(T element) {
        this(element, 0);
    }

    public Node(T element, int next) {
        this.element = element;
        this.next = next;
    }

    public T getElement() {
        return element;
    }

    public int getNext() {
        return next;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public void setNext(int next) {
        this.next = next;
    }
}
