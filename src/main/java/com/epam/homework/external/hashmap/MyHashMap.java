package com.epam.homework.external.hashmap;

import java.util.Objects;

public class MyHashMap<K, V> implements MyMap {
    private int size = 0;
    private int capacity = 16;
    private Entry<K, V>[] buckets;


    public MyHashMap() {
    }

    @Override
    public void put(Object key, Object value) {


        return;
    }

    @Override
    public Object remove(Object key) {
        return null;
    }

    @Override
    public boolean contains(Object e) {
        return false;
    }

    @Override
    public Object get(Object key) {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public Object replace(Object key, Object value) {
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    static class Entry<K, V> {
        final K key;
        V value;
        Entry<K, V> next;

        public Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public final K getKey() {
            return key;
        }

        public final V getValue() {
            return value;
        }

        public final String toString() {
            return key + "=" + value;
        }

        public final V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }

        public final boolean equals(Object o) {
            if (o == this) {
                return true;
            }

            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Entry<?, ?> that = (Entry<?, ?>) o;

            if (this.key.equals(that.key) && this.value.equals(that.value) && this.next.equals(that.next)) {
                return true;
            }

            return false;
        }

        public final int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }
    }
}
