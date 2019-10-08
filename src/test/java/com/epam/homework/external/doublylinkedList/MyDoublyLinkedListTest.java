package com.epam.homework.external.doublylinkedList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MyDoublyLinkedListTest {
    @Test
    @DisplayName("Should add an element to the list at the last position and resize the list")
    void add() {
        MyDoublyLinkedList<Integer> testList1 = new MyDoublyLinkedList<>();
        MyDoublyLinkedList<Integer> testList2 = new MyDoublyLinkedList<>();
        Integer expectedItemTestList1 = 1;
        Integer expectedItemTestList2 = null;

        testList1.add(1);
        testList2.add(null);

        assertEquals(expectedItemTestList1, testList1.get(0));
        assertEquals(1, testList1.size());
        assertEquals(expectedItemTestList2, testList2.get(0));
        assertEquals(1, testList1.size());
    }

    @Test
    @DisplayName("Should remove an element from the list and resize the list")
    void remove1() {
        MyDoublyLinkedList<Integer> testList1 = new MyDoublyLinkedList<>();
        MyDoublyLinkedList<Integer> testList2 = new MyDoublyLinkedList<>();
        MyDoublyLinkedList<Integer> expectedItemTestList = new MyDoublyLinkedList<>();
        testList1.add(0);
        testList1.add(1);
        testList1.add(2);
        expectedItemTestList.add(0);
        expectedItemTestList.add(2);
        testList2.add(1);

        testList1.remove(1);

        assertEquals(expectedItemTestList, testList1);
        assertEquals(expectedItemTestList.size(), testList1.size());
        assertEquals((Integer) 1, testList2.remove(0));
    }

    @Test
    @DisplayName("Should throw an IndexOutOfBoundsException if the index out of bounds")
    void remove2() {
        MyDoublyLinkedList<Integer> testList1 = new MyDoublyLinkedList<>();

        testList1.add(0);

        Throwable exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            testList1.remove(5);
        });
        assertEquals("Index out of bounds", exception.getMessage());
    }

    @Test
    @DisplayName("Should return true if the list contains an element and false if it does not contain")
    void contains() {
        MyDoublyLinkedList<Integer> testList1 = new MyDoublyLinkedList<>();
        MyDoublyLinkedList<Integer> testList2 = new MyDoublyLinkedList<>();
        testList1.add(0);
        testList1.add(1);
        testList1.add(2);
        testList2.add(null);

        assertTrue(testList1.contains(1));
        assertFalse(testList1.contains(55));
        assertTrue(testList2.contains(null));
        assertFalse(testList2.contains(55));
    }

    @Test
    @DisplayName("Should return true if the list does not contain an element")
    void nullTest() {
        MyDoublyLinkedList<Integer> testList1 = new MyDoublyLinkedList<>();
        testList1.add(null);
        testList1.remove(0);

        assertTrue(testList1.contains(null));
    }

    @Test
    @DisplayName("Should return an element by index")
    void get1() {
        MyDoublyLinkedList<Integer> testList = new MyDoublyLinkedList<>();
        testList.add(0);
        testList.add(1);
        testList.add(2);
        testList.add(null);

        assertEquals((Integer) 1, testList.get(1));
        assertNull(testList.get(3));
    }

    @Test
    @DisplayName("Should throw an IndexOutOfBoundsException if the index out of bounds")
    void get2() {
        MyDoublyLinkedList<Integer> testList = new MyDoublyLinkedList<>();
        testList.add(0);

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
        testList.add(null);

        testList.clear();

        assertEquals(0, testList.size());
        assertFalse(testList.contains(0));
        assertFalse(testList.contains(1));
        assertFalse(testList.contains(2));
        assertFalse(testList.contains(3));
    }

    @Test
    @DisplayName("Should return the first element of the list")
    void first1() {
        MyDoublyLinkedList<Integer> testList = new MyDoublyLinkedList<>();
        testList.add(0);
        testList.add(1);
        testList.add(2);

        assertEquals((Integer) 0, testList.first());
    }

    @Test
    @DisplayName("Should throw an NoSuchElementException if the element does not exist")
    void first2() {
        MyDoublyLinkedList<Integer> testList = new MyDoublyLinkedList<>();

        Throwable exception = assertThrows(NoSuchElementException.class, testList::first);
        assertEquals("The list contains no elements", exception.getMessage());
    }

    @Test
    @DisplayName("Should return the last element of the list")
    void last1() {
        MyDoublyLinkedList<Integer> testList = new MyDoublyLinkedList<>();
        testList.add(0);
        testList.add(1);
        testList.add(2);

        assertEquals((Integer) 2, testList.last());
    }

    @Test
    @DisplayName("Should throw an NoSuchElementException if the element does not exist")
    void last2() {
        MyDoublyLinkedList<Integer> testList = new MyDoublyLinkedList<>();

        Throwable exception = assertThrows(NoSuchElementException.class, testList::last);
        assertEquals("The list contains no elements", exception.getMessage());
    }

    @Test
    @DisplayName("Should return a sublist of given indices")
    void sublist1() {
        MyDoublyLinkedList<Integer> testList = new MyDoublyLinkedList<>();
        MyDoublyLinkedList<Integer> expectedItemTestList = new MyDoublyLinkedList<>();
        testList.add(0);
        testList.add(1);
        testList.add(2);
        testList.add(3);
        testList.add(4);
        expectedItemTestList.add(1);
        expectedItemTestList.add(2);
        expectedItemTestList.add(3);

        assertEquals(expectedItemTestList, testList.sublist(1, 3));
        assertEquals(3, testList.sublist(1, 3).size());
    }

    @Test
    @DisplayName("Should throw an IndexOutOfBoundsException if the index out of bounds")
    void sublist2() {
        MyDoublyLinkedList<Integer> testList = new MyDoublyLinkedList<>();
        testList.add(0);

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
        MyDoublyLinkedList<Integer> testList1 = new MyDoublyLinkedList<>();
        MyDoublyLinkedList<Integer> testList2 = new MyDoublyLinkedList<>();
        testList1.add(0);
        testList1.add(1);
        testList1.add(2);
        testList2.add(null);

        assertEquals(3, testList1.size());
        assertEquals(1, testList2.size());
    }

    @Test
    @DisplayName("Should return a string with all list elements or \"[(this Collection)]\" instead of the item " +
            "if it contains the collection itself")
    void toStringTest() {
        MyDoublyLinkedList<Integer> testList1 = new MyDoublyLinkedList<>();
        MyDoublyLinkedList<MyDoublyLinkedList> testList2 = new MyDoublyLinkedList<>();
        String expectedItemTestList1 = "[0, 1, 2, 3]";
        String expectedItemTestList2 = "[(this Collection)]";
        testList1.add(0);
        testList1.add(1);
        testList1.add(2);
        testList1.add(3);
        testList2.add(testList2);

        assertEquals(expectedItemTestList1, testList1.toString());
        assertEquals(expectedItemTestList2, testList2.toString());
    }
}