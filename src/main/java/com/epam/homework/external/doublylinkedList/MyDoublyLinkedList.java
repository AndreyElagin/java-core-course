package com.epam.homework.external.doublylinkedList;

import java.util.List;

public class MyDoublyLinkedList<E> implements MyList<E> {
    private Node first;
    private Node last;
    private int size;

    public MyDoublyLinkedList() {
        size = 0;
    }

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    public int indexOf(E e) {
        int index = 0;
        if (e == null) {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.item == null)
                    return index;
                index++;
            }
        } else {
            for (Node<E> x = first; x != null; x = x.next) {
                if (e.equals(x.item))
                    return index;
                index++;
            }
        }
        return -1;
    }

    Node<E> node(int index) {
        if (index < (size >> 1)) {
            Node<E> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node<E> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }

    @Override
    public void add(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
    }

    @Override
    public E remove(int index) {

    }

    @Override
    public boolean contains(E e) {
        return indexOf(e) >= 0;
    }

    @Override
    public E get(int index) {
        return node(index).item;
    }

    @Override
    public void clear() {
        for (Node<E> x = first; x != null; ) {
            Node<E> next = x.next;
            x.item = null;
            x.next = null;
            x.prev = null;
            x = next;
        }
        first = last = null;
        size = 0;
    }

    @Override
    public E first() {
        final Node<E> f = first;
        if (f == null)
            throw new IllegalArgumentException("The list contains no items");
        return f.item;
    }

    @Override
    public E last() {
        final Node<E> l = last;
        if (l == null)
            throw new IllegalArgumentException("The list contains no items");
        return l.item;
    }

    @Override
    public List<E> sublist(int from, int to) {
        if(from < 0 || from > this.size()-1 || to < 0 || to > this.size()-1){
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        MyDoublyLinkedList<E> subList = new MyDoublyLinkedList<>();

    }

    @Override
    public int size() {
        return size;
    }
}
