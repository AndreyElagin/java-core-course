package com.epam.homework.external;

public class AsciiCharSequence implements CharSequence {
    private byte[] inputCharacterSet;

    public AsciiCharSequence(byte[] input) {
        this.inputCharacterSet = input.clone();
    }

    public static void main(String[] args) {
        byte[] input = {99, 104, 101, 99, 107};
        AsciiCharSequence zbc = new AsciiCharSequence(input);
        System.out.println(zbc);
        System.out.println(zbc.charAt(0));
        System.out.println(zbc.subSequence(2,4));
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
}
