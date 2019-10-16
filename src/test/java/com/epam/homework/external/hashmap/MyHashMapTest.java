package com.epam.homework.external.hashmap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

        testHashMap.remove("Lemon");

        assertEquals(expectedHashMap, testHashMap);

        testHashMap.put(null, 100);
        testHashMap.remove(null);

        assertEquals(expectedHashMap, testHashMap);

        assertNull(testHashMap.remove(null));
    }

    @Test
    void contains() {
        MyHashMap<String, Integer> testHashMap = new MyHashMap<>();

        testHashMap.put("Watermelon", 14);
        testHashMap.put(null, 100);

        assertTrue(testHashMap.contains("Watermelon"));
        assertTrue(testHashMap.contains(null));
        assertFalse(testHashMap.contains("Lemon"));
    }

    @Test
    void get() {
        MyHashMap<String, Integer> testHashMap = new MyHashMap<>();
        Integer expectedResult1 = 14;
        Integer expectedResult2 = 100;

        testHashMap.put("Watermelon", 14);
        testHashMap.put(null, 100);

        assertEquals(expectedResult1, testHashMap.get("Watermelon"));
        assertEquals(expectedResult2, testHashMap.get(null));
    }

    @Test
    void clear() {
        MyHashMap<String, Integer> testHashMap = new MyHashMap<>();
        MyHashMap<String, Integer> expectedHashMap = new MyHashMap<>();

        testHashMap.put("Watermelon", 14);
        testHashMap.put(null, 100);

        testHashMap.clear();

        assertEquals(expectedHashMap, testHashMap);
    }

    @Test
    void replace() {
        MyHashMap<String, Integer> testHashMap = new MyHashMap<>();
        MyHashMap<String, Integer> expectedHashMap = new MyHashMap<>();

        testHashMap.put("Watermelon", 14);
        testHashMap.put(null, 100);
        testHashMap.replace("Watermelon", 2);
        expectedHashMap.put("Watermelon", 2);
        expectedHashMap.put(null, 100);

        assertEquals(expectedHashMap, testHashMap);

        testHashMap.replace(null, 1);
        expectedHashMap.put(null, 1);

        assertTrue(testHashMap.replace(null, 555));

        expectedHashMap.put(null, 555);

        assertEquals(expectedHashMap, testHashMap);
    }

    @Test
    void size() {
        MyHashMap<String, Integer> testHashMap = new MyHashMap<>();
        int expectedResult = 2;

        testHashMap.put("Watermelon", 14);
        testHashMap.put("Watermelon", 16);
        testHashMap.put(null, 100);
        testHashMap.put(null, 123);

        assertEquals(expectedResult, testHashMap.size());
    }
}