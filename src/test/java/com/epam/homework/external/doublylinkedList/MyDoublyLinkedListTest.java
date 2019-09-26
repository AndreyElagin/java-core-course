package com.epam.homework.external.doublylinkedList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

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

        assertEquals(testList, resultTestList);
        assertEquals(testList.size(), resultTestList.size());
    }

    @Test
    @DisplayName("Should return true if the list contains an element and false if it does not contain")
    void contains() {
        MyDoublyLinkedList<Integer> testList = new MyDoublyLinkedList<>();
        testList.add(0);
        testList.add(1);
        testList.add(2);

        assertEquals(testList.contains(1), true);
    }

    @Test
    @DisplayName("Must return an item by index")
    void get() {
        MyDoublyLinkedList<Integer> testList = new MyDoublyLinkedList<>();
        testList.add(0);
        testList.add(1);
        testList.add(2);

        assertEquals(testList.get(1), (Integer) 1);
    }

    @Test
    @DisplayName("Should clear the list")
    void clear() {
        MyDoublyLinkedList<Integer> testList = new MyDoublyLinkedList<>();
        testList.add(0);
        testList.add(1);
        testList.add(2);

        testList.clear();

        assertEquals(testList.size(), 0);
        assertFalse(testList.contains(0));
        assertFalse(testList.contains(1));
        assertFalse(testList.contains(2));
    }

    @Test
    @DisplayName("Must return the first element of the list")
    void first() {
        MyDoublyLinkedList<Integer> testList = new MyDoublyLinkedList<>();
        testList.add(0);
        testList.add(1);
        testList.add(2);

        assertEquals(testList.first(), (Integer) 0);
    }

    @Test
    @DisplayName("Must return the last item in the list")
    void last() {
        MyDoublyLinkedList<Integer> testList = new MyDoublyLinkedList<>();
        testList.add(0);
        testList.add(1);
        testList.add(2);

        assertEquals(testList.last(), (Integer) 2);
    }

    @Test
    @DisplayName("Must return a sublist of given indices")
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

        System.out.println(resultList);
        System.out.println(testList.sublist(1, 3));
        assertEquals(testList.sublist(1, 3), resultList);
    }

    @Test
    @DisplayName("Must return list size")
    void size() {
        MyDoublyLinkedList<Integer> testList = new MyDoublyLinkedList<>();
        testList.add(0);
        testList.add(1);
        testList.add(2);

        assertEquals(testList.size(), 3);
    }
}