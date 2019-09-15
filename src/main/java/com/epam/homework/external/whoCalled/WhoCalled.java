package com.epam.homework.external.whoCalled;

public class WhoCalled {
    public static void main(String[] args) {
        System.out.println(getCallerClassAndMethodName());
        anotherMethod();
    }

    private static void anotherMethod() {
        System.out.println(getCallerClassAndMethodName());
    }

    public static String getCallerClassAndMethodName() {
        StackTraceElement[] stackTraceElements = new Throwable().getStackTrace();
        String message = "";
        if (stackTraceElements.length >= 3) {
            StackTraceElement element = stackTraceElements[2];
            message = element.getClassName() + "#" + element.getMethodName();
            return message;
        } else {
            return null;
        }
    }
}
