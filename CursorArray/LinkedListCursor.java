package com.example.CursorArray;

import com.example.LinkedList.LinkedList;

public class LinkedListCursor<T> {
    private LinkedList<Node<T>> cursorLinkedList;

    public LinkedListCursor() {
        this.cursorLinkedList = new LinkedList<>();
    }

    public int cursorAlloc() {
        int p = cursorLinkedList.getFirst().getNext();
        cursorLinkedList.getFirst().setNext(cursorLinkedList.get(p).getNext());
        return p;
    }

    public void cursorFree(int p) {
        cursorLinkedList.get(p).setElement(null);
        cursorLinkedList.get(p).setNext(cursorLinkedList.getFirst().getNext());
    }

    public boolean isNull() {
        if (cursorLinkedList.size() < l) {
            return true;
        }
        return cursorLinkedList.getFirst() == null;
    }

    public boolean isEmpty() {
        return cursorLinkedList.getFirst().getNext() == 0;
    }

    public boolean isLast(int p) {
        return cursorLinkedList.get(p).getNext() == 0;
    }

    public void addFirst(T data) {
        if (isNull()) {
            return;
        }
        int p = cursorAlloc();
        if (p != 0) {

        }
    }
}
