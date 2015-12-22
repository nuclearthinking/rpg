package com.nuclearthinking.game.utils;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class WriterTest {
    private boolean checkInput(String string) {
        try {
            Class<Writer> cl = Writer.class;
            Writer obj = cl.newInstance();
            Method method = cl.getDeclaredMethod("checkInput", String.class);
            method.setAccessible(true);
            return (boolean) method.invoke(obj, string);
        } catch (NoSuchMethodException | InstantiationException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    @Test(testName = "корректна€ строка")
    public void checkInputTestCorrect() {
       Assert.assertEquals(checkInput("qwe"),true);
    }

    @Test(testName = "пуста€ строка")
    public void checkInputTestEmpty() {
        Assert.assertEquals(checkInput(""),false);
    }

    @Test(testName = "пара пробелов")
    public void checkInputTestSomeWhitespaces() {
        Assert.assertEquals(checkInput("  "),false);
    }
}