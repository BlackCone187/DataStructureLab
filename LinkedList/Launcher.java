package com.example.LinkedList;


public class Launcher {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();

        list.add("Apple");
        list.add("Orange");

        list.add(1, "Kiwi");

        System.out.println("Size: " + list.size());
        System.out.println("Full list:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Index " + i + ": " + list.get(i));
        }

        // remove methods
        list.remove(1);

        System.out.println("New First: " + list.getFirst());
        System.out.println("New Last: " + list.getLast());

        list.removeFirst();
        list.removeFirst();
        System.out.println("Size: " + list.size());
    }
}
