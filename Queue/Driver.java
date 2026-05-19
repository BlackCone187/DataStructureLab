package com.example.Queue;

import java.util.Queue;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        QueueLinkedList<Integer> queue = new QueueLinkedList<>();

//        queue.enQueue(1);
//        queue.enQueue(2);
//        queue.enQueue(3);
//        queue.enQueue(4);
        Scanner scanner = new Scanner(System.in);
        int input;
        System.out.println();
//        while (true) {
//            input = scanner.nextInt();
//            if (input == -1) {
//                break;
//            }
//            queue.enQueue(input);
//        }
//        reverseQueue(queue);

        QueueArray<Integer> queueArray = new QueueArray<>(4);
        queueArray.enQueue(1);
        queueArray.enQueue(2);
        queueArray.enQueue(3);
        queueArray.enQueue(4);

        reverseQueue(queueArray);

        // 1 2 3 4 --> 1 / 2 3 4 --> 1 / 2 / 3 4 --> 1 / 2 / 3 / 4 --> 1 / 2 / 4 3 --> 1 / 4 3 2 --> 4 3 2 1  :D
        while (!queueArray.isEmpty()) {
            System.out.print(queueArray.deQueue() + " ");
        }
    }
    public static <T> void reverseQueue(QueueLinkedList<T> queue) {
        if (queue.isEmpty())
            return;

        T data = queue.deQueue();
        reverseQueue(queue);
        queue.enQueue(data);
    }

    public static <T> void reverseQueue(QueueArray<T> queue) {
        if (queue.isEmpty())
            return;

        T data = queue.deQueue();
        reverseQueue(queue);
        queue.enQueue(data);
    }
}
