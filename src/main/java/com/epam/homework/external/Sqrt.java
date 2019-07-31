package com.epam.homework.external;

public class Sqrt {
    public static double sqrt(double x) {
        if(x < 0) {
            throw new IllegalArgumentException("Expected non-negative number, got " + x);
        }
        return Math.sqrt(x);
    }
}
