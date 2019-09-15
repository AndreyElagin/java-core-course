package com.epam.homework.external.whoCalled;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;

import static com.epam.homework.external.whoCalled.WhoCalled.*;
import static org.junit.jupiter.api.Assertions.*;

class WhoCalledTest {

    @Test
    @DisplayName("Should correctly define the class and method called it")
    void check1() {
        assertEquals("jdk.internal.reflect.NativeMethodAccessorImpl#invoke0", getCallerClassAndMethodName());
    }
}