package com.example.BinaryTree;

public class BSTNode<T> {
    T element;               // store data
    BSTNode<T> left;  // left child
    BSTNode<T> right; // right child
    public BSTNode(T element) {
        this(element, null, null);
    }
    public BSTNode(T element, BSTNode<T> left, BSTNode<T> right) {
        this.element = element;
        this.left = left;
        this.right = right;
    }
}
