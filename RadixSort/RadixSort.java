package com.example.RadixSort;

import com.example.LinkedList.LinkedList;

public class RadixSort {

    public static void sort(int[] array) {
        if (array.length == 0) {
            return;
        }

        LinkedList<Integer>[] pots = new LinkedList[10];
        for (int i = 0; i < 10; i++) {
            pots[i] = new LinkedList<>();
        }

        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max)
                max = array[i];
        }

        for (int i = 1; max/i > 0; i*=10) {
            findPot(array, i, pots);
            getResult(array, pots);
        }
    }

    private static void findPot(int[] array, int i, LinkedList<Integer>[] pots) {
        for (int j = 0; j < array.length; j++) {
            int index = (array[j]/i) % 10;
            pots[index].addLast(array[j]);
        }
    }

    private static void getResult(int[] array, LinkedList<Integer>[] pots) {
        int index = 0;
        for (int i = 0; i < 10; i++) {
            while (pots[i].size() > 0) {
                array[index++] = pots[i].getFirst();
                pots[i].removeFirst();
            }
        }
    }
}
