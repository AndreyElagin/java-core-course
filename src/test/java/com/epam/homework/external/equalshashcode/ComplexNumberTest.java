package com.epam.homework.external.equalshashcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComplexNumberTest {
    @Test
    @DisplayName("Equals method should be reflexive")
    void equals1() {
        ComplexNumber a = new ComplexNumber(1, 1);
        assertTrue(a.equals(a));
    }

    @Test
    @DisplayName("Equals method should be symmetry")
    void equals2() {
        ComplexNumber a = new ComplexNumber(1, 1);
        ComplexNumber b = new ComplexNumber(1, 1);
        assertTrue(a.equals(b) && b.equals(a));
    }

    @Test
    @DisplayName("Equals method should be transitivity")
    void equals3() {
        ComplexNumber a = new ComplexNumber(1, 1);
        ComplexNumber b = new ComplexNumber(1, 1);
        ComplexNumber c = new ComplexNumber(1, 1);
        assertTrue(a.equals(b) && b.equals(c) && c.equals(a));
    }

    @Test
    @DisplayName("Equals method should be сonsistent")
    void equals4() {
        ComplexNumber a = new ComplexNumber(1, 1);
        ComplexNumber b = new ComplexNumber(1, 1);
        assertTrue(a.equals(b) == a.equals(b));
    }

    @Test
    @DisplayName("Null comparison of method equals")
    void equals5() {
        ComplexNumber a = new ComplexNumber(1, 1);
        assertFalse(a.equals(null));
    }

    @Test
    @DisplayName("Hash codes calculated for a single object should be equal")
    void hashCode1() {
        ComplexNumber a = new ComplexNumber(1, 1);
        assertTrue(a.hashCode() == a.hashCode());
    }

    @Test
    @DisplayName("Hash codes calculated for two identical objects should be equal")
    void hashCode2() {
        ComplexNumber a = new ComplexNumber(1, 1);
        Object d = a;
        assertTrue(a.hashCode() == d.hashCode());
    }

    @Test
    @DisplayName("Hash codes calculated for two different objects should be different")
    void hashCode3() {
        ComplexNumber a = new ComplexNumber(1, 1);
        ComplexNumber e = new ComplexNumber(2, 2);
        assertFalse(a.hashCode() == e.hashCode());
    }

    @Test
    @DisplayName("Hash codes calculated for two identical objects should be equal")
    void equalsAndHashCode() {
        int min = 0;
        int max = 100;
        int re = (int) (min - 0.5 + Math.random() * (max - min + 1));
        int im = (int) (min - 0.5 + Math.random() * (max - min + 1));
        ComplexNumber a = new ComplexNumber(re, im);
        ComplexNumber b = new ComplexNumber(re, im);
        assertTrue(a.hashCode() == b.hashCode());
    }
}