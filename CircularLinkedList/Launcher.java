package com.example.CircularLinkedList;

public class Launcher {

    public static void main(String[] args) {
        CircularLinkedList<String> list = new CircularLinkedList<>();

        // 1. Test Adding
        list.addFirst("Banana");
        list.addLast("Apple");
        list.add(1, "Orange");

        System.out.println("Size: " + list.size());

        // get methods
        System.out.println("Index = 0: " + list.get(0));
        System.out.println("Index = 1: " + list.get(1));
        System.out.println("Index = 2: " + list.get(2));


        // remove methods
        list.removeFirst();
        System.out.println("New First: " + list.get(0));


        list.removeLast();
        System.out.println("Final Size: " + list.size());
        System.out.println(list.get(0));
    }
}
