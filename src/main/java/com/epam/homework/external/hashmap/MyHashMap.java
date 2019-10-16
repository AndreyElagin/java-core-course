package com.epam.homework.external.hashmap;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

@SuppressWarnings("unchecked")
public class MyHashMap<K, V> implements MyMap<K, V>, Iterable<MyHashMap.Entry<K, V>> {
    private float loadFactor = 0.75f;
    private int capacity = 16;
    private int size = 0;
    private int threshold = (int) Math.floor(capacity * loadFactor);
    private Entry[] buckets;

    public MyHashMap() {
        buckets = new Entry[capacity];
    }

    @Override
    public void put(K key, V value) {
        if (key == null) {
            Entry<K, V> curEntry = buckets[0];

            if (curEntry != null) {
                curEntry.value = value;
            } else {
                buckets[0] = new Entry<>(null, value, null, 0);
                size++;
            }
        } else {
            int hash = key.hashCode();
            int bucketIndex = indexFor(hash, capacity);
            Entry<K, V> curEntry = buckets[bucketIndex];

            while (curEntry != null) {
                K keyCurEntry = curEntry.key;
                if (curEntry.hash == hash && keyCurEntry.equals(key)) {
                    curEntry.value = value;
                    return;
                }
                curEntry = curEntry.next;
            }
            Entry<K, V> nextElem = buckets[bucketIndex];
            buckets[bucketIndex] = new Entry<>(key, value, nextElem, hash);
            size++;
        }

        if (size >= threshold) {
            resize(2 * buckets.length);
        }
    }

    @Override
    public V remove(K key) {
        if (key == null) {
            Entry<K, V> curEntry = buckets[0];
            V oldValue;

            if (curEntry != null) {
                oldValue = curEntry.value;
                buckets[0] = null;
                size--;
                return oldValue;
            } else {
                return null;
            }
        } else {
            int hash = key.hashCode();
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
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        return this.get(key) != null;
    }

    @Override
    public V get(K key) {
        if (key == null) {
            Entry<K, V> curEntry = buckets[0];

            if (curEntry != null) {
                return curEntry.value;
            }
        } else {
            int hash = key.hashCode();
            int bucketIndex = indexFor(hash, buckets.length);
            Entry<K, V> curEntry = buckets[bucketIndex];

            while (curEntry != null) {
                K keyCurEntry = curEntry.key;
                if (curEntry.hash == hash && keyCurEntry.equals(key)) {
                    return curEntry.value;
                }
                curEntry = curEntry.next;
            }
        }
        return null;
    }

    @Override
    public void clear() {
        Iterator<Entry<K, V>> it = iterator();

        while (it.hasNext()) {
            Entry<K, V> curEntry = it.next();
            curEntry = null;
        }
        size = 0;
    }

    @Override
    public boolean replace(K key, V value) {
        if (key == null) {
            Entry<K, V> curEntry = buckets[0];

            if (curEntry != null) {
                curEntry.value = value;
                return true;
            } else {
                return false;
            }
        } else {
            int hash = key.hashCode();
            int bucketIndex = indexFor(hash, capacity);
            Entry<K, V> curEntry = buckets[bucketIndex];

            while (curEntry != null) {
                K keyCurEntry = curEntry.key;
                if (curEntry.hash == hash && keyCurEntry.equals(key)) {
                    curEntry.value = value;
                    return true;
                }
                curEntry = curEntry.next;
            }
            return false;
        }
    }

    @Override
    public int size() {
        return size;
    }

    public Iterator<Entry<K, V>> iterator() {
        return new Iterator<>() {
            int currentIndex = 0;
            int countIndexBucket = 0;
            Entry<K, V> prev;

            @Override
            public boolean hasNext() {
                return currentIndex < size;
            }

            @Override
            public Entry<K, V> next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("No next item");
                }

                if (prev != null) {
                    if (prev.next != null) {
                        prev = prev.next;
                        currentIndex++;
                        return prev;
                    }
                }

                prev = getNextBucketEntry();
                currentIndex++;
                return prev;
            }

            private Entry<K, V> getNextBucketEntry() {
                for (int i = countIndexBucket; i < capacity; i++) {
                    Entry<K, V> nextEntry = buckets[i];
                    countIndexBucket++;
                    if (nextEntry != null) {
                        return nextEntry;
                    }
                }
                return null;
            }
        };
    }

    @Override
    public String toString() {
        Iterator<Entry<K, V>> it = iterator();
        StringBuilder sb = new StringBuilder();
        sb.append('{');

        while (it.hasNext()) {
            var entry = it.next();
            sb.append(entry.key).append(" = ").append(entry.value);
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        return sb.append('}').toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MyHashMap<K, V> that = (MyHashMap<K, V>) o;

        if (this.size != that.size) {
            return false;
        }

        Iterator<Entry<K, V>> thisIt = this.iterator();
        Iterator<Entry<K, V>> thatIt = that.iterator();

        while (thisIt.hasNext() && thatIt.hasNext()) {
            Entry<K, V> thisEntry = thisIt.next();
            Entry<K, V> thatEntry = thatIt.next();
            if (!thisEntry.equals(thatEntry)) {
                return false;
            }
        }

        return thisIt.hasNext() == thatIt.hasNext();
    }

    @Override
    public int hashCode() {
        Iterator<Entry<K, V>> it = this.iterator();
        int result = Objects.hash(size);
        while (it.hasNext()) {
            result = 31 * result + it.next().hashCode();
        }
        return result;
    }

    private void resize(int newCapacity) {
        Entry[] newBuckets = new Entry[newCapacity];
        transfer(newBuckets);
        buckets = newBuckets;
        capacity = newCapacity;
        threshold = (int) (newCapacity * loadFactor);
    }

    private void transfer(Entry[] newBuckets) {
        int newCapacity = newBuckets.length;
        Iterator<Entry<K, V>> it = iterator();

        while (it.hasNext()) {
            Entry<K, V> curEntry = it.next();
            while (curEntry != null) {
                Entry<K, V> next = curEntry.next;
                int bucketIndex = indexFor(curEntry.hash, newCapacity);
                curEntry.next = newBuckets[bucketIndex];
                newBuckets[bucketIndex] = curEntry;
                curEntry = next;
            }
        }
    }

    private int indexFor(int h, int length) {
        return h & (length - 1);
    }

    static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;
        int hash;

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

            Entry<K, V> that = (Entry<K, V>) o;

            if (this.key != null && that.key != null) {
                return this.key.equals(that.key) && this.value.equals(that.value);
            }

            return this.value.equals(that.value);
        }

        public final int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }
    }
}
