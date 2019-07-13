package com.epam.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task3 {

    /**
     * Ввести N строк с консоли.
     * Вывести те строки, длина которых меньше средней.
     * Под 'средней' подразумевается среднеарифметическая величина длины всех строк, округленная до целого в меньшую сторону.
     *
     * Формат входных данных:
     * N (целое число) - количество доступных для чтения строк
     * N строк
     *
     * Формат выходных данных:
     * В результате выполнения в выходной поток должна быть выведена средняя длина (округленная до целого в меньшую сторону) и строки, удовлетворяющие условию.
     * Порядок появления строк в выходном потоке должен совпадать с порядком их появления во входном.
     *
     * AVERAGE (средняя длина)
     * (длина строки): строка с длиной меньше средней
     * ...
     * (длина строки): строка с длиной меньше средней
     *
     * ------------------------------------------------------------------------------------------------
     * Пример выполнения задания:
     *
     * Входные данные:
     * 5
     * Послушайте!
     * Ведь, если звезды зажигают -
     * Значит - это кому-нибудь нужно?
     * Значит - кто-то хочет, чтобы они были?
     * Значит - кто-то называет эти плевочки жемчужиной?
     *
     * Выходные данные:
     * AVERAGE (31)
     * (11): Послушайте!
     * (28): Ведь, если звезды зажигают -
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String numberOfLinesString = br.readLine();
        if (isExitCommand(numberOfLinesString)) {
            return;
        }

        String[] inputLinesArr = readConsoleInput(numberOfLinesString, br);

        int averageLength = getSumLength(inputLinesArr) / inputLinesArr.length;

        System.out.println("AVERAGE (" + averageLength + ")");
        for (String current : inputLinesArr
        ) {
            if (current.length() < averageLength) {
                System.out.println("(" + current.length() + "): " + current);
            }
        }
    }

    private static String[] readConsoleInput(String numberOfLinesString,
                                             BufferedReader br) throws IOException {
        int numberOfLines = Integer.valueOf(numberOfLinesString);
        String[] inputLinesArr = new String[numberOfLines];

        for (int i = 0; i < numberOfLines; i++) {
            String currentLine = br.readLine();
            if (isExitCommand(currentLine)) {
                break;
            }
            inputLinesArr[i] = currentLine;
        }
        return inputLinesArr;
    }

    private static boolean isExitCommand(String exitPoint) {
        if ("exit".equals(exitPoint.toLowerCase())) {
            System.out.println("Exiting");
            return true;
        }
        return false;
    }

    private static int getSumLength(String[] inputLinesArr) {
        int sumLength = 0;
        for (String s : inputLinesArr) {
            sumLength += s.length();
        }
        return sumLength;
    }
}