package com.epam.homework.external.equalshashcode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComplexNumberTest {
    ComplexNumber a = new ComplexNumber(1, 1);
    ComplexNumber b = new ComplexNumber(1, 1);
    ComplexNumber c = new ComplexNumber(1, 1);
    Object d = a;
    ComplexNumber e = new ComplexNumber(2, 2);

    @Test
    @DisplayName("Reflexivity of method equals()")
    void equals1() {
        assertTrue(a.equals(a));
    }

    @Test
    @DisplayName("Symmetry of method equals()")
    void equals2() {
        assertTrue(a.equals(b) && b.equals(a));
    }

    @Test
    @DisplayName("Transitivity of method equals()")
    void equals3() {
        assertTrue(a.equals(b) && b.equals(c) && c.equals(a));
    }

    @Test
    @DisplayName("Consistency of method equals()")
    void equals4() {
        assertTrue(a.equals(b) == a.equals(b));
    }

    @Test
    @DisplayName("Null comparison of method equals()")
    void equals5() {
        assertFalse(a.equals(null));
    }

    @Test
    @DisplayName("Equality of hash-codes called on the one object")
    void hashCode1() {
        assertTrue(a.hashCode() == a.hashCode());
    }

    @Test
    @DisplayName("Equality of hash-codes called on the two same objects")
    void hashCode2() {
        assertTrue(a.hashCode() == d.hashCode());
    }

    @Test
    @DisplayName("Equality of hash-codes called on the two different objects")
    void hashCode3() {
        assertFalse(a.hashCode() == e.hashCode());
    }
}