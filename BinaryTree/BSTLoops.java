package com.example.BinaryTree;

import com.example.Stack.StackLinkedList;

public class BSTLoops<T extends Comparable<T>> {
    private BSTNode<T> root;

    public BSTLoops() {
        root = null;
    }

    private boolean contains(T e, BSTNode<T> current) {
        while (current != null) {
            if (e.compareTo(current.element) < 0) {
                current = current.left;
            } else if (e.compareTo(current.element) > 0) {
                current = current.right;
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean contains(T e) {
        return contains(e, root);
    }

    private BSTNode<T> find(T element, BSTNode<T> current) {
        while (current != null) {
            if (element.compareTo(current.element) < 0) {
                current = current.left;
            } else if (element.compareTo(current.element) > 0) {
                current = current.right;
            } else {
                return current;
            }
        }
        return null;
    }

    public BSTNode<T> find(T e) {
        return find(e, root);
    }

    private BSTNode<T> insert(T element, BSTNode<T> current) {
        if (current == null)
            return new BSTNode<>(element);

        BSTNode<T> temp = current;

        while (true) {
            if (element.compareTo(temp.element) < 0) {
                if (temp.left == null) {
                    temp.left = new BSTNode<>(element);
                    break;
                }
                temp = temp.left;
            } else {
                if (temp.right == null)
                { temp.right = new BSTNode<>(element);
                    break;
                }
                temp = temp.right;
            }
        }

        return current;
    }

    public void insert(T e) {
        root = insert(e, root);
    }

    private BSTNode<T> findMin(BSTNode<T> current) {
        if (current == null)
            return null;

        while (current.left != null)
            current = current.left;

        return current;
    }

    private BSTNode<T> findMax(BSTNode<T> current) {
        if (current == null)
            return null;

        while (current.right != null)
            current = current.right;

        return current;
    }

    private BSTNode<T> remove(T e, BSTNode<T> current) {
        if (current == null)
            return null;

        BSTNode<T> parent = null;
        BSTNode<T> temp = current;

        while (temp != null && e.compareTo(temp.element) != 0) { // find element to remove
            parent = temp;
            if (e.compareTo(temp.element) < 0)
                temp = temp.left;
            else
                temp = temp.right;
        }

        if (temp == null) // not found
            return null;

        if (temp.left != null && temp.right != null) { // node with two children
            BSTNode<T> minParent = temp;
            BSTNode<T> min = temp.right;

            while (min.left != null) {
                minParent = min;
                min = min.left;
            }

            temp.element = min.element;

            if (minParent.left == min)
                minParent.left = min.right;
            else
                minParent.right = min.right;

            return current;
        }

        BSTNode<T> child; // one or zero child
        if (temp.left != null)
            child = temp.left;
        else
            child = temp.right;

        if (parent == null)
            return child; // remove root

        if (parent.left == temp)
            parent.left = child;
        else
            parent.right = child;

        return current;
    }

    public BSTNode<T> remove(T e) {
        BSTNode<T> removed = find(e, root);
        root = remove(e, root);
        return removed;
    }

    private void printPre(BSTNode<T> current) {
        if (current == null) return;

        StackLinkedList<BSTNode<T>> stack = new StackLinkedList<>();
        stack.push(current);

        while (!stack.isEmpty()) {
            BSTNode<T> node = stack.pop();
            System.out.print(node.element + " ");

            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
    }

    public void printPre() {
        printPre(root);
    }

    private void printIn(BSTNode<T> current) {
        StackLinkedList<BSTNode<T>> stack = new StackLinkedList<>();
        BSTNode<T> temp = current;

        while (temp != null || !stack.isEmpty()) {
            while (temp != null) {
                stack.push(temp);
                temp = temp.left;
            }
            temp = stack.pop();
            System.out.print(temp.element + " ");
            temp = temp.right;
        }
    }

    public void printIn() {
        printIn(root);
    }

    private void printPost(BSTNode<T> current) {

    }
}
