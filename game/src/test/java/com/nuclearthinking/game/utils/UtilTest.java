package com.nuclearthinking.game.utils;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created
 * Date: 23.12.2015
 * Time: 14:46
 *
 * @author Vladislav Radchenko (onfient@gmail.com)
 */
public class UtilTest {
    Util ut;

    @BeforeMethod
    public void setUp() {
        ut = new Util();
    }

    @Test(testName = "eng строка")
    public void testSetFirstCharUpperCase() throws Exception {
        Assert.assertEquals(ut.setFirstCharUpperCase("qweqwe"), "Qweqwe");
    }

    @Test(testName = "цифробуквы")
    public void testSetFirstCharUpperCase2() {
        Assert.assertEquals(ut.setFirstCharUpperCase("1234qwe"), "1234qwe");
    }

    @Test(testName = "русскобуквы")
    public void testSetFristCharUpperCase3() {
        Assert.assertEquals(ut.setFirstCharUpperCase("митрофан"), "Митрофан");
    }


}