package com.epam.homework.external.doublylinkedList;

import java.util.List;
import java.util.Objects;

public class MyDoublyLinkedList<E> implements MyList<E> {
    private Node first;
    private Node last;
    private int size;

    public MyDoublyLinkedList() {
        size = 0;
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
    private Node<E> node(int index) {
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
        if (!(index >= 0 && index < size)) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        Node<E> removingNode = node(index);
        final E element = removingNode.item;
        final Node<E> next = removingNode.next;
        final Node<E> prev = removingNode.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            removingNode.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            removingNode.next = null;
        }

        removingNode.item = null;
        size--;
        return element;
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
        if (from < 0 || from > this.size() - 1 || to < 0 || to > this.size() - 1) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        MyDoublyLinkedList<E> subList = new MyDoublyLinkedList<>();

        subList.first = node(from);
        subList.last = node(to);
        subList.size = to - from;

        subList.first.prev = null;
        subList.last.next = null;

        return (List<E>) subList;
    }

    @Override
    public int size() {
        return size;
    }

//    @Override
//    public Iterator<E> iterator() {
//        return new Iterator<E>() {
//            private int currentIndex = 0;
//
//            @Override
//            public boolean hasNext() {
//                return currentIndex < size;
//            }
//
//            @Override
//            public E next() {
//                if (!hasNext()) throw new IllegalArgumentException("No next item");
//                return (E) node(currentIndex++);
//            }
//        };
//    }
//
//    @Override
//    public String toString() {
//        Iterator<E> it = iterator();
//        if (! it.hasNext())
//            return "[]";
//
//        StringBuilder sb = new StringBuilder();
//        sb.append('[');
//        for (;;) {
//            E e = it.next();
//            sb.append(e == this ? "(this Collection)" : e);
//            if (! it.hasNext())
//                return sb.append(']').toString();
//            sb.append(',').append(' ');
//        }
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MyDoublyLinkedList<?> that = (MyDoublyLinkedList<?>) o;

        if (this.size != that.size) {
            return false;
        }

        for (int i = 0; i < size; i++) {
            if (this.node(i) == ((MyDoublyLinkedList<?>) o).node(i)) {
                return false;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, last, size);
    }
}
