package com.epam.homework;

import lombok.EqualsAndHashCode;
import lombok.Value;
import org.junit.jupiter.api.Test;

import static java.lang.System.lineSeparator;

/**
 * Ввести число с консоли.
 * С помощью битовых, логических и арифметических операций определить, является ли указанное значение степенью двойки.
 *
 * Формат входных данных:
 * value - целое число, лежащее в диапазоне [Integer.MIN_VALUE, Integer.MAX_VALUE]
 *
 * Формат выходных данных:
 * YES - число является степенью двойки
 * NO - число не является степенью двойки
 *
 * ---------------------------------------------------------------------------------------------------
 * Примеры выполнения задания:
 *
 * Входные данные:
 * -128
 *
 * Выходные данные:
 * NO
 *
 *
 * Входные данные:
 * 256
 *
 * Выходные данные:
 * YES
 */
@SuppressWarnings("SameParameterValue")
class Task10TTest extends _$AbstractConsoleTask {

    private static final String POWER_OF_TWO = "YES";
    private static final String NOT_POWER_OF_TWO = "NO";

    Task10TTest() {
        super("com.epam.homework.Task10");
    }

    /**
     * Положительное число не являющееся степенью двойки.
     */
    @Test
    void test1() {
        test(127, false);
    }

    private void test(int value, boolean isPowerOfTwo) {
        test(new _$TestCase(value, isPowerOfTwo));
    }
    
    @Value
    @EqualsAndHashCode(callSuper = true)
    private final class _$TestCase extends _$AbstractConsoleTestCase {
        int value;
        boolean isPowerOfTwo;

        @Override
        String getInput() {
            return String.valueOf(value) + lineSeparator();
        }

        @Override
        String getOutput() {
            return isPowerOfTwo ? POWER_OF_TWO : NOT_POWER_OF_TWO;
        }
    }
}
