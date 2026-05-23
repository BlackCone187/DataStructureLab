package com.example.DoublyLinkedList;

public class Launcher {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        list.addFirst(10);
        list.addLast(30);
        list.add(20, 1);
        list.add(40);

        System.out.println("Size: " + list.size());

        // get methods
        System.out.println("First element: " + list.getFirst());
        System.out.println("Last element: " + list.getLast());
        System.out.println("Element at index = 2: " + list.get(2));

        // remove methods
        list.removeFirst();
        list.removeLast();

        System.out.print("After removing: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();

        // 5. Testing index-based removal
        System.out.println(list.remove(0));
        System.out.println("Final size: " + list.size());
    }
}
