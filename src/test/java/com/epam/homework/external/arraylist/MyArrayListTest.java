package com.epam.homework.external.arraylist;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("unchecked")
class MyArrayListTest {
    @Test
    @DisplayName("Should add an element to MyArrayList at 0 index and change size to 1")
    void testAdd() {
        MyArrayList<Integer> testList = new MyArrayList<>();
        Integer element = 1;

        testList.add(element);

        assertEquals(testList.get(0), element);
        assertEquals(testList.size(), 1);
    }

    @Test
    @DisplayName("Should remove an element by index and resize by 1, " +
            "or throw an IllegalArgumentException if the index goes beyond the bounds of the array")
    void testRemove() {
        MyArrayList<Integer> testList = new MyArrayList<>();
        int index = 0;

        testList.add(0);
        testList.add(1);
        testList.remove(index);
        assertEquals(testList.get(0), (Integer) 1);
        assertEquals(testList.size(), 1);

        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            testList.remove(5);
        });
        assertEquals("The entered number goes beyond the bounds of the array", exception.getMessage());
    }

    @Test
    @DisplayName("Should return true if MyArrayList contains an element, or false if it does not contain")
    void testContains() {
        MyArrayList<Integer> testList = new MyArrayList<>();
        Integer element1 = 3;
        Integer element2 = 6;

        testList.add(0);
        testList.add(1);
        testList.add(2);
        testList.add(3);
        testList.add(4);

        assertTrue(testList.contains(element1));
        assertFalse(testList.contains(element2));
    }

    @Test
    @DisplayName("Should return an element by index, " +
            "or throw an IllegalArgumentException if the index goes beyond the bounds of the array")
    void testGet() {
        MyArrayList<String> testList = new MyArrayList<>();

        testList.add("Test");
        assertEquals("Test", testList.get(0));

        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            testList.get(2);
        });
        assertEquals("The entered number goes beyond the bounds of the array", exception.getMessage());
    }

    @Test
    @DisplayName("Should delete all elements from MyArrayList")
    void testClear() {
        MyArrayList<Integer> testList = new MyArrayList<>();

        testList.add(0);
        testList.add(1);
        testList.add(2);
        testList.add(3);
        testList.add(4);
        testList.clear();

        assertEquals(testList.size(), 0);
    }

    @Test
    @DisplayName("Should return current value of MyArrayList size")
    void testSize() {
        MyArrayList<Integer> testList = new MyArrayList<>();

        testList.add(0);
        assertEquals(testList.size(), 1);
        testList.add(1);
        assertEquals(testList.size(), 2);
        testList.add(2);
        assertEquals(testList.size(), 3);
    }

    @Test
    @DisplayName("Should return the next element, or should throw an IllegalArgumentException")
    void testIterator() {
        MyArrayList<Integer> testList = new MyArrayList<>();
        final Iterator<Integer> iterator = testList.iterator();

        testList.add(0);
        testList.add(1);
        assertEquals(iterator.next(), (Integer) 0);
        assertEquals(iterator.next(), (Integer) 1);

        Throwable exception = assertThrows(IllegalArgumentException.class, iterator::next);
        assertEquals("No next item", exception.getMessage());
    }
}