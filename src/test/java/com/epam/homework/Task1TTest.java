package com.epam.homework;

import lombok.EqualsAndHashCode;
import lombok.Value;
import org.junit.jupiter.api.Test;

import static java.lang.System.lineSeparator;

/**
 * Ввести N строк с консоли.
 * Найти среди них самую короткую и самую длинную.
 * Вывести найденные строки и их длину.
 * Если строк, удовлетворяющих условию, более одной - вывести последнюю из них.
 *
 * Формат входных данных:
 * N (целое число, 0 < N < 100) - количество доступных для чтения строк
 * Строка_1
 * Строка_2
 * ...
 * Строка_N
 *
 * Формат выходных данных:
 * MIN ($длина_минимальной_строки$): $минимальная_строка$
 * MAX ($длина_максимальной_строки$): $максимальная_строка$
 *
 * -----------------------------------------------------------------------------
 * Пример выполнения задания:
 *
 * Входные данные:
 * 4
 * Унылая пора! Очей очарованье!
 * Приятна мне твоя прощальная краса —
 * Люблю я пышное природы увяданье,
 * В багрец и в золото одетые леса,
 *
 * Выходные данные:
 * MIN (29): Унылая пора! Очей очарованье!
 * MAX (35): Приятна мне твоя прощальная краса —
 */
@SuppressWarnings("SameParameterValue")
class Task1TTest extends _$AbstractConsoleTask {

    Task1TTest() {
        super("com.epam.homework.Task1");
    }

    /**
     * Одна строка (являющаяся минимальной и максимальной одновременно).
     */
    @Test
    void test1() {
        test("W", "W", "W");
    }

    /**
     * Две строки (первая минимальная, вторая максимальная).
     */
    @Test
    void test2() {
        test("минимальная", "максимальная", "минимальная","максимальная");
    }

    /**
     * Две строки (первая максимальная, вторая минимальная).
     */
    @Test
    void test3() {
        test("минимальная", "максимальная", "максимальная","минимальная");
    }

    /**
     * Два числа (первое максимальное, второе минимальное).
     */
    @Test
    void test4() {
        test("1", "12", "1","12");
    }

    /**
     * Одна пустая строка (являющаяся минимальной и максимальной одновременно).
     */
    @Test
    void test5() {
        test(" ", " ", " ");
    }

    /**
     * Тест из условия задачи (4 строки, первая минимальная, вторая максимальная.
     */
    @Test
    void test6() {
        test("Унылая пора! Очей очарованье!", "Приятна мне твоя прощальная краса —",
                "Унылая пора! Очей очарованье!","Приятна мне твоя прощальная краса —",
                "Люблю я пышное природы увяданье,", "В багрец и в золото одетые леса,");
    }

    /**
     * Тест 8 строк, пятая минимальная, шестая максимальная.
     */
    @Test
    void test7() {
        test(" ", "Дверь отворилась и в квартиру",
                "Олег с утра шарахнул водки","Текилу, виски и коньяк",
                "Оксана все не хорошела", "Никак", " ", "Дверь отворилась и в квартиру", "Оксана мокрая вошла",
                "И мужу бледному сказала", "Ты плохо камень привязал");
    }

    private void test(String expectedMinimal, String expectedMaximal, String...strings) {
        test(new _$TestCase(expectedMinimal, expectedMaximal, strings, strings.length));
    }

    private void test(int numberStringToAnalyze, String expectedMinimal, String expectedMaximal, String...strings) {
        test(new _$TestCase(expectedMinimal, expectedMaximal, strings, numberStringToAnalyze));
    }

    @Value
    @EqualsAndHashCode(callSuper = true)
    private final class _$TestCase extends _$AbstractConsoleTestCase {
        String expectedMinimal;
        String expectedMaximal;
        String[] strings;
        int numberStringToAnalyze;

        @Override
        String getInput() {
            return String.valueOf(numberStringToAnalyze) + lineSeparator()
                 + String.join(lineSeparator(), strings) + lineSeparator();
        }

        @Override
        String getOutput() {
            return String.format("MIN (%d): %s%n"
                               + "MAX (%d): %s%n",
                                 expectedMinimal.length(),
                                 expectedMinimal,
                                 expectedMaximal.length(),
                                 expectedMaximal);
        }
    }
}
