package com.example.CircularDoublyLinkedList;

import com.example.CircularLinkedList.CircularLinkedList;
import com.example.DoublyLinkedList.Node;

public class CircularDoublyLinkedList<T> {
    private Node<T> front, back;
    private int size;

    public CircularDoublyLinkedList() {
        front = null;
        back = null;
        size = 0;
    }

    public void addFirst(T element) {
        Node<T> newNode = new Node<>(element);
        if (size() == 0) {
            front = back = newNode;
        } else {
            newNode.setNext(front);
            front.setPrev(newNode);
            front = newNode;
        }

        back.setNext(front);
        front.setPrev(back);
        size++;
    }

    public T getFirst() {
        if (size == 0) {
            return null;
        } else {
            return front.getElement();
        }
    }

    public void addLast(T element) {
        Node<T> newNode = new Node<>(element);

        if (size == 0) {
            front = back = newNode;
        } else {
            newNode.setPrev(back);
            back.setNext(newNode);
            back = newNode;
        }
        back.setNext(front);
        front.setPrev(back);
        size++;
    }

    public void add(T element, int index) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            addFirst(element);
        } else if (index == size()) {
            addLast(element);
        } else {
            Node<T> newNode = new Node<>(element);
            Node<T> current = front;
            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }
            newNode.setNext(current);
            newNode.setPrev(current.getPrev());
            current.getPrev().setNext(newNode);
            current.setPrev(newNode);
            size++;
        }
    }

    public boolean removeFirst() {
        if (size() == 0) {
            return false;
        }
        else if (size() == 1) {
            front = back = null;
        }
        else {
            front = front.getNext();
            front.getPrev().setNext(back);
            front.setPrev(back);
        }
        size--;
        return true;
    }

    public boolean removeLast() {
        if (size() == 0) {
            return false;
        }
        else if (size() == 1) {
            front = back = null;
        }
        else {
            back = back.getPrev();
            back.getNext().setPrev(front);
            back.setNext(front);
        }
        size--;
        return true;
    }

    public boolean remove(int index) {
        if (size() == 0) {
            return false;
        }
        else if (index == 0) {
            return removeFirst();
        }
        else if (index == size()-1) {
            return removeLast();
        }
        else if (index > 0 && index < size()-1) {
            Node<T> current = front;
            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }
            current.getPrev().setNext(current.getNext());
            current.getNext().setPrev(current.getPrev());

            current.setNext(null);
            current.setPrev(null);
            current = null;
            size--;
            return true;
        }
        else {
            return false;
        }
    }

    public T getLast() {
        if (size() == 0) {
            return null;
        }
        else {
            return back.getElement();
        }
    }

    public T get(int index) {
        if (size() == 0) {
            return null;
        }
        else if (index == 0) {
            return getFirst();
        }
        else if (index == size()-1) {
            return getLast();
        }
        else if (index > 0 && index < size()-1) {
            Node<T> current = front;
            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }
            return current.getElement();
        }
        else {
            return null;
        }
    }

    public int size() {
        return size;
    }

    public void traverse(Node<T> current) {
        if (current == null) {
            return;
        }

        System.out.println(current.getElement());

        if (current.getNext() != front) {
            traverse(current.getNext());
        }
    }
}
