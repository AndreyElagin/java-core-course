package com.epam.homework;

import lombok.EqualsAndHashCode;
import lombok.Value;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static java.lang.System.lineSeparator;
import static java.util.stream.Collectors.joining;

/**
 * Найти количество элементов самой длинной строго возрастающей подпоследовательности.
 * Оператор отношения можно определить на множестве, включающем более одного элемента.
 * <a href="https://ru.wikipedia.org/wiki/Монотонная_последовательность">Строго возрастающая последовательность</a>
 *
 * Формат входных данных:
 * N (целое число) - количество элементов исходной последовательности.
 * N целых чисел - элементы последовательности.
 *
 * Формат выходных данных:
 * Число, отображающее количество элементов на самом большом возрастающем участке последовательности.
 *
 * ---------------------------------------------------------------------------------------------------
 * Примеры выполнения задания:
 *
 * Входные данные:
 * 8
 * 2 1 3 3 4 5 6 5
 *
 * Выходные данные:
 * 4
 *
 *
 *
 * Входные данные:
 * 6
 * 6 5 4 3 2 1
 *
 * Выходные данные:
 * 0
 */@SuppressWarnings("SameParameterValue")
class Task14TTest extends _$AbstractConsoleTask {

    Task14TTest() {
        super("com.epam.homework.Task14");
    }

    /**
     * Последовательность, не содержащая возрастающих подпоследовательностей.
     */
    @Test
    void test1() {
        test(new int[]{6, 5, 4, 3, 2, 1, 0, -1}, 0);
    }

    /**
     * Последовательность, являющаяся полностью возрастающей.
     */
    @Test
    void test2() {
        test(new int[]{1, 2, 3, 4, 100500}, 5);
    }

    /**
     * Последовательность, состоящая из одного элемента.
     */
    @Test
    void test3() {
        test(new int[]{-1}, 0);
    }

    /**
     * Последовательность, содержащая две возрастающих подпоследовательности одинаковой длины.
     */
    @Test
    void test4() {
        this.test(new int[]{1, 2, 3, 2, 1, 2, 3, 2}, 3);
    }

    /**
     * Последовательность, содержащая две возрастающих подпоследовательности разной длины.
     */
    @Test
    void test5() {
        this.test(new int[]{1, 2, 3, 2, 1, 2, 3, 4}, 4);
    }

    /**
     * Последовательность, содержащая одинаковые элементы.
     */
    @Test
    void test6() {
        this.test(new int[]{1, 1, 1, 2, 1, 2, 3, 4}, 4);
    }

    /**
     * Последовательность, состоящая только из одинаковых элементов.
     */
    @Test
    void test7() {
        this.test(new int[]{1, 1, 1, 1}, 0);
    }

    private void test(int[] elements, int expectedLength) {
        test(new _$TestCase(elements, expectedLength));
    }

    @Value
    @EqualsAndHashCode(callSuper = true)
    private final class _$TestCase extends _$AbstractConsoleTestCase {
        int[] elements;
        int expectedLength;

        @Override
        String getInput() {
            return String.valueOf(elements.length) + lineSeparator()
                 + IntStream.of(elements)
                            .mapToObj(String::valueOf)
                            .collect(joining(" ")) + lineSeparator();
        }

        @Override
        String getOutput() {
            return String.valueOf(expectedLength);
        }
    }
}
