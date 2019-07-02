package com.epam.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task1 {

    /**
     * Ввести N строк с консоли.
     * Найти среди них самую короткую и самую длинную.
     * Вывести найденные строки и их длину.
     * Если строк, удовлетворяющих условию, более одной - вывести последнюю из них.
     * <p>
     * Формат входных данных:
     * N (целое число, 0 < N < 100) - количество доступных для чтения строк
     * Строка_1
     * Строка_2
     * ...
     * Строка_N
     * <p>
     * Формат выходных данных:
     * MIN ($длина_минимальной_строки$): $минимальная_строка$
     * MAX ($длина_максимальной_строки$): $максимальная_строка$
     * <p>
     * -----------------------------------------------------------------------------
     * Пример выполнения задания:
     * <p>
     * Входные данные:
     * 4
     * Унылая пора! Очей очарованье!
     * Приятна мне твоя прощальная краса —
     * Люблю я пышное природы увяданье,
     * В багрец и в золото одетые леса,
     * <p>
     * Выходные данные:
     * MIN (29): Унылая пора! Очей очарованье!
     * MAX (35): Приятна мне твоя прощальная краса —
     */

    public static void main(final String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String numberOfLinesString = br.readLine();
        if (isExitCommand(numberOfLinesString)) return;

        int numberOfLines = Integer.valueOf(numberOfLinesString);
        String[] inputLinesArr = new String[numberOfLines];

        for (int i = 0; i < numberOfLines; i++) {
            String currentLine = br.readLine();
            if (isExitCommand(currentLine)) return;
            inputLinesArr[i] = currentLine;
        }

        int min = inputLinesArr[0].length();
        int indexMin = 0;
        int max = inputLinesArr[0].length();
        int indexMax = 0;

        for (int i = 0; i < inputLinesArr.length; i++) {
            if (inputLinesArr[i].length() < min) {
                min = inputLinesArr[i].length();
                indexMin = i;
            }
            if (inputLinesArr[i].length() > max) {
                max = inputLinesArr[i].length();
                indexMax = i;
            }
        }

        String minString = inputLinesArr[indexMin];
        String maxString = inputLinesArr[indexMax];
        int minLength = inputLinesArr[indexMin].length();
        int maxLength = inputLinesArr[indexMax].length();

        System.out.println("MIN (" + minLength + "): " + minString);
        System.out.println("MAX (" + maxLength + "): " + maxString);
    }

    private static boolean isExitCommand(String exitPoint) {
        final String exitCommand = "exit";
        if (exitPoint.toLowerCase().equals(exitCommand)) {
            System.out.println("Exiting");
            return true;
        }
        return false;
    }
}
