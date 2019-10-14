package com.epam.homework.external.hashmap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyHashMapTest {

    @Test
    void put() {
        MyHashMap<String, Integer> testHashMap = new MyHashMap<>();
        Integer expectedResult1 = 14;
        Integer expectedResult2 = 100;
        Integer expectedResult3 = 10;

        testHashMap.put("Watermelon", 14);
        testHashMap.put(null, 100);

        assertEquals(expectedResult1, testHashMap.get("Watermelon"));
        assertEquals(expectedResult2, testHashMap.get(null));

        testHashMap.put("Watermelon", 10);
        assertEquals(expectedResult3, testHashMap.get("Watermelon"));
    }

    @Test
    void remove() {
        MyHashMap<String, Integer> testHashMap = new MyHashMap<>();
        MyHashMap<String, Integer> expectedHashMap = new MyHashMap<>();

        testHashMap.put("Watermelon", 14);
        testHashMap.put("Lemon", 2);
        testHashMap.put("Potato", 123);
        expectedHashMap.put("Watermelon", 14);
        expectedHashMap.put("Potato", 123);
        System.out.println(testHashMap.toString());
        System.out.println(expectedHashMap.toString());
        testHashMap.remove("Lemon");

        assertEquals(expectedHashMap, testHashMap);
    }

    @Test
    void contains() {
        MyHashMap<String, Integer> testHashMap = new MyHashMap<>();

        testHashMap.put("Watermelon", 14);
        testHashMap.put(null, 100);

        assertTrue(testHashMap.contains("Watermelon"));
        assertTrue(testHashMap.contains(null));
        System.out.println(testHashMap.get(null));
        assertFalse(testHashMap.contains("Lemon"));
    }

    @Test
    void get() {
    }

    @Test
    void clear() {

    }

    @Test
    void replace() {
    }

    @Test
    void size() {
    }
}