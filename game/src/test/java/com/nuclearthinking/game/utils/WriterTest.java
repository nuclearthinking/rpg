package com.nuclearthinking.game.utils;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class WriterTest {


    @Test(testName = "корректна€ строка")
    public void checkInputTestCorrect() {
        try {
            Class<Writer> cl = Writer.class;
            Writer obj = cl.newInstance();
            Method method = cl.getDeclaredMethod("checkInput", String.class);
            method.setAccessible(true);
            Assert.assertEquals(method.invoke(obj, "qwe"), true);

        } catch (NoSuchMethodException | InstantiationException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test(testName = "пуста€ строка")
    public void checkInputTestEmpty() {
        try {
            Class<Writer> cl = Writer.class;
            Writer obj = cl.newInstance();
            Method method = cl.getDeclaredMethod("checkInput", String.class);
            method.setAccessible(true);
            Assert.assertEquals(method.invoke(obj, ""), false);

        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            Assert.fail();
            e.printStackTrace();
        }
    }

    @Test(testName = "пара пробелов")
    public void checkInputTestSomeWhitespaces() {
        try {
            Class<Writer> cl = Writer.class;
            Writer obj = cl.newInstance();
            Method method = cl.getDeclaredMethod("checkInput", String.class);
            method.setAccessible(true);
            Assert.assertEquals(method.invoke(obj, "  "), false);
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            Assert.fail();
            e.printStackTrace();
        }
    }
}