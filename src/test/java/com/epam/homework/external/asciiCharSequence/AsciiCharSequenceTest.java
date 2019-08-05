package com.epam.homework.external.asciiCharSequence;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class AsciiCharSequenceTest {

    @Test
    @DisplayName("Should throw an IAE if the argument is null")
    void IAEofArgNull() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            new AsciiCharSequence(null);
        });
        assertEquals("Argument may not be null", exception.getMessage());
    }

    @Test
    @DisplayName("Length of string should correspond to length of basis array")
    void length() {
        byte[] input1 = {'c', 'h', 'e', 'c', 'k'};
        byte[] input2 = {};
        AsciiCharSequence instance1 = new AsciiCharSequence(input1);
        AsciiCharSequence instance2 = new AsciiCharSequence(input2);
        assertEquals(5, instance1.length());
        assertEquals(0, instance2.length());
    }

    @Test
    @DisplayName("Ordinal character of string must match ordinal character of basis array")
    void charAt() {
        byte[] input = {'c', 'h', 'e', 'c', 'k'};
        AsciiCharSequence instance = new AsciiCharSequence(input);
        char[] returnSymbols = {'c', 'h', 'e', 'c', 'k'};
        for (int i = 0; i < returnSymbols.length; i++) {
            assertEquals(instance.charAt(i), returnSymbols[i]);
        }
    }

    @Test
    @DisplayName("Must return the part of string specified by the indices")
    void subSequence() {
        byte[] input = {'c', 'h', 'e', 'c', 'k'};
        AsciiCharSequence instance = new AsciiCharSequence(input);
        AsciiCharSequence instance2 = new AsciiCharSequence(input);
        for (int i = 0; i < input.length; i++) {
            for (int j = i; j < input.length; j++) {
                instance2.setInputCharacterSet(Arrays.copyOfRange(input, i, j));
                assertEquals(instance.subSequence(i, j), instance2);
            }
        }
    }

    @Test
    @DisplayName("Equals method should be reflexive")
    void equals1() {
        byte[] input = {'c', 'h', 'e', 'c', 'k'};
        AsciiCharSequence a = new AsciiCharSequence(input);
        assertEquals(a, a);
    }

    @Test
    @DisplayName("Equals method should be symmetric")
    void equals2() {
        byte[] input = {'c', 'h', 'e', 'c', 'k'};
        AsciiCharSequence a = new AsciiCharSequence(input);
        AsciiCharSequence b = new AsciiCharSequence(input);
        assertTrue(a.equals(b) && b.equals(a));
    }

    @Test
    @DisplayName("Equals method should be transitive")
    void equals3() {
        byte[] input = {'c', 'h', 'e', 'c', 'k'};
        AsciiCharSequence a = new AsciiCharSequence(input);
        AsciiCharSequence b = new AsciiCharSequence(input);
        AsciiCharSequence c = new AsciiCharSequence(input);
        assertTrue(a.equals(b) && b.equals(c) && c.equals(a));
    }

    @Test
    @DisplayName("Equals method should be сonsistent")
    void equals4() {
        byte[] input = {'c', 'h', 'e', 'c', 'k'};
        AsciiCharSequence a = new AsciiCharSequence(input);
        AsciiCharSequence b = new AsciiCharSequence(input);
        assertEquals(a.equals(b), a.equals(b));
    }

    @Test
    @DisplayName("Should always return false when compares with null")
    void equals5() {
        byte[] input = {'c', 'h', 'e', 'c', 'k'};
        AsciiCharSequence a = new AsciiCharSequence(input);
        assertNotEquals(null, a);
    }

    @Test
    @DisplayName("Hash codes calculated for a single object should be equal")
    void hashCode1() {
        byte[] input = {'c', 'h', 'e', 'c', 'k'};
        AsciiCharSequence a = new AsciiCharSequence(input);
        assertEquals(a.hashCode(), a.hashCode());
    }

    @Test
    @DisplayName("Hash codes calculated for two identical objects should be equal")
    void hashCode2() {
        byte[] input = {'c', 'h', 'e', 'c', 'k'};
        AsciiCharSequence a = new AsciiCharSequence(input);
        Object d = a;
        assertEquals(a.hashCode(), d.hashCode());
    }

    @Test
    @DisplayName("Hash codes calculated for two different objects should be different")
    void hashCode3() {
        byte[] input1 = {'c', 'h', 'e', 'c', 'k'};
        AsciiCharSequence a = new AsciiCharSequence(input1);
        byte[] input2 = {'h', 'a', 'l', 'l', 'o'};
        AsciiCharSequence e = new AsciiCharSequence(input2);
        assertFalse(a.hashCode() == e.hashCode());
    }
}