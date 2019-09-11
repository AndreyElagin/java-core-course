package com.epam.homework.external.arraylist;

@SuppressWarnings("unchecked")
public class MyArrayList<E> implements MyList<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private E[] storage = (E[]) new Object[DEFAULT_CAPACITY];
    private int size = 0;

    private void resize(int newLengthArray) {
        E[] newStorage = (E[]) new Object[newLengthArray];
        System.arraycopy(storage, 0, newStorage, 0, size);
        storage = newStorage;
    }

    @Override
    public void add(E itemToAdd) {
        if (size >= storage.length) {
            resize(storage.length * 2);
        }
        storage[size++] = itemToAdd;
    }

    @Override
    public E remove(int index) {
        E result = storage[index];

        if (size - index >= 0) {
            System.arraycopy(storage, index + 1, storage, index, size - index);
        }
        storage[size] = null;
        size--;

        if (storage.length > DEFAULT_CAPACITY && size < storage.length / 2) {
            resize(storage.length / 2);
        }
        return result;
    }

    @Override
    public boolean contains(E searchElem) {
        for (E e : storage) {
            if (e == searchElem) {
                return true;
            }
        }
        return false;
    }


    @Override
    public E get(int index) {
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
}
