package com.epam.homework;

import java.lang.reflect.Method;
import java.time.Duration;
import java.util.function.Consumer;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

abstract class _$AbstractTask {

    private final Class<?> testedClass;
    private final Method testedMethod;

    _$AbstractTask(String taskClassName, String methodName, Class<?> parameters) {
        try {
            testedClass = Class.forName(taskClassName);
            testedMethod = testedClass.getDeclaredMethod(methodName, parameters);
            testedMethod.setAccessible(true);
        } catch (ClassNotFoundException | NoSuchMethodException ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    @SuppressWarnings("unchecked")
    <R> void test(_$AbstractTestCase<R> testCase) {
        assertTimeoutPreemptively(Duration.ofMillis(testCase.getTimeoutInMillis()), () -> {
            Object object = testCase.getObjectConstructor().apply(testedClass);
            Object result = testedMethod.invoke(object, testCase.getParams());
            testCase.getChecker().accept((R) result);
        });
    }

    static abstract class _$AbstractTestCase<R> {

        abstract long getTimeoutInMillis();
        abstract Function<Class<?>, Object> getObjectConstructor();
        abstract Object[] getParams();
        abstract Consumer<R> getChecker();
    }
}
