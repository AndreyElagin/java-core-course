package com.epam.homework.external.arraylist;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("unchecked")
class MyArrayListTest {

    @Test
    @DisplayName("Should add an element to MyArrayList at 0 index")
    void testAdd() {
        MyArrayList<Integer> testList = new MyArrayList();
        Integer element = 1;

        testList.add(element);

        assertEquals(testList.get(0), element);
    }

    @Test
    @DisplayName("Should remove an element from MyArrayList by index")
    void testRemove() {
        MyArrayList<Integer> testList = new MyArrayList();
        int index = 0;

        testList.add(0);
        testList.add(1);
        testList.remove(index);

        assertEquals(testList.get(0), (Integer) 1);
    }

    @Test
    @DisplayName("Should return true if MyArrayList contains an element, or false if it does not contain")
    void testContains() {
        MyArrayList<Integer> testList = new MyArrayList();
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
    @DisplayName("Should return an element from MyArrayList by index")
    void testGet() {
        MyArrayList<String> testList = new MyArrayList();

        testList.add("Test");
        assertEquals("Test", testList.get(0));
    }

    @Test
    @DisplayName("Should delete all elements from MyArrayList")
    void testClear() {
        MyArrayList<Integer> testList = new MyArrayList();

        testList.add(0);
        testList.add(1);
        testList.add(2);
        testList.add(3);
        testList.add(4);

        testList.clear();

        assertNull(testList.get(1));
        assertNull(testList.get(3));
    }

    @Test
    @DisplayName("Should return current value of MyArrayList size")
    void testSize() {
        MyArrayList<Integer> testList = new MyArrayList();

        testList.add(0);
        assertEquals(testList.size(), 1);
        testList.add(1);
        assertEquals(testList.size(), 2);
        testList.add(2);
        assertEquals(testList.size(), 3);
    }

}