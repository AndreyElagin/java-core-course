package com.epam.homework.external.arraylist;

import java.util.Iterator;

@SuppressWarnings("unchecked")
public class MyArrayList<E> implements MyList<E>, Iterable<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private int size = 0;

    MyArrayList<E> myArrayList = new MyArrayList<>() {
        private E[] storage = (E[]) new Object[DEFAULT_CAPACITY];
    };

    private void resize(int newLengthArray) {
        E[] newStorage = (E[]) new Object[newLengthArray];
        System.arraycopy(storage, 0, newStorage, 0, size);
        storage = newStorage;
    }

    private void checkIndex(int index) {
        if (index > size - 1) {
            throw new IllegalArgumentException("The entered number goes beyond the bounds of the array");
        }
    }

    @Override
    public void add(E itemToAdd) {
        if (size >= storage.length) {
            resize((int) (storage.length * 1.5));
        }
        storage[size++] = itemToAdd;
    }

    @Override
    public E remove(int index) {
        checkIndex(index);
        E result = storage[index];

        if (size != index) {
            System.arraycopy(storage, index + 1, storage, index, size - index);
        }
        storage[size] = null;
        size--;

        if (storage.length > DEFAULT_CAPACITY && size < storage.length / 1.5) {
            resize((int) (storage.length / 1.5));
        }
        return result;
    }

    @Override
    public boolean contains(E searchElem) {
        for (int i = 0; i < size - 1; i++) {
            E e = storage[i];
            if (e.equals(searchElem)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        return storage[index];
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size;
            }

            @Override
            public E next() {
                if (!hasNext()) throw new IllegalArgumentException("No next item");
                return storage[currentIndex++];
            }
        };
    }
}
