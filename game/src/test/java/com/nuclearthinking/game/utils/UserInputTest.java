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

    @Test(testName = "���������� ������")
    public void checkInputTestCorrect() {
       Assert.assertEquals(checkInput("qwe"),true);
    }

    @Test(testName = "������ ������")
    public void checkInputTestEmpty() {
        Assert.assertEquals(checkInput(""),false);
    }

    @Test(testName = "���� ��������")
    public void checkInputTestSomeWhitespaces() {
        Assert.assertEquals(checkInput("  "),false);
    }

    @Test(testName = "����������")
    public void checkInputTestNotLetterSymbols(){
        Assert.assertEquals(checkInput("][}{!]"),false);
    }

    @Test(testName = "������������ �����")
    public void checkInputCyrilic(){
        Assert.assertEquals(checkInput("��������"),true);
    }

    @Test(testName = "����������� � ���������� �����")
    public void checkInputMultitext(){
        Assert.assertEquals(checkInput("���qwe"),true);
    }

    @Test(testName = "����� � �����")
    public void checkInputTextAndNum(){
        Assert.assertEquals(checkInput("1qwe3"),true);
    }

    @Test(testName = "������� �����, ������� �������")
    public void checkInputLongString(){
        Assert.assertEquals(checkInput("����������������"),false);
    }

    @Test(testName = "������� �����, � ����� ���")
    public void checkInputLongStringCorrect(){
        Assert.assertEquals(checkInput("���������������"),true);
    }


}