package com.epam.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Task2 {

    /**
     * Ввести N строк с консоли.
     * Упорядочить и вывести строки в порядке возрастания значений их длины.
     * В случае, если длины строк совпадают - упорядочить их в лексикографическом порядке.
     *
     * Формат входных данных:
     * N (целое число, 0 < N < 100) - количество доступных для чтения строк
     * Строка_1
     * Строка_2
     * ...
     * Строка_N
     *
     * Формат выходных данных:
     * В результате выполнения в выходной поток должны быть выведены N строк следующего вида:
     * (длина строки): строка наименьшей длины
     * (длина строки): строка большей длины
     * (длина строки): строка большей длины
     * ...
     * (длина строки): строка наибольшей длины
     *
     * ----------------------------------------------------------------------------------------------
     * Пример выполнения задания:
     *
     * Входные данные:
     * 4
     * Тихо струится река серебристая
     * В царстве вечернем зеленой весны.
     * Солнце садится за горы лесистые.
     * Рог золотой выплывает луны.
     *
     * Выходные данные:
     * (27): Рог золотой выплывает луны.
     * (30): Тихо струится река серебристая
     * (32): Солнце садится за горы лесистые.
     * (33): В царстве вечернем зеленой весны.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String numberOfLinesString = br.readLine();
        if (isExitCommand(numberOfLinesString)) {
            return;
        }

        String[] inputLinesArr = readConsoleInput(numberOfLinesString, br);

        if (inputLinesArr[Integer.valueOf(numberOfLinesString) - 1] != null) {
            insertSort(inputLinesArr);
            for (String current : inputLinesArr) {
                System.out.println("(" + current.length() + "): " + current);
            }
        }
    }

    private static boolean isExitCommand(String exitPoint) {
        return "exit".equals(exitPoint.toLowerCase());
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

    private static void insertSort(String[] array) {
        Comparator<String> instance = LengthComparator.getInstance();
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (instance.compare(array[i], array[j]) > 0) {
                    String temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }
    }
}

class LengthComparator implements Comparator<String> {
    private static LengthComparator instance = new LengthComparator();

    public static LengthComparator getInstance() {
        if (instance == null) {
            instance = new LengthComparator();
        }
        return instance;
    }

    public int compare(String first, String second) {
        if (Integer.compare(first.length(), second.length()) != 0) {
            return Integer.compare(first.length(), second.length());
        } else {
            return first.compareTo(second);
        }
    }
}