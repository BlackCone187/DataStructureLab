package com.example.Stack;

public class StackArray<T> {
    private int maxSize;
    private T[] stackArray;
    private int top;

    @SuppressWarnings("unchecked")
    public StackArray(int maxSize) {
        this.maxSize = maxSize;
        stackArray = (T[]) new Object[maxSize];
        top = -1; //Empty stack
    }

    public void push(T element) {
        stackArray[++top] = element;
    }

    public T pop() {
        if (!isEmpty()) {
            return stackArray[top--];
        }
        return null;
    }

    public T peek() {
        if (!isEmpty()) {
            return stackArray[top];
        }
        return null;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxSize-1;
    }

    public int size() {
            return top+1;
    }
}
