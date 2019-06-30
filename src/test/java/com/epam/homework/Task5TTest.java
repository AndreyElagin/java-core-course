package com.epam.homework;

import lombok.EqualsAndHashCode;
import lombok.Value;
import org.junit.jupiter.api.Test;

import static java.lang.System.lineSeparator;

/**
 * Ввести N слов с консоли.
 * Найти количество слов, содержащих только символы латинского алфавита, а среди них – количество слов с равным числом гласных и согласных букв.
 *
 * Формат входных данных:
 * N (целое число) - количество слов в строке
 * Строка, содержащая указанное количество слов, разделенных пробелами
 *
 * Формат выходных данных:
 * В результате выполнения в выходной поток должно быть выведено количество слов, состоящих только из символов латинского алфавита и содержащих равное количество гласных и согласных букв.
 * Количество различных вхождений одной буквы в слове учитывается.
 *
 * ---------------------------------------------------------------------------------------------------
 * Пример выполнения задания:
 *
 * Входные данные:
 * 5
 * Язык программирования Java is widespread
 *
 * Выходные данные:
 * 2
 */
@SuppressWarnings("SameParameterValue")
class Task5TTest extends _$AbstractConsoleTask {

    Task5TTest() {
        super("com.epam.homework.Task5");
    }

    /**
     * Одно слово удовлетворяющее условию.
     */
    @Test
    void test1() {
        test(new String[]{"ab"}, 1);
    }

    private void test(String[] original, int expectedCount) {
        test(original, expectedCount, original.length);
    }
    
    private void test(String[] original, int expectedCount, int numberStringToAnalyze) {
        test(new _$TestCase(original, expectedCount, numberStringToAnalyze));
    }
    
    @Value
    @EqualsAndHashCode(callSuper = true)
    private final class _$TestCase extends _$AbstractConsoleTestCase {
        String[] original;
        int expectedCount;
        int numberStringToAnalyze;

        @Override
        String getInput() {
            return String.valueOf(numberStringToAnalyze) + lineSeparator()
                 + String.join(" ", original) + lineSeparator();
        }

        @Override
        String getOutput() {
            return String.valueOf(expectedCount);
        }
    }
}
