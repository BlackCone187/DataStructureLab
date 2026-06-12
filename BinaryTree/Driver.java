package com.example.BinaryTree;

public class Driver {

    public static void main(String[] args) {

        BST<Integer> bst = new BST<>();
        bst.insert(-4);
        bst.insert(5);
        bst.insert(7);
        bst.insert(13);
        bst.insert(25);
        bst.insert(-2);

//        bst.printLevel();

        AVL<Integer> avl = new AVL<>();
        avl.insert(4);
        avl.insert(1);
        avl.insert(3);
        avl.insert(7);
        avl.insert(20);

        avl.printIn();
    }
}
