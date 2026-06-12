package com.example.Hash;

import com.example.LinkedList.LinkedList;

public class LinearProbingHashMap<T> {
    private HashEntry<T>[] hashEntries;

    @SuppressWarnings("unchecked")
    public LinearProbingHashMap() {
        hashEntries = new HashEntry[11];
    }

    private int hashFunction(int key) {
        return ((key % hashEntries.length)+i) % hashEntries.length;
    }

    public void insert(int key, T value) {
        key = hashFunction(key);
        if (hashEntries[key] == null || key > hashEntries.length) {
            insert(key+1, value);
        }
        hashEntries[key].add(new HashEntry<>(key, value));
    }
}
