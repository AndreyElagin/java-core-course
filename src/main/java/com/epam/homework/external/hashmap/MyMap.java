package com.epam.homework.external.hashmap;

public interface MyMap<K, V> {
    void put(K key, V value);

    V remove(K key);

    boolean contains(K key);

    V get(K key);

    void clear();

    V replace(K key, V value);

    int size();
}
