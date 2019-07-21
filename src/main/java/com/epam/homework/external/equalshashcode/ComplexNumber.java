package com.epam.homework.external.equalshashcode;

import java.lang.Double;

public final class ComplexNumber {
    private final double re;
    private final double im;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (getClass() != o.getClass()) {
            return false;
        }
        ComplexNumber other = (ComplexNumber) o;
        if (re != other.re) {
            return false;
        }
        if (im != other.im) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        int hashRe = Double.hashCode(re);
        int hashIm = Double.hashCode(im);
        result = prime * result + hashRe;
        result = prime * result + hashIm;
        return result;
    }

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
}