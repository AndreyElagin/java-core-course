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
        }, 1, new String[]{
                "_________________________27"
        });
    }

    /**
     * Тест из условия задачи (4 строки, порядок вывода: 4, 1, 3, 2)
     */
    @Test
    void test2() {
        test(new String[]{
                "Тихо струится река серебристая", "В царстве вечернем зеленой весны.",
                "Солнце садится за горы лесистые.", "Рог золотой выплывает луны."
        }, 4, new String[]{
                "Рог золотой выплывает луны.", "Тихо струится река серебристая",
                "Солнце садится за горы лесистые.", "В царстве вечернем зеленой весны."
        });
    }

    /**
     * Тест на числа разной разрядности (ввожу 4 строки, ожидаю порядок вывода: 4, 3, 2, 1)
     */
    @Test
    void test3() {
        test(new String[]{
                "3333", "444", "11", "2"
        }, 4, new String[]{
                "2", "11", "444", "3333"
        });
    }

    /**
     * Тест на числа одинаковой разрядности (ввожу 4 строки, ожидаю порядок вывода: 4, 3, 2, 1)
     */
    @Test
    void test4() {
        test(new String[]{
                "444", "333", "222", "111"
        }, 4, new String[]{
                "111", "222", "333", "444"
        });
    }

    /**
     * Тест на строки одинаковой длины (ввожу 3 строки, ожидаю порядок вывода: 3, 1, 2)
     */
    @Test
    void test5() {
        test(new String[]{
                "gable", "table", "apple"
        }, 3, new String[]{
                "apple", "gable", "table"
        });
    }

    /**
     * Тест на пустые строки (ввожу 3 пустые строки, ожидаю отработку теста без ошибки)
     */
    @Test
    void test6() {
        test(new String[]{
                "", "", ""
        }, 3, new String[]{
                "", "", ""
        });
    }

    /**
     * Тест на 15 строк (ввожу 15 строк, ожидаю обратный порядок вывода)
     */
    @Test
    void test7() {
        test(new String[]{
                "123456789012345", "12345678901234", "1234567890123", "123456789012", "12345678901", "1234567890",
                "123456789", "12345678", "1234567", "123456", "12345", "1234", "123", "12", "1"
        }, 15, new String[]{
                "1", "12", "123", "1234", "12345", "123456", "1234567", "12345678", "123456789", "1234567890",
                "12345678901", "123456789012", "1234567890123", "12345678901234", "123456789012345"
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
