package com.example.ClassicalLinkedList;

public class LinkedList<T> {
    private Node<T> front;

    public LinkedList () {
        front = null;
    }

    public LinkedList (Node<T> front) {
        this.front = front;
    }

    public void addFirst(T element) {
        Node<T> newNode = new Node<>(element);

        if (front != null) {
            newNode.setNext(front);
        }
        front = newNode;
    }

    public T getFirst() {
        if (front == null) {
            return null;
        }
        else {
            return front.getElement();
        }
    }

    public void addLast(T element) {
        Node<T> newNode = new Node<>(element);

        if (front == null) {
            front = newNode;
        }
        else {
            Node<T> current = front;
            while (current.getNext() != null) {
                current.setNext(current.getNext());
            }
            current.setNext(newNode);
        }
    }

    public T getLast() {
        if (front == null) {
            return null;
        }
        else {
            Node<T> current = front;
            while(current.getElement() == null) {
                current.setNext(current.getNext());
            }
            return current.getElement();
        }
    }

    public boolean removeFirst() {
        if (front == null) {
            return false;
        }
        else {
            front = front.getNext();
            return true;
        }
    }

    public boolean removeLast() {
        if (front == null) {
            return false;
        }
        else {
            Node<T> current = front;
            while (current.getNext() != null) {
                current=current.getNext();
            }
            current = null;
            return true;
        }
    }

    public void add(int index, T element) {
        if (front == null) {
            addFirst(element);
        }
        else {
            Node<T> newNode = new Node<>(element);
            Node<T> current = front;
            for (int i = 0; i < index-1; i++) {
                current = current.getNext();
            }
            newNode.setNext(current.getNext());
            current.setNext(newNode);
        }

    }
}
