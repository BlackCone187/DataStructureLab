package com.example.Stack;

import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter String to check: ");
        String str = scanner.next();

        System.out.println(isBalance(str));
    }

    public  static boolean isBalance(String str) {
        StackLinkedList<Character> stackLinkedList = new StackLinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '{' || str.charAt(i) == '[' || str.charAt(i) == '(') {
                stackLinkedList.push(str.charAt(i));
            } else if (!stackLinkedList.isEmpty() &&
                       str.charAt(i) == '}' && stackLinkedList.peek() == '{' ||
                       str.charAt(i) == ']' && stackLinkedList.peek() == '[' ||
                       str.charAt(i) == ')' && stackLinkedList.peek() == '(') {
                stackLinkedList.pop();
            } else {
                return false;
            }
        }
        return stackLinkedList.isEmpty();
    }
}
