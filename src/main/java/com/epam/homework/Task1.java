package com.epam.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


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

        final String EXIT_COMMAND = "exit";

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //System.out.println("Enter the number of lines (from 0 to 100), or '" + EXIT_COMMAND + "' to quit");

        String numberOfLinesString = br.readLine();
        Integer numberOfLines = Integer.valueOf(numberOfLinesString);

        String[] inputLinesArr = new String[numberOfLines];

        //System.out.println("Enter " + numberOfLines + " lines to compare, or '" + EXIT_COMMAND + "' to quit");

        for (int i = 0; i < numberOfLines; i++) {
            String currentLine = br.readLine();
            inputLinesArr[i] = currentLine;
        }

        for (int i = inputLinesArr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (inputLinesArr[j].length() > inputLinesArr[j + 1].length()) {
                    String tmp = inputLinesArr[j];
                    inputLinesArr[j] = inputLinesArr[j + 1];
                    inputLinesArr[j + 1] = tmp;
                }
            }
        }

        String minString = inputLinesArr[0];
        String maxString = inputLinesArr[numberOfLines - 1];
        int minLength = inputLinesArr[0].length();
        int maxLength = inputLinesArr[numberOfLines - 1].length();

        System.out.println("MIN (" + minLength + "): " + minString);
        System.out.println("MAX (" + maxLength + "): " + maxString);
    }


}
