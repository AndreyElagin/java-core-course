package com.epam.homework.external.hashmap;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

@SuppressWarnings("unchecked")
public class MyHashMap<K, V> implements MyMap<K, V> {
    float loadFactor = 0.75f;
    private int capacity = 16;
    private int size = 0;
    int threshold = (int) Math.floor(capacity * loadFactor);
    private Entry[] buckets;

    public MyHashMap() {
        buckets = new Entry[capacity];
    }

    @Override
    public void put(K key, V value) {
        if (key == null) {
            putForNullKey(value);
        } else {
            putForNonNullKey(key, value);
        }
        if (size++ >= threshold) {
            resize(2 * buckets.length);
        }
    }

    @Override
    public V remove(K key) {
        int hash = (key == null) ? 0 : hash(key.hashCode());
        int bucketIndex = indexFor(hash, buckets.length);
        Entry<K, V> prev = buckets[bucketIndex];
        Entry<K, V> curEntry = buckets[bucketIndex];

        while (curEntry != null) {
            K keyCurEntry = curEntry.key;
            Entry<K, V> next = curEntry.next;
            if (curEntry.hash == hash && keyCurEntry.equals(key)) {
                size--;
                if (prev == curEntry)
                    buckets[bucketIndex] = next;
                else
                    prev.next = next;
                return curEntry.value;
            }
            prev = curEntry;
            curEntry = next;
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        if (this.get(key) != null) {
            return true;
        }
        return false;
    }

    @Override
    public V get(K key) {
        if (key == null) {
            Entry<K, V> curEntry = buckets[0];

            while (curEntry != null) {
                if (curEntry.key == null) {
                    return curEntry.value;
                }
                curEntry = curEntry.next;
            }
            return null;
        }

        int hash = hash(key.hashCode());
        int bucketIndex = indexFor(hash, buckets.length);
        Entry<K, V> curEntry = buckets[bucketIndex];

        while (curEntry != null) {
            K keyCurEntry = curEntry.key;
            if (curEntry.hash == hash && keyCurEntry.equals(key)) {
                return curEntry.value;
            }
            curEntry = curEntry.next;
        }
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

    public Iterator<Entry<K, V>> iterator() {
        return new Iterator<Entry<K, V>>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size;
            }

            @Override
            public Entry<K, V> next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("No next item");
                }
                return getEntry(currentIndex++).value;
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('{');

        for (int i = 0; i < buckets.length; i++) {
            Entry<K, V> curEntry = buckets[i];

            while (curEntry != null) {
                sb.append(curEntry.key).append(" = ").append(curEntry.value).append(", ");
                curEntry = curEntry.next;
            }
        }
        return sb.append('}').toString();
    }

    private void putForNullKey(V value) {
        Entry<K, V> curEntry = buckets[0];

        while (curEntry != null) {
            K keyCurEntry = curEntry.key;
            System.out.println(keyCurEntry);
            if (keyCurEntry == null) {
                curEntry.value = value;
            }
            curEntry = curEntry.next;
        }
        Entry<K, V> nextElem = buckets[0];
        buckets[0] = new Entry<>(null, value, nextElem, 0);
    }

    private void putForNonNullKey(K key, V value) {
        int hash = hash(key.hashCode());
        int bucketIndex = indexFor(hash, capacity);
        Entry<K, V> curEntry = buckets[bucketIndex];

        while (curEntry != null) {
            K keyCurEntry = curEntry.key;
            if (curEntry.hash == hash && keyCurEntry.equals(key)) {
                curEntry.value = value;
            }
            curEntry = curEntry.next;
        }
        Entry<K, V> nextElem = buckets[bucketIndex];
        buckets[bucketIndex] = new Entry<>(key, value, nextElem, hash);
    }

    private static int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    private void resize(int newCapacity) {
        Entry[] newBuckets = new Entry[newCapacity];
        transfer(newBuckets);
        buckets = newBuckets;
        threshold = (int) (newCapacity * loadFactor);
    }

    private void transfer(Entry[] newTable) {
        int newCapacity = newTable.length;

        for (Entry<K, V> curEntry : buckets) {
            while (curEntry != null) {
                Entry<K, V> next = curEntry.next;
                int bucketIndex = indexFor(curEntry.hash, newCapacity);
                curEntry.next = newTable[bucketIndex];
                newTable[bucketIndex] = curEntry;
                curEntry = next;
            }
        }
    }

    private int indexFor(int h, int length) {
        return h & (length - 1);
    }

    static class Entry<K, V> {

        final K key;
        V value;
        Entry<K, V> next;
        final int hash;

        public Entry(K key, V value, Entry<K, V> next, int hash) {
            this.key = key;
            this.value = value;
            this.next = next;
            this.hash = hash;
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

        static int hash(Object key) {
            int h;
            return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
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

            return this.key.equals(that.key) && this.value.equals(that.value) && this.next.equals(that.next);
        }

        public final int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }
    }
}
