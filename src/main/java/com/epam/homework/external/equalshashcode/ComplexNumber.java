package com.epam.homework.external.equalshashcode;

import java.lang.Double;

public final class ComplexNumber {
    private final double re;
    private final double im;

    public ComplexNumber(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ComplexNumber other = (ComplexNumber) o;
        if (re != other.re || im != other.im) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + Double.hashCode(re);
        result = 31 * result + Double.hashCode(im);
        return result;
    }
}