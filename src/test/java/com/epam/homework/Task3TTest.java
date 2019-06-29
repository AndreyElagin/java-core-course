package com.epam.homework;

import lombok.EqualsAndHashCode;
import lombok.Value;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static java.lang.System.lineSeparator;
import static java.util.stream.Collectors.joining;

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
@SuppressWarnings("SameParameterValue")
class Task3TTest extends _$AbstractConsoleTask {

    Task3TTest() {
        super("com.epam.homework.Task3");
    }

    /**
     * Одна строка.
     */
    @Test
    void test1() {
        test(new String[]{
                "_______8",
        }, new String[0], 8);
    }

    private void test(String[] original, String[] expected, int expectedAverage) {
        test(original, original.length, expected, expectedAverage);
    }
    
    private void test(String[] original, int numberStringToAnalyze, String[] expected, int expectedAverage) {
        test(new _$TestCase(original, expected, numberStringToAnalyze, expectedAverage));
    }
    
    @Value
    @EqualsAndHashCode(callSuper = true)
    private final class _$TestCase extends _$AbstractConsoleTestCase {
        String[] original;
        String[] expected;
        int numberStringToAnalyze;
        int expectedAverage;

        @Override
        String getInput() {
            return String.valueOf(numberStringToAnalyze) + lineSeparator()
                 + String.join(lineSeparator(), original) + lineSeparator();
        }

        @Override
        String getOutput() {
            return "AVERAGE (" + expectedAverage + ")" + lineSeparator()
                 + Arrays.stream(expected)
                         .limit(numberStringToAnalyze)
                         .map(line -> "(" + line.length() + "): " + line)
                         .collect(joining(lineSeparator()))
                         .concat(lineSeparator());
        }
    }
}
