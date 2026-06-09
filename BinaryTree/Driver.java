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

        bst.printLevel();
        System.out.println();
        bst.printPre();
        System.out.println();
        bst.printPost();
        System.out.println();
        bst.printIn();
    }
}
