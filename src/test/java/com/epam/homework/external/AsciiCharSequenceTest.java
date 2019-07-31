package com.epam.homework.external;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AsciiCharSequenceTest {

    @Test
    @DisplayName("Must determine the length of the object type AsciiCharSequence")
    void length() {
        byte[] input = {'c', 'h', 'e', 'c', 'k'};
        AsciiCharSequence instance = new AsciiCharSequence(input);
        assertTrue(instance.length() == 5);
    }

    @Test
    @DisplayName("Must return symbol by index of the object type AsciiCharSequence")
    void charAt() {
        byte[] input = {'c', 'h', 'e', 'c', 'k'};
        AsciiCharSequence instance = new AsciiCharSequence(input);
        char returnSymbol = 'c';
        assertTrue(instance.charAt(0) == returnSymbol);
    }

    @Test
    @DisplayName("Must return the part of the object type AsciiCharSequence specified part of the index")
    void subSequence() {
        byte[] input = {'c', 'h', 'e', 'c', 'k'};
        AsciiCharSequence instance = new AsciiCharSequence(input);
        byte[] output = {'e', 'c'};
        AsciiCharSequence result = new AsciiCharSequence(output);
        assertEquals(instance.subSequence(2, 4), result);
    }

    @Test
    @DisplayName("Should return a string")
    void toString1() {
        byte[] input = {'c', 'h', 'e', 'c', 'k'};
        AsciiCharSequence instance = new AsciiCharSequence(input);
        String output = "check";
        assertEquals(instance.toString(), output);
    }
}