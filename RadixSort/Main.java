package com.example.RadixSort;

public class Main {
    public static void main(String[] args) {
        int[] data = {170, 45, 75, 90, 802, 24, 2, 66};

        System.out.print("Before Sort: ");
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
        RadixSort.sort(data);

        System.out.print("After Sort:  ");
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();    }

}
