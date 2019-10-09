package com.epam.homework.external.doublylinkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyDoublyLinkedList<E> implements MyList<E>, Iterable<E> {
    private Node<E> first;
    private Node<E> last;
    private int size;

    public MyDoublyLinkedList() {
    }

    @Override
    public void add(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
    }

    @Override
    public E remove(int index) {
        check(index);

        final Node<E> removingNode = getNode(index);
        final E element = removingNode.value;
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

        removingNode.value = null;
        size--;
        return element;
    }

    @Override
    public boolean contains(E e) {
        Node<E> currentElem = first;
        if (currentElem == null) {
            return currentElem == e;
        }
        if (currentElem.value == null) {
            return currentElem.value == e;
        }
        for (int i = 0; i < size; i++) {
            if (currentElem.value.equals(e)) {
                return true;
            } else {
                currentElem = currentElem.next;
            }
        }
        return false;
    }

    @Override
    public E get(int index) {
        check(index);
        return getNode(index).value;
    }

    @Override
    public void clear() {
        for (Node<E> x = first; x != null; ) {
            Node<E> next = x.next;
            x.value = null;
            x.next = null;
            x.prev = null;
            x = next;
        }
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public E first() {
        final Node<E> f = first;
        if (f == null) {
            throw new NoSuchElementException("The list contains no elements");
        }
        return f.value;
    }

    @Override
    public E last() {
        final Node<E> l = last;
        if (l == null) {
            throw new NoSuchElementException("The list contains no elements");
        }
        return l.value;
    }

    @Override
    public MyDoublyLinkedList<E> sublist(int from, int to) {
        if (!(checkIndex(from) && checkIndex(to))) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        MyDoublyLinkedList<E> subList = new MyDoublyLinkedList<>();

        for (int i = from; i <= to; i++) {
            subList.add(getNode(i).value);
        }

        return subList;
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
                if (!hasNext()) {
                    throw new NoSuchElementException("No next item");
                }
                return getNode(currentIndex++).value;
            }
        };
    }

    @Override
    public String toString() {
        Iterator<E> it = iterator();
        if (!it.hasNext()) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < size; i++) {
            E e = it.next();
            sb.append(e == this ? "(this Collection)" : e);
            if (!it.hasNext()) {
                return sb.append(']').toString();
            }
            sb.append(',').append(' ');
        }
        return sb.toString();
    }

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
            if (!(this.getNode(i).value).equals(that.getNode(i).value)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        int hashCode = 1;
        for (E e : this)
            hashCode = 31 * hashCode + (e == null ? 0 : e.hashCode());
        return hashCode;
    }

    private Node<E> getNode(int index) {
        if (index < (size / 2)) {
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

    private boolean checkIndex(int index) {
        if (index >= 0 && index < size) {
            return true;
        }
        return false;
    }

    private void check(int index) {
        if (!checkIndex(index)) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
    }

    private static class Node<E> {

        E value;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.value = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
