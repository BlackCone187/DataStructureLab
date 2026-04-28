package com.example.CircularDoublyLinkedList;

public class Launcher {
    public static void main(String[] args) {
        CircularDoublyLinkedList<String> list = new CircularDoublyLinkedList<>();

        list.addFirst("Apple");
        list.addLast("Banana");
        list.addLast("Cherry");


       // used add(T element, int index)
        list.add("Dragon fruit", 1);

        System.out.println("Size: " + list.size());
        System.out.println("First: " + list.getFirst());
        System.out.println("Last: " + list.getLast());

        // using get(int index)
        System.out.println("Front: " + list.get(0));
        System.out.println("Back: " + list.get(list.size() - 1));


        list.removeFirst();       // removes "Apple"
        list.removeLast();        // removes "Cherry"
        list.remove(0);     // removes "Dragon fruit"

        System.out.println("Element at index = 0: " + list.get(0));
        System.out.println("Final size: " + list.size());
    }
}
