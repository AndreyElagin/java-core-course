package com.epam.homework.external.sqrtThrowingException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SqrtTest {

    @Test
    @DisplayName("If argument is negative should return an IllegalArgumentException")
    void sqrt1() {
        double x = -12.0;
        IllegalArgumentException thrown =
                assertThrows(IllegalArgumentException.class,
                        () -> SqrtThrowingException.sqrt(x),
                        "Expected non-negative number, got -12.0");

        assertTrue(thrown.getMessage().contains("Expected non-negative number, got -12.0"));
    }

    @Test
    @DisplayName("If argument is positive or zero should return the correct result")
    void sqrt2() {
        double x1 = 10.89;
        double x2 = 0.0;
        assertEquals(SqrtThrowingException.sqrt(x1), Math.sqrt(x1));
        assertEquals(SqrtThrowingException.sqrt(x2), Math.sqrt(x2));
    }
}