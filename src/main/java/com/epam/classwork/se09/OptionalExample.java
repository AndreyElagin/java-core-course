package com.epam.classwork.se09;

import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class OptionalExample {

    public static String getValue7() {
        return ThreadLocalRandom.current().nextBoolean() ? "123" : null;
    }



    public static Optional<String> getValue8() {
        String value = null;
        return ThreadLocalRandom.current().nextBoolean() ? Optional.of(value) : Optional.empty();
    }

    public static void main(String[] args) {
        Optional<String> value = getValue8();

        System.out.println(value.filter(Pattern.compile("\\d+").asPredicate())
                                .map(Integer::parseInt)
                                .map(val -> val + 5)
                                .map(String::valueOf)
                                .orElse("Not a number"));

        if (value.isPresent()) {
            String val = value.get();
            if (val.matches("\\d+")) {
                System.out.println(Integer.parseInt(val) + 5);
            } else {
                System.out.println(100);
            }
        }
    }

    private static void oldStyle() {
        String value = getValue7();
        if (value != null) {
            if (value.matches("\\d+")) {
                System.out.println(Integer.parseInt(value) + 5);
            } else {
                System.out.println("Not a number");
            }
        } else {
            System.out.println("Not a number");
        }
    }
}
