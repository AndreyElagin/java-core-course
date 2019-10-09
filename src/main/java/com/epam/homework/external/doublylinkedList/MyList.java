package com.epam.homework.external.doublylinkedList;

public interface MyList<E> {
    void add(E e);
    E remove(int index);
    boolean contains(E e);
    E get(int index);
    void clear();
    E first();
    E last();
    MyDoublyLinkedList<E> sublist(int from, int to);
    int size();
}
