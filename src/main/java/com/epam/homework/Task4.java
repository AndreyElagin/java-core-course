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

        String wordMinUniqueChars = getWordMinUniqueChars(words);
        System.out.println(wordMinUniqueChars);
    }

    private static boolean isExitCommand(String exitPoint) {
        return "exit".equals(exitPoint.toLowerCase());
    }

    private static String getWordMinUniqueChars(String[] words) {
        String wordMinUniqueChars = words[0];
        int minNumUniqueChars = unique(words[0]);

        for (int i = 1; i < words.length; i++) {
            int numUniqueChars = unique(words[i]);
            if (numUniqueChars < minNumUniqueChars) {
                minNumUniqueChars = numUniqueChars;
                wordMinUniqueChars = words[i];
            }
        }
        return wordMinUniqueChars;
    }

    private static int unique(String word) {
        boolean[] flags = new boolean[256];
        int counter = 0;

        for (int i = 0; i < word.length(); i++) {
            int ascii = (int) word.charAt(i);
            if (!flags[ascii]) {
                counter++;
                flags[ascii] = true;
            }
        }
        return counter;
    }
}