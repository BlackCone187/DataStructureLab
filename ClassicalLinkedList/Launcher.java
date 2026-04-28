package com.example.ClassicalLinkedList;

public class Launcher {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();

        System.out.println("--- Testing Classic Add ---");
        list.addFirst("Apple");
        list.addFirst("Orange");
        list.add(1, "Banana");

        System.out.println("First: " + list.getFirst());
        System.out.println("Last: " + list.getLast());

        // remove methods
        list.removeFirst();
        System.out.println("New First: " + list.getFirst());

        list.removeLast();
        System.out.println("Remaining element (Last): " + list.getLast());
    }
}
