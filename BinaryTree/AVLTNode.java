package com.example.BinaryTree;

public class AVLTNode<T> {
    int element; //store data
    AVLTNode<T> left; // left child
    AVLTNode<T> right; //right child
    int height; //Height

    public AVLTNode(int element){
        this(element, null, null);
    }
    public AVLTNode(int element, AVLTNode<T> left, AVLTNode<T> right)
    {
        this.element=element;
        this.left=left;
        this.right=right;
        this.height=0;
    }
}
