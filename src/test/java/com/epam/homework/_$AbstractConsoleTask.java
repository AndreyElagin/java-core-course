package com.epam.homework;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;

abstract class _$AbstractConsoleTask extends _$AbstractTask {

    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    _$AbstractConsoleTask(String taskClassName) {
        super(taskClassName, "main", String[].class);
    }

    void test(_$AbstractConsoleTestCase testCase) {
        InputStream oldIn = System.in;
        PrintStream oldOut = System.out;

        try {
            System.setIn(new ByteArrayInputStream(testCase.getInput().getBytes()));
            System.setOut(new PrintStream(out));

            super.test(testCase);
        } finally {
            System.setIn(oldIn);
            System.setOut(oldOut);
        }
    }

    abstract class _$AbstractConsoleTestCase extends _$AbstractTestCase<String> {

        @Override
        long getTimeoutInMillis() {
            return TimeUnit.SECONDS.toMillis(5);
        }

        final Function<Class<?>, Object> getObjectConstructor() {
            return clazz -> null;
        }

        final Object[] getParams() {
            return new Object[]{ new String[0] };
        }

        final Consumer<String> getChecker() {
            return result -> assertEquals(getOutput().trim(), new String(out.toByteArray()).trim());
        }

        abstract String getInput();
        abstract String getOutput();
    }
}
