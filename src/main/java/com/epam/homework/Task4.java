package com.epam.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

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
        String numberOfLinesString = br.readLine();
        if (isExitCommand(numberOfLinesString)) {
            return;
        }

        int numberOfLines = Integer.valueOf(numberOfLinesString);
        String currentLine = br.readLine();
        if (isExitCommand(currentLine)) {
            return;
        }

        String[] inputLinesArr = currentLine.split(" ", numberOfLines);
        String wordWithMinimalNumDiffLetters = getWordWithMinimalNumDiffLetters(inputLinesArr);
        System.out.println(wordWithMinimalNumDiffLetters);
    }

    private static boolean isExitCommand(String exitPoint) {
        if ("exit".equals(exitPoint.toLowerCase())) {
            System.out.println("Exiting");
            return true;
        }
        return false;
    }

    private static String getWordWithMinimalNumDiffLetters(String[] inputLinesArr) {
        int minIndex = 0;
        int minLength = 99999;

        for (int i = 0; i < inputLinesArr.length; i++) {
            char[] currentWordToArray = inputLinesArr[i].toCharArray();

            for (int j = 0; j < currentWordToArray.length - 1; j++) {
                for (int k = j + 1; k < currentWordToArray.length; k++) {
                    if (currentWordToArray[j] == currentWordToArray[k]) {
                        currentWordToArray[k] = 0;
                    }
                }
            }

            int countDifferentLetter = 0;

            for (int j = 0; j < currentWordToArray.length; j++) {
                if (currentWordToArray[j] != 0) {
                    countDifferentLetter += 1;
                }
            }

            char[] differentsLetterArray = new char[countDifferentLetter];
            int count = 0;

            for (int j = 0; j < currentWordToArray.length; j++) {
                if (currentWordToArray[j] != 0) {
                    differentsLetterArray[count] = currentWordToArray[j];
                    count += 1;
                }
            }

            if (differentsLetterArray.length < minLength) {
                minLength = differentsLetterArray.length;
                minIndex = i;
            }
        }
        return inputLinesArr[minIndex];
    }
}