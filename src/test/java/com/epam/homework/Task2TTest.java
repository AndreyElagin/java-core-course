package com.epam.homework;

import lombok.EqualsAndHashCode;
import lombok.Value;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static java.lang.System.lineSeparator;
import static java.util.stream.Collectors.joining;

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
@SuppressWarnings("SameParameterValue")
class Task2TTest extends _$AbstractConsoleTask {

    Task2TTest() {
        super("com.epam.homework.Task2");
    }

    /**
     * Одна строка.
     */
    @Test
    void test1() {
        test(new String[]{
                "_________________________27"
        }, new String[]{
                "_________________________27"
        });
    }

    private void test(String[] original, String[] sorted) {
        test(original, original.length, sorted);
    }
    
    private void test(String[] original, int numberStringToAnalyze, String[] sorted) {
        test(new _$TestCase(original, sorted, numberStringToAnalyze));
    }
    
    @Value
    @EqualsAndHashCode(callSuper = true)
    private final class _$TestCase extends _$AbstractConsoleTestCase {
        String[] original;
        String[] sorted;
        int numberStringToAnalyze;

        @Override
        String getInput() {
            return String.valueOf(numberStringToAnalyze) + lineSeparator()
                 + String.join(lineSeparator(), original) + lineSeparator();
        }

        @Override
        String getOutput() {
            return Arrays.stream(sorted)
                         .limit(numberStringToAnalyze)
                         .map(line -> "(" + line.length() + "): " + line)
                         .collect(joining(lineSeparator()))
                         .concat(lineSeparator());
        }
    }
}
