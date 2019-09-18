package com.epam.homework.external.arraylist;

public interface MyList<E> {
    void add(E e);
    E remove(int index);
    boolean contains(E e);
    E get(int index);
    void clear();
    int size();
}
