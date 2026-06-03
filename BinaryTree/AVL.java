package com.example.BinaryTree;

public class AVL<T extends Comparable<T>> extends BST<T> {
    private AVLTNode<T> root;

    public AVL() {
        root = null;
    }

    private int height(AVLTNode<T> e){
        if( e == null )
            return -1;
        return e.height;
    }

    // Rotate binary tree node with left child(single rotate to right)
    private AVLTNode<T> rotateWithLeftChild(AVLTNode<T> k2){
        AVLTNode<T> k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.height = Math.max(height(k2.left),height( k2.right ))+ 1;
        k1.height = Math.max(height(k1.left),k2.height )+ 1;
        return k1;
    }

    // Rotate binary tree node with right child (single rotate to left)
    private AVLTNode<T> rotateWithRightChild(AVLTNode<T> k1) {
        AVLTNode<T> k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        k1.height = Math.max(height(k1.left), height(k1.right)) + 1;
        k2.height = Math.max(height(k2.right), k1.height) + 1;
        return k2;
    }

    /* Double rotate binary tree node: first left child with its
       right child; then node k3 with new left child */
    private AVLTNode<T> DoubleWithLeftChild(AVLTNode<T> k3){
        k3.left = rotateWithRightChild( k3.left );
        return rotateWithLeftChild( k3 );
    }

    /* Double rotate binary tree node: first right child with its
       left child; then node k1 with new right child */
    private AVLTNode<T> DoubleWithRightChild(AVLTNode<T> k1){
        k1.right = rotateWithLeftChild( k1.right );
        return rotateWithRightChild( k1 );
    }
}
