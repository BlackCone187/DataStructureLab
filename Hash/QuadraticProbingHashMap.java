package com.example.Hash;

public class QuadraticProbingHashMap<T> {
    private HashEntry<T>[] hashEntries;
    private static final int DEFAULT_CAPACITY = 11;

    private int size;

    @SuppressWarnings("unchecked")
    public QuadraticProbingHashMap() {
        hashEntries = new HashEntry[DEFAULT_CAPACITY];
        size = 0;
    }

    private int hashFunction(int key) {
        return key % hashEntries.length;
    }

    private int f(int key, int i) {
        return (hashFunction(key) + i * i) % hashEntries.length;
    }

    public void insert(int key, T value) {
        for (int i = 0; i < hashEntries.length; i++) {
            int index = f(key, i);
            HashEntry<T> entry = hashEntries[index];

            if (entry == null || entry.getStatus() == 'D') {
                hashEntries[index] = new HashEntry<>(key, value);
                hashEntries[index].setStatus('F');
                size++;
                return;
            }

            if (entry.getKey() == key && entry.getStatus() == 'F') {
                entry.setValue(value);
                return;
            }
        }
        System.out.println("Table is full");
    }

    public T search(int key) {
        for (int i = 0; i < hashEntries.length; i++) {
            int index = f(key, i);
            HashEntry<T> entry = hashEntries[index];

            if (entry == null) {
                return null;
            }

            if (entry.getKey() == key && entry.getStatus() == 'F') {
                return null;
            }
        }
        return null;
    }

    public boolean delete(int key) {
        for (int i = 0; i < hashEntries.length; i++) {
            int index = f(key, i);
            HashEntry<T> entry = hashEntries[index];

            if (entry == null) return false;

            if (entry.getKey() == key && entry.getStatus() == 'F') {
                entry.setStatus('D');
                size--;
                return true;
            }
        }
        return false;
    }

    public int getSize() {
        return size;
    }
}