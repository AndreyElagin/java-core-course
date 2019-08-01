package com.epam.homework.external.asciiCharSequence;

import java.util.Arrays;

public class AsciiCharSequence implements CharSequence {
    private byte[] inputCharacterSet;

    AsciiCharSequence(byte[] input) {
        this.inputCharacterSet = input.clone();
    }

    @Override
    public int length() {
        return inputCharacterSet.length;
    }

    @Override
    public char charAt(int index) {
        return (char) inputCharacterSet[index];
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        int lengthSubSeq = end - start;
        byte[] subSeq = new byte[lengthSubSeq];
        for (int i = start, j = 0; i < end; i++, j++) {
            subSeq[j] = inputCharacterSet[i];
        }
        return new AsciiCharSequence(subSeq);
    }

    @Override
    public String toString() {
        return new String(inputCharacterSet);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AsciiCharSequence that = (AsciiCharSequence) o;
        return Arrays.equals(inputCharacterSet, that.inputCharacterSet);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(inputCharacterSet);
    }
}
