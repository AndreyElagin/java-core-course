package com.epam.homework.external.doublylinkedList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyDoublyLinkedListTest {

    @Test
    @DisplayName("Should add an item to the list at the last position and resize the list")
    void add() {
        MyDoublyLinkedList<Integer> testList = new MyDoublyLinkedList<>();
        Integer resultItem = (Integer) 1;

        testList.add(1);

        assertEquals(testList.get(0), resultItem);
        assertEquals(testList.size(), 1);
    }

    @Test
    @DisplayName("Should remove an item from list and resize the list")
    void remove() {
        MyDoublyLinkedList<Integer> testList = new MyDoublyLinkedList<>();
        MyDoublyLinkedList<Integer> resultTestList = new MyDoublyLinkedList<>();
        testList.add(0);
        testList.add(1);
        testList.add(2);
        resultTestList.add(0);
        resultTestList.add(2);

        testList.remove(1);

        assertTrue(testList.equals(resultTestList));
        assertEquals(testList.size(), resultTestList.size());
    }

    @Test
    void contains() {
    }

    @Test
    void get() {
    }

    @Test
    void clear() {
    }

    @Test
    void first() {
    }

    @Test
    void last() {
    }

    @Test
    void sublist() {
    }

    @Test
    void size() {
    }
}