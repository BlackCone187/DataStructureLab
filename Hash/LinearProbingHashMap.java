package com.example.Hash;

public class LinearProbingHashMap<T> {
    private HashEntry<T>[] hashEntries;
    private int size;
    private static final int DEFAULT_CAPACITY = 11;
    private static final double LOAD_FACTOR = 0.75;

    @SuppressWarnings("unchecked")
    public LinearProbingHashMap() {
        hashEntries = new HashEntry[DEFAULT_CAPACITY];
        size = 0;
    }

    // Hash function should only take the key, no 'i' variable
    private int hashFunction(int key) {
        return Math.abs(key % hashEntries.length);
    }

    public void insert(int key, T value) {
        // resize if load factor exceeded
        if ((double) size / hashEntries.length >= LOAD_FACTOR) {
            resize();
        }
        int index = hashFunction(key);

        int i = 0;
        while (i < hashEntries.length) {
            int probeIndex = (index + i) % hashEntries.length;
            HashEntry<T> entry = hashEntries[probeIndex];

            if (entry == null || entry.getStatus() == 'D') {
                hashEntries[probeIndex] = new HashEntry<>(key, value);
                hashEntries[probeIndex].setStatus('F');
                size++;
                return;
            }

            if (entry.getKey() == key) {
                entry.setValue(value);
                return;
            }

            i++;
        }
    }

    public T search(int key) {
        int index = hashFunction(key);

        for (int i = 0; i < hashEntries.length; i++) {
            int probeIndex = (index + i) % hashEntries.length;
            HashEntry<T> entry = hashEntries[probeIndex];

            if (entry == null) return null; // Key not found

            if (entry.getKey() == key && entry.getStatus() == 'O') {
                return entry.getValue();
            }
        }
        return null;
    }

    public boolean remove(int key) {
        int index = hashFunction(key);

        for (int i = 0; i < hashEntries.length; i++) {
            int probeIndex = (index + i) % hashEntries.length;
            HashEntry<T> entry = hashEntries[probeIndex];

            if (entry == null) return false; // Key not found

            if (entry.getKey() == key && entry.getStatus() == 'F') {
                entry.setStatus('D');
                size--;
                return true;
            }
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        HashEntry<T>[] old = hashEntries;
        hashEntries = new HashEntry[old.length * 2 + 1]; // keep it odd/prime-ish
        size = 0;

        for (HashEntry<T> entry : old) {
            if (entry != null && entry.getStatus() == 'O') {
                insert(entry.getKey(), entry.getValue());
            }
        }
    }

    public int getSize() {
        return size;
    }
}