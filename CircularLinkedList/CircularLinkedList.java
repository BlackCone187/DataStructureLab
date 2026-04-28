package com.example.CircularLinkedList;

public class CircularLinkedList<T> {
    private Node<T> front, back;
    private int size;

    public CircularLinkedList() {
        front = back = null;
        size = 0;
    }

    public void addFirst(T element) {
        Node<T> newNode = new Node<>(element);

        if (size == 0) {
            front = back = newNode;
            back.setNext(front);
        } else {
            newNode.setNext(front);
            front = newNode;
            back.setNext(front);
        }
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
            back.setNext(front);
        } else {
            back.setNext(newNode);
            back = newNode;
            back.setNext(front);
        }
        size++;
    }

    public T getLast() {
        if (size == 0) {
            return null;
        } else {
            return back.getElement();
        }
    }

    public T get(int index) {
        if (size == 0) {
            return null;
        } else if (index == 0) {
            return getFirst();
        } else if (index == size-1) {
            return getLast();
        } else if (index > 0 && index < size-1) {
            Node<T> current = front;
            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }
            return current.getElement();
        } else {
            return null;
        }
    }

    public void add(int index, T element) {
        if (index == 0) {
            addFirst(element);
        } else if (index == size()) {
            addLast(element);
        } else if (index > 0 && index < size) {
            Node<T> newNode = new Node<>(element);
            Node<T> current = front;

            for (int i = 0; i < index-1; i++) {
                current = current.getNext();
            }

            newNode.setNext(current.getNext());
            current.setNext(newNode);
        }
    }

    public int size() {
        return size;
    }

    public boolean removeFirst() {
        if (size() == 0) {
            return false;
        } else if (size() == 1) {
            front = back = null;
        } else {
            front = front.getNext();
            back.setNext(front);
        }
        size--;
        return true;
    }

    public boolean removeLast() {
        if (size == 0) {
            return false;
        }
        else if (size == 1) {
            front = back = null;
        }
        else {
            Node<T> current = front;
            for (int i = 0; i < size-2; i++) {
                current = current.getNext();
            }
            current.setNext(front);
            back = current;
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
        else if (index > 0 && index < size - 1) {
            Node<T> current = front;
            for (int i = 0; i < index-1; i++) {
                current = current.getNext();
            }
            current.setNext(current.getNext().getNext());
            size--;
            return true;
        }
        else {
            return false;
        }
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
