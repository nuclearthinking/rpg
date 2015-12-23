package com.nuclearthinking.game.utils;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class UserInputTest {
    private boolean checkInput(String string) {
        try {
            Class<UserInput> cl = UserInput.class;
            UserInput obj = cl.newInstance();
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

    @Test(testName = "допсимволы")
    public void checkInputTestNotLetterSymbols(){
        Assert.assertEquals(checkInput("][}{!]"),false);
    }

    @Test(testName = "кирилический текст")
    public void checkInputCyrilic(){
        Assert.assertEquals(checkInput("фывфывфы"),true);
    }

    @Test(testName = "кирилически и английский текст")
    public void checkInputMultitext(){
        Assert.assertEquals(checkInput("фывqwe"),true);
    }

    @Test(testName = "текст и цифры")
    public void checkInputTextAndNum(){
        Assert.assertEquals(checkInput("1qwe3"),true);
    }

    @Test(testName = "длинный текст, слишком длинный")
    public void checkInputLongString(){
        Assert.assertEquals(checkInput("йцукенгшщзфывапр"),false);
    }

    @Test(testName = "длинный текст, в самый раз")
    public void checkInputLongStringCorrect(){
        Assert.assertEquals(checkInput("йцуфыв€чссмивап"),true);
    }


}