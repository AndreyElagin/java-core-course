package com.epam.homework;

import lombok.EqualsAndHashCode;
import lombok.Value;
import org.junit.jupiter.api.Test;

import static java.lang.System.lineSeparator;

/**
 * Ввести N слов с консоли.
 * Найти слова, состоящие только из различных символов английского алфавита.
 * Символы верхнего и нижнего регистра считать одинаковыми.
 * В случае, если слово встречается более одного раза - вывести его единожды.
 *
 * Формат входных данных:
 * N (целое число, 0 < N < 100) - количество слов в строке
 * Строка, содержащая нимимум N слов (состоящих только из букв английского языка), разделенных пробелами
 *
 * Формат выходных данных:
 * В результате выполнения в выходной поток должна быть выведена строка, содержащая найденные слова, разделенные пробелами.
 * Порядок слов должен совпадать с порядком их появления во входной последовательности.
 * В случае, если не найдено ни одного слова, удовлетворяющего условию - в поток должно быть выведено "NOT FOUND".
 *
 * ---------------------------------------------------------------------------------------------------
 * Пример выполнения задания:
 *
 * Входные данные:
 * 11
 * The Java programming language is a general-purpose, concurrent, class-based, object-oriented language
 *
 * Выходные данные:
 * The is a
 */
@SuppressWarnings("SameParameterValue")
class Task7TTest extends _$AbstractConsoleTask {

    /** Значение, соответствующее отсутствию среди переданных слов слова, состоящего из различных символов. */
    private static final String NOT_FOUND = "NOT FOUND";

    Task7TTest() {
        super("com.epam.homework.Task7");
    }

    /**
     * Одно слово, удовлетворяющее условию.
     */
    @Test
    void test1() {
        test(new String[]{"abc"}, new String[]{"abc"});
    }

    private void test(String[] originalWords, String[] expectedWords) {
        test(originalWords, originalWords.length, expectedWords);
    }
    
    private void test(String[] originalWords, int numberStringToAnalyze, String[] expectedWords) {
        test(new _$TestCase(originalWords, expectedWords, numberStringToAnalyze));
    }
    
    @Value
    @EqualsAndHashCode(callSuper = true)
    private final class _$TestCase extends _$AbstractConsoleTestCase {
        String[] originalWords;
        String[] expectedWords;
        int numberStringToAnalyze;

        @Override
        String getInput() {
            return String.valueOf(numberStringToAnalyze) + lineSeparator()
                 + String.join(" ", originalWords) + lineSeparator();
        }

        @Override
        String getOutput() {
            return String.join(" ", expectedWords);
        }
    }
}
