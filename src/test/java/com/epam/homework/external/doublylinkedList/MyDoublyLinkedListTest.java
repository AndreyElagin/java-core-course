package com.epam.homework.external.doublylinkedList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MyDoublyLinkedListTest {
    @Test
    @DisplayName("Should add an item to the list at the last position and resize the list")
    void add() {
        MyDoublyLinkedList<Integer> testList = new MyDoublyLinkedList<>();
        Integer resultItem = (Integer) 1;

        testList.add(1);

        assertEquals(resultItem, testList.get(0));
        assertEquals(1, testList.size());
    }

    @Test
    @DisplayName("Should remove an item from the list and resize the list, or throw an IndexOutOfBoundsException " +
            "if the index out of bounds")
    void remove() {
        MyDoublyLinkedList<Integer> testList = new MyDoublyLinkedList<>();
        MyDoublyLinkedList<Integer> resultTestList = new MyDoublyLinkedList<>();
        testList.add(0);
        testList.add(1);
        testList.add(2);
        resultTestList.add(0);
        resultTestList.add(2);

        testList.remove(1);

        assertEquals(resultTestList, testList);
        assertEquals(resultTestList.size(), testList.size());

        Throwable exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            testList.remove(5);
        });
        assertEquals("Index out of bounds", exception.getMessage());
    }

    @Test
    @DisplayName("Should return true if the list contains an element and false if it does not contain")
    void contains() {
        MyDoublyLinkedList<Integer> testList = new MyDoublyLinkedList<>();
        testList.add(0);
        testList.add(1);
        testList.add(2);

        assertTrue(testList.contains(1));
    }

    @Test
    @DisplayName("Must return an item by index, or throw an IndexOutOfBoundsException if the index out of bounds")
    void get() {
        MyDoublyLinkedList<Integer> testList = new MyDoublyLinkedList<>();
        testList.add(0);
        testList.add(1);
        testList.add(2);

        assertEquals((Integer) 1, testList.get(1));

        Throwable exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            testList.get(5);
        });
        assertEquals("Index out of bounds", exception.getMessage());
    }

    @Test
    @DisplayName("Should clear the list")
    void clear() {
        MyDoublyLinkedList<Integer> testList = new MyDoublyLinkedList<>();
        testList.add(0);
        testList.add(1);
        testList.add(2);

        testList.clear();

        assertEquals(0, testList.size());
        assertFalse(testList.contains(0));
        assertFalse(testList.contains(1));
        assertFalse(testList.contains(2));
    }

    @Test
    @DisplayName("Should return the first element of the list, or throw an IllegalArgumentException " +
            "if the element does not exist")
    void first() {
        MyDoublyLinkedList<Integer> testList = new MyDoublyLinkedList<>();
        testList.add(0);
        testList.add(1);
        testList.add(2);

        assertEquals((Integer) 0, testList.first());

        testList.clear();
        Throwable exception = assertThrows(IllegalArgumentException.class, testList::first);
        assertEquals("The list contains no items", exception.getMessage());
    }

    @Test
    @DisplayName("Should return the last element of the list, or throw an IllegalArgumentException " +
            "if the element does not exist")
    void last() {
        MyDoublyLinkedList<Integer> testList = new MyDoublyLinkedList<>();
        testList.add(0);
        testList.add(1);
        testList.add(2);

        assertEquals((Integer) 2, testList.last());

        testList.clear();
        Throwable exception = assertThrows(IllegalArgumentException.class, testList::last);
        assertEquals("The list contains no items", exception.getMessage());
    }

    @Test
    @DisplayName("Should return a sublist of given indices")
    void sublist() {
        MyDoublyLinkedList<Integer> testList = new MyDoublyLinkedList<>();
        testList.add(0);
        testList.add(1);
        testList.add(2);
        testList.add(3);
        testList.add(4);
        MyDoublyLinkedList<Integer> resultList = new MyDoublyLinkedList<>();
        resultList.add(1);
        resultList.add(2);
        resultList.add(3);

        assertEquals(resultList, testList.sublist(1, 3));

        Throwable exception1 = assertThrows(IndexOutOfBoundsException.class, () -> {
            testList.sublist(-1, 1);
        });
        assertEquals("Index out of bounds", exception1.getMessage());

        Throwable exception2 = assertThrows(IndexOutOfBoundsException.class, () -> {
            testList.sublist(1, 10);
        });
        assertEquals("Index out of bounds", exception2.getMessage());
    }

    @Test
    @DisplayName("Should return list size")
    void size() {
        MyDoublyLinkedList<Integer> testList = new MyDoublyLinkedList<>();
        testList.add(0);
        testList.add(1);
        testList.add(2);

        assertEquals(3, testList.size());
    }
}