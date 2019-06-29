package com.epam.homework;

import lombok.EqualsAndHashCode;
import lombok.Value;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

import static java.lang.System.lineSeparator;
import static java.util.stream.Collectors.toSet;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * С консоли вводятся три целых числа A, B, C.
 * Числа являются коэффициентами, задающими квадратное уравнение в общем виде: A*x^2 + B*x + C = 0
 * Необходимо найти корни этого уравнения.
 * <p>
 * Формат входных данных:
 * Строка, содержащая 3 целых числа, разделенных пробелами
 * <p>
 * Формат выходных данных:
 * В результате решения уравнения может быть получено три варианта ответа:
 * <p>
 * NO ROOTS
 * корень уравнения
 * первый корень уравнения, второй корень уравнения
 * <p>
 * В результате выполнения в выходной поток посылается строка, соответствующая найденному решению.
 * Значения корней округляются до 2 знаков после запятой.
 * В качестве десятичного разделителя используется точка.
 * <p>
 * ---------------------------------------------------------------------------------------------------
 * Примеры выполнения задания:
 * <p>
 * Входные данные:
 * 2 7 0
 * <p>
 * Выходные данные:
 * -3.5, 0
 * <p>
 * <p>
 * ---------------------------------------------------------------------------------------------------
 * Входные данные:
 * 4 4 1
 * <p>
 * Выходные данные:
 * -0.5
 * <p>
 * <p>
 * ---------------------------------------------------------------------------------------------------
 * Входные данные:
 * 7 0 35
 * <p>
 * Выходные данные:
 * NO ROOTS
 */
@SuppressWarnings("SameParameterValue")
class Task9TTest extends _$AbstractConsoleTask {

    Task9TTest() {
        super("com.epam.homework.Task9");
    }

    /**
     * Нет корней уравнения.
     */
    @Test
    void test1() throws Exception {
        test(4, 2, 1);
    }

    private void test(int a, int b, int c, Double... expectedRoots) {
        test(new _$TestCase(a, b, c, expectedRoots));
    }

    @Value
    @EqualsAndHashCode(callSuper = true)
    private final class _$TestCase extends _$AbstractConsoleTestCase {
        int a;
        int b;
        int c;
        Double[] expectedRoots;

        @Override
        String getInput() {
            return a + " " + b + " " + c + lineSeparator();
        }

        @Override
        String getOutput() {
            throw new UnsupportedOperationException();
        }
    }
}
