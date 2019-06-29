package com.epam.homework;

import lombok.EqualsAndHashCode;
import lombok.Value;
import org.junit.jupiter.api.Test;

import static java.lang.System.lineSeparator;

/**
 * Ввести N слов с консоли.
 * Найти слово, буквы в котором идут в строгом порядке возрастания их кодов: word.charAt(i) < word.charAt(i + 1).
 * Если таких слов несколько, найти первое из них.
 * Слова состоящие из одного символа не учитывать.
 *
 * Формат входных данных:
 * N (целое число, 0 < N < 100) - количество слов в строке
 * Строка, содержащая нимимум N слов, разделенных пробелами
 *
 * Формат выходных данных:
 * В результате выполнения в выходной поток должно быть выведено слово, удовлетворяющее условию.
 * Если подходящее слово не найдено в выходной поток выводится строка "NOT FOUND"
 *
 * ---------------------------------------------------------------------------------------------------
 * Примеры выполнения задания:
 *
 * Входные данные:
 * 12
 * The original and reference implementation Java compilers were originally released by Sun
 *
 * Выходные данные:
 * by
 *
 * ===================================================================================================
 *
 * Входные данные:
 * 4
 * Кто-то позвонил в дверь
 *
 * Выходные данные:
 * NOT FOUND
 */
@SuppressWarnings("SameParameterValue")
class Task6TTest extends _$AbstractConsoleTask {

    /** Значение, соответствующее отсутствию среди переданных слов слова, удовлетворяющего условию. */
    private static final String NOT_FOUND = "NOT FOUND";

    Task6TTest() {
        super("com.epam.homework.Task6");
    }

    /**
     * Одно слово, удовлетворяющее условию.
     */
    @Test
    void test1() {
        test(new String[]{"abc"}, "abc");
    }

    private void test(String[] original, String expectedWord) {
        test(original, original.length, expectedWord);
    }
    
    private void test(String[] original, int numberStringToAnalyze, String expectedWord) {
        test(new _$TestCase(original, expectedWord, numberStringToAnalyze));
    }
    
    @Value
    @EqualsAndHashCode(callSuper = true)
    private final class _$TestCase extends _$AbstractConsoleTestCase {
        String[] words;
        String expectedWord;
        int numberStringToAnalyze;

        @Override
        String getInput() {
            return String.valueOf(numberStringToAnalyze) + lineSeparator()
                 + String.join(" ", words) + lineSeparator();
        }

        @Override
        String getOutput() {
            return expectedWord;
        }
    }
}
