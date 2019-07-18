package com.epam.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task4 {

    /**
     * Ввести с консоли N слов, состоящих из символов английского алфавита.
     * Найти слово, в котором число различных символов минимально.
     * Символы верхнего и нижнего регистра считать различными.
     * Если таких слов несколько, найти первое из них.
     *
     * Формат входных данных:
     * N (целое число) - количество слов в строке
     * Строка, содержащая указанное количество слов, разделенных пробелами
     *
     * Формат выходных данных:
     * В результате выполнения в выходной поток должно быть выведено слово, содержащее наименьшее число различных символов.
     *
     * -------------------------------------------------------------------------------------------
     * Пример выполнения задания:
     *
     * Входные данные:
     * 4
     * Cake is a lie
     *
     * Выходные данные:
     * a
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String enteredNumberOfWords = br.readLine();
        if (isExitCommand(enteredNumberOfWords)) {
            return;
        }

        String rowWords = br.readLine();
        if (isExitCommand(rowWords)) {
            return;
        }

        int numberOfWords = Integer.valueOf(enteredNumberOfWords);
        String[] words = rowWords.split(" ", numberOfWords);

        String wordWithMinimalNumDiffLetters = getWordWithMinimalNumDiffLetters(words);
        System.out.println(wordWithMinimalNumDiffLetters);
    }

    private static boolean isExitCommand(String exitPoint) {
        return "exit".equals(exitPoint.toLowerCase());
    }

    private static String getWordWithMinimalNumDiffLetters(String[] words) {
        int[] theNumberOfUniqueCharsInEachWord = new int[words.length];

        for (int i = 0; i < words.length; i++) {
            theNumberOfUniqueCharsInEachWord[i] = getNumberOfUniqueChars(words[i]);
        }

        int indexWordWithMinimalNumDiffLetters =
                getIndexWordWithMinimalNumDiffLetters(theNumberOfUniqueCharsInEachWord);

        return words[indexWordWithMinimalNumDiffLetters];
    }

    private static int getNumberOfUniqueChars(String currentWord) {
        char[] currentWordInChars = currentWord.toCharArray();
        int numberOfUniqueChars = 0;

        for (int j = 0; j < currentWordInChars.length; j++) {
            boolean triggerUnique = isUniqueChar(currentWordInChars, j);

            if (triggerUnique) {
                numberOfUniqueChars += 1;
            }
        }
        return numberOfUniqueChars;
    }

    private static boolean isUniqueChar(char[] currentWordInChars, int j) {
        boolean triggerUnique = true;

        for (int k = j + 1; k < currentWordInChars.length; k++) {
            if (currentWordInChars[j] == currentWordInChars[k]) {
                triggerUnique = false;
            }
        }
        return triggerUnique;
    }

    private static int getIndexWordWithMinimalNumDiffLetters(int[] theNumberOfUniqueCharsInEachWord) {
        int indexWordWithMinimalNumDiffLetters = 0;
        int minNumberOfUniqueCharacters = 2147483647;

        for (int i = 0; i < theNumberOfUniqueCharsInEachWord.length; i++) {
            if (theNumberOfUniqueCharsInEachWord[i] < minNumberOfUniqueCharacters) {
                minNumberOfUniqueCharacters = theNumberOfUniqueCharsInEachWord[i];
                indexWordWithMinimalNumDiffLetters = i;
            }
        }
        return indexWordWithMinimalNumDiffLetters;
    }
}