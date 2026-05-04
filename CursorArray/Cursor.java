package com.example.CursorArray;

public class Cursor<T> {
    private Node<T>[] cursorArray;
    private static final int MAX_SIZE = 10;  // fixed array size = 10


    public Cursor() {
        cursorArray = (Node<T>[]) new Node[MAX_SIZE];
    }

    public void initialization() {
        for (int i = 0; i < 10; i++) {
            cursorArray[i] = new Node<>(null, i+1);
        }
        cursorArray[MAX_SIZE-1].setNext(0);
    }

    public int cursorAlloc() {
        int p = cursorArray[0].getNext();
        cursorArray[0].setNext(cursorArray[p].getNext());

        return p;
    }

    public void cursorFree(int p) {
        cursorArray[p].setElement(null); // optional
        cursorArray[p].setNext(cursorArray[0].getNext());
        cursorArray[0].setNext(p);
    }

    public boolean isNull(int l) {
        // return true if the list not created
        return cursorArray[l] == null;
    }

    public boolean isEmpty(int l) {
        //return true if the list is empty
        return cursorArray[l].getNext() == 0;
    }

    public boolean isLast(int p) {
        //check if the node p is last or not
        return cursorArray[p].getNext() == 0;
    }

    public void addFirst(T data, int l) {
        if (isNull(l)) {
            return;
        }
        int p = cursorAlloc();
        if (p != 0) {
            cursorArray[p] = new Node<>(data, cursorArray[l].getNext());
            cursorArray[l].setNext(p);
        } else {
            System.out.println("Out Of Space");
        }
    }

    public void addLast(T data, int l) {
        if (isNull(l)) {
            return;
        }
        if (isEmpty(l)) {
            addFirst(data, l);
        }
        // find last
        int temp = cursorArray[l].getNext();
        while (cursorArray[temp].getNext() != 0) {
            temp = cursorArray[temp].getNext();
        }

        int p = cursorAlloc();
        if (p != 0) {
            cursorArray[p].setElement(data);
            cursorArray[p].setNext(0);
            cursorArray[temp].setNext(p);
        }
    }

    public void add(T data, int index, int l) {
        if (isNull(l)) {
            return;
        }
        int temp = cursorArray[l].getNext();
        for (int i = 0; i < index; i++) {
            temp = cursorArray[temp].getNext();
        }

        int p = cursorAlloc();
        if (p != 0) {
            cursorArray[p].setElement(data);
            cursorArray[p].setNext(cursorArray[temp].getNext());
            cursorArray[temp].setNext(p);
        }

    }

    public T getFirst(int l) {
        int p = cursorArray[l].getNext();

        if (p == 0) {
            return null;
        }
        return cursorArray[p].getElement();
    }

    public T getLast(int l) {
        int p = cursorArray[l].getNext();

        if (p == 0) {
            return null;
        }
        while (cursorArray[p].getNext() != 0) {
            p = cursorArray[p].getNext();
        }

        return cursorArray[p].getElement();
    }

    public void traverse(int l) {
        int p = cursorArray[l].getNext();
        while (p != 0) {
            System.out.println(cursorArray[p].getElement());
            p = cursorArray[p].getNext();
        }
    }

    public int find(T data, int l) {
        int p = cursorArray[l].getNext();

        while ((p != 0) && !(cursorArray[p].getElement().equals(data))) {
            p = cursorArray[p].getNext();
        }
        return p;
    }

    public boolean removeFirst(int l) {
        if (isNull(l)) {
            return false;
        }
        int temp = cursorArray[l].getNext();
        cursorArray[l].setNext(cursorArray[temp].getNext());
        cursorFree(temp);
        return true;
    }

    public boolean removeLast(int l) {
        if (isNull(l) || isEmpty(l)) {
            return false;
        }

        int p = l;
        while (cursorArray[cursorArray[p].getNext()].getNext() != 0) {
            p = cursorArray[p].getNext();
        }
        int temp = cursorArray[p].getNext();
        cursorArray[p].setNext(0);
        cursorFree(temp);
        return true;
    }

    public boolean removeIndex(int index, int l) {
        if (isNull(l) || isEmpty(l)) {
            return false;
        }
        int prev = l;

        for (int i = 0; i < index; i++) {
            prev = cursorArray[prev].getNext();

            if (prev == 0 || isLast(prev)) {
                return false; // out of bound
            }
        }
        int temp = cursorArray[prev].getNext();

        cursorArray[prev].setNext(cursorArray[temp].getNext());
        cursorFree(temp);

        return true;
    }

    public void removeData(Object data,int l) {
        int pos = findPrevious(data,l);
        if(!isLast(pos)){//!isLast (pos)
            int temp = cursorArray[pos].getNext();
            cursorArray[pos].setNext(cursorArray[temp].getNext());
            cursorFree(temp);
        }
    }

    private int findPrevious(Object element, int l) {
        int pos = l;
        while (cursorArray[pos].getNext() != 0 && !cursorArray[cursorArray[pos].getNext()].getElement().equals(element)) {
            pos = cursorArray[pos].getNext();
        }
        return pos;
    }
}
