package com.example.Hash;

import com.example.LinkedList.LinkedList;

public class OpenHashingMap<T> {
    private LinkedList<HashEntry<T>>[] hashEntries;

    @SuppressWarnings("unchecked")
    public OpenHashingMap() {
        hashEntries = new LinkedList[11];

        for (int i = 0; i < hashEntries.length; i++) {
            hashEntries[i] = new LinkedList<>();
        }
    }

    public void insert(int key, T value) {
        key = hashFunction(key);
        hashEntries[key].add(new HashEntry<>(key, value));
    }

    private int hashFunction(int key) {
        return key % hashEntries.length;
    }

    public HashEntry<T> search(T value) {
        for (int i = 0; i < hashEntries.length; i++) {
            for (int j = 0; j < hashEntries[j].size(); i++) {
                if (hashEntries[i].get(j).getValue().equals(value)) {
                    return hashEntries[i].get(j);
                }
            }
        }
        return null;
    }

    public HashEntry<T> remove(T value) {
        for (int i = 0; i < hashEntries.length; i++) {
            for (int j = 0; j < hashEntries[j].size(); i++) {
                if (hashEntries[i].get(j).getValue().equals(value)) {
                    HashEntry<T> temp =  hashEntries[i].get(j);
                    hashEntries[i].remove(temp);
                    return temp;
                }
            }
        }
        return null;
    }

    public HashEntry<T> get(int key) {
        for (int i = 0; i < hashEntries.length; i++) {
            for (int j = 0; j < hashEntries[j].size(); i++) {
                if (hashEntries[i].get(j).getKey() == key) {
                    return hashEntries[i].get(j);
                }
            }
        }
        return null;
    }






}
