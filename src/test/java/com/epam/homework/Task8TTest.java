package com.epam.homework;

import lombok.EqualsAndHashCode;
import lombok.Value;
import org.junit.jupiter.api.Test;

import static java.lang.System.lineSeparator;

/**
 * Ввести N слов с консоли.
 * Помимо обычных слов, во входной последовательности могут встречаться целые числа (в том числе большие чем Long.MAX_VALUE).
 * Среди них необходимо найти число-палиндром (одинаково читающееся в обоих направлениях).
 * Число, содержащее одну цифру также является палиндромом.
 * Если палиндромов во входной последовательности больше одного - найти второй уникальный из них.
 *
 * Формат входных данных:
 * N (целое число, 0 < N < 100) - количество слов в строке
 * Строка, содержащая минимум N слов, разделенных пробелами
 *
 * Формат выходных данных:
 * В результате выполнения в выходной поток должно быть выведено найденное число-палиндром.
 * В случае, если не найдено ни одного палиндрома - в поток должно быть выведено "NOT FOUND".
 *
 * ---------------------------------------------------------------------------------------------------
 * Пример выполнения задания:
 *
 * Входные данные:
 * 15
 * Chapter 11 describes exceptions, chapter 13 describes binary compatibility... chapter 22 presents a syntactic grammar
 *
 * Выходные данные:
 * 22
 */
@SuppressWarnings("SameParameterValue")
class Task8TTest extends _$AbstractConsoleTask {

    /** Значение, соответствующее отсутствию среди переданных слов палиндрома. */
    private static final String NOT_FOUND = "NOT FOUND";

    Task8TTest() {
        super("com.epam.homework.Task8");
    }

    /**
     * Число-палиндром из одной цифры.
     */
    @Test
    void test1() {
        test(new String[]{"9"}, "9");
    }

    private void test(String[] original, String expectedPalindrome) {
        test(new _$TestCase(original, original.length, expectedPalindrome));
    }

    private void test(String[] original, int numberWordsToAnalyze, String expectedPalindrome) {
        test(new _$TestCase(original, numberWordsToAnalyze, expectedPalindrome));
    }

    @Value
    @EqualsAndHashCode(callSuper = true)
    private final class _$TestCase extends _$AbstractConsoleTestCase {
        String[] original;
        int numberWordsToAnalyze;
        String expectedPalindrome;

        @Override
        String getInput() {
            return String.valueOf(numberWordsToAnalyze) + lineSeparator()
                 + String.join(" ", original) + lineSeparator();
        }

        @Override
        String getOutput() {
            return expectedPalindrome;
        }
    }
}
