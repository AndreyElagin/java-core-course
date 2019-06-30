package com.epam.homework;

import lombok.EqualsAndHashCode;
import lombok.Value;
import org.junit.jupiter.api.Test;

import static java.lang.System.lineSeparator;

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
@SuppressWarnings("SameParameterValue")
class Task4TTest extends _$AbstractConsoleTask {

    Task4TTest() {
        super("com.epam.homework.Task4");
    }

    /**
     * Одно слово.
     */
    @Test
    void test1() {
        test(new String[]{"w"}, "w");
    }

    private void test(String[] original, String expectedWord) {
        test(original, expectedWord, original.length);
    }
    
    private void test(String[] original, String expectedWord, int numberStringToAnalyze) {
        test(new _$TestCase(original, expectedWord, numberStringToAnalyze));
    }
    
    @Value
    @EqualsAndHashCode(callSuper = true)
    private final class _$TestCase extends _$AbstractConsoleTestCase {
        String[] original;
        String expectedWord;
        int numberStringToAnalyze;

        @Override
        String getInput() {
            return String.valueOf(numberStringToAnalyze) + lineSeparator()
                 + String.join(" ", original) + lineSeparator();
        }

        @Override
        String getOutput() {
            return expectedWord;
        }
    }
}
