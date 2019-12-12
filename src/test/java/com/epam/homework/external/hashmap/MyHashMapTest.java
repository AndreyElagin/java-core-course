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
        Integer expectedResult4 = 1234;
        Integer expectedResult5 = 1234567;
        Integer expectedResult6 = null;
        int expectedSize1 = 2;
        int expectedSize2 = 3;

        testHashMap.put("Watermelon", 14);
        testHashMap.put(null, 100);

        assertEquals(expectedResult1, testHashMap.get("Watermelon"));
        assertEquals(expectedResult2, testHashMap.get(null));
        assertEquals(expectedSize1, testHashMap.size());

        testHashMap.put("Watermelon", 10);
        assertEquals(expectedResult3, testHashMap.get("Watermelon"));

        testHashMap.put(null, 1234);
        assertEquals(expectedResult4, testHashMap.get(null));

        testHashMap.put(null, 1234567);
        assertEquals(expectedResult5, testHashMap.get(null));
        assertEquals(expectedSize1, testHashMap.size());

        testHashMap.put("Mango", null);
        assertEquals(expectedResult6, testHashMap.get("Mango"));
        assertEquals(expectedSize2, testHashMap.size());
    }

    @Test
    void remove() {
        MyHashMap<String, Integer> testHashMap = new MyHashMap<>();
        MyHashMap<String, Integer> expectedHashMap = new MyHashMap<>();
        int expectedSize = 2;

        testHashMap.put("Watermelon", 14);
        testHashMap.put("Lemon", 2);
        testHashMap.put("Potato", 123);
        testHashMap.put("Mango", null);
        expectedHashMap.put("Watermelon", 14);
        expectedHashMap.put("Potato", 123);

        testHashMap.remove("Lemon");
        testHashMap.remove("Mango");

        assertEquals(expectedHashMap, testHashMap);
        assertEquals(expectedSize, testHashMap.size());

        testHashMap.put(null, 100);
        testHashMap.remove(null);

        assertEquals(expectedHashMap, testHashMap);
        assertEquals(expectedSize, testHashMap.size());

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
        int expectedSize = 2;

        testHashMap.put("Watermelon", 14);
        testHashMap.put(null, 100);
        testHashMap.replace("Watermelon", 2);
        expectedHashMap.put("Watermelon", 2);
        expectedHashMap.put(null, 100);

        assertEquals(expectedHashMap, testHashMap);
        assertEquals(expectedSize, testHashMap.size());

        testHashMap.replace(null, 1);
        expectedHashMap.put(null, 555);

        assertTrue(testHashMap.replace(null, 555));
        assertEquals(expectedHashMap, testHashMap);
        assertEquals(expectedSize, testHashMap.size());
    }

    @Test
    void size() {
        MyHashMap<String, Integer> testHashMap = new MyHashMap<>();
        int expectedResult = 2;

        testHashMap.put("Watermelon", 14);
        testHashMap.put("Watermelon", 16);
        testHashMap.put(null, 100);
        testHashMap.put(null, 123);
        testHashMap.put(null, 12356);

        assertEquals(expectedResult, testHashMap.size());
    }
}