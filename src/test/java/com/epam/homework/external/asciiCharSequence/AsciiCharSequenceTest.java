package com.epam.homework.external.asciiCharSequence;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AsciiCharSequenceTest {

    @Test
    @DisplayName("Must determine the length of AsciiCharSequence")
    void length() {
        byte[] input1 = {'c', 'h', 'e', 'c', 'k'};
        byte[] input2 = {};
        AsciiCharSequence instance1 = new AsciiCharSequence(input1);
        AsciiCharSequence instance2 = new AsciiCharSequence(input2);
        assertEquals(5, instance1.length());
        assertEquals(0, instance2.length());
    }

    @Test
    @DisplayName("Must return symbol by index of AsciiCharSequence")
    void charAt() {
        byte[] input = {'c', 'h', 'e', 'c', 'k'};
        AsciiCharSequence instance = new AsciiCharSequence(input);
        char returnSymbol = 'c';
        assertEquals(instance.charAt(0), returnSymbol);
    }

    @Test
    @DisplayName("Must return the part of AsciiCharSequence specified by the indices")
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