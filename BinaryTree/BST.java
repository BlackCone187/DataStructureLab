package com.example.BinaryTree;

public class BST<T extends Comparable<T>> {
    private BSTNode<T> root;

    public BST() {
        root = null;
    }

    public boolean contains(T e, BSTNode<T> current) {
        if (current == null)
            return false; // empty

        else if (e.compareTo(current.element) < 0) // if e smaller than root
            return contains(e, current.left);

        else if (e.compareTo(current.element) > 0) // if e larger than root
            return contains(e, current.right);

        return true;
    }

    public boolean contains(T e) {
        return contains(e, root);
    }

    public BSTNode<T> find(T element, BSTNode<T> current) {
        if (current == null)
            return null; // empty

        if (element.compareTo(current.element) < 0)
            return find(element, current.left);

        else if (element.compareTo(current.element) > 0)
            return find(element, current.right);

        else
            return current;
    }

    public BSTNode<T> find(T e) {
        return find(e, root);
    }


    public BSTNode<T> insert(T element, BSTNode<T> current) {
        if (current == null)
            current = new BSTNode<>(element); // create one node tree

        else {
            if (element.compareTo(current.element) < 0)
                current.left = insert(element, current.left);

            else
                current.right = insert(element, current.right);
        }

        return current;
    }

    public void insert(T e) {
        insert(e, root);
    }

    private BSTNode<T> findMin(BSTNode<T> current) {
        if (current == null)
            return null;
        else if (current.left == null)
            return current;
        else
            return findMin(current.left); // keep going to the left
    }

    public BSTNode<T> findMin() {
        return findMin(root);
    }

    private BSTNode<T> findMax(BSTNode<T> current) {
        if (current == null)
            return null;
        else if (current.right == null)
            return current;
        else
            return findMax(current.right); // keep going to the right
    }

    public BSTNode<T> findMax() {
        return findMax(root);
    }

    private BSTNode<T> remove(T e, BSTNode<T> current) {
        if (current == null)
            return null; // Item not found, Empty tree
        if (e.compareTo(current.element) < 0)
            current.left = remove(e, current.left);
        else if (e.compareTo(current.element) > 0)
            current.right = remove(e, current.right);
        else // found element to be deleted
            if (current.left != null && current.right != null) { // two children
                /* Replace with smallest in right subtree */
                current.element = findMin(current.right).element;
                current.right = remove(current.element, current.right);
            } else // one or zero child
                current = (current.left != null) ? current.left : current.right;
        return current;
    }

    public BSTNode<T> remove(T e) {
        return remove(e, root);
    }

    private void printPre(BSTNode<T> current) {
        if (current != null) {
            System.out.println(current.element);
            printPre(current.left);
            printPre(current.right);
        }
    }

    public void printPre() {
        printPre(root);
    }

    private void printIn(BSTNode<T> current) {
        if (current != null) {
            printIn(current.left);
            System.out.println(current.element);
            printIn(current.right);
        }
    }

    public void printIn() {
        printIn(root);
    }

    private void printPost(BSTNode<T> current) {
        if (current != null) {
            printPost(current.left);
            printPost(current.right);
            System.out.println(current.element);
        }
    }

    public void printPost() {
        printPost(root);
    }



//    public void printLevel(BSTNode<T> current) {
//
//        if (current != null) {
//
//        }
//    }
}
