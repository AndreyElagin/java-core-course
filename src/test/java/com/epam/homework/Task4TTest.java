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

    /**
     * Пример из условия задачи (передаю 4 слова, ожидаю третье).
     */
    @Test
    void test2() {
        test(new String[]{"Cake is a lie"}, "a", 4);
    }

    /**
     * Тест на строки разной длины, но с одинаковым количеством уникальных символов(передаю 4 слова, ожидаю первое).
     */
    @Test
    void test3() {
        test(new String[]{"aaaa aa a aaa"}, "aaaa", 4);
    }

    /**
     * Тест на строки одинаковой длины, с одинаковым количеством уникальных символов(передаю 4 слова, ожидаю первое).
     */
    @Test
    void test4() {
        test(new String[]{"aaa bbb ccc ddd"}, "aaa", 4);
    }

    /**
     * Тест на пустые строки (передаю 4 слова, ожидаю вывод пустой строки без ошибки).
     */
    @Test
    void test5() {
        test(new String[]{"        "}, " ", 4);
    }

    /**
     * Многострочный тест(передаю 15 слов, ожидаю третье).
     */
    @Test
    void test6() {
        test(new String[]{"Lorem ipsum aaaaaaaaaaaaab sit amet consectetur adipiscing elit Integer scelerisque libero quis nulla tempor sed"}, "aaaaaaaaaaaaab", 15);
    }

    /**
     * Тест на несколько строк, которые содержат по 1 букве(передаю 4 слова, ожидаю первое).
     */
    @Test
    void test7() {
        test(new String[]{"a b c d"}, "a", 4);
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