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
        Assert.assertEquals(ut.beautifyName("qweqwe"), "Qweqwe");
    }

    @Test(testName = "цифробуквы")
    public void testSetFirstCharUpperCase2() {
        Assert.assertEquals(ut.beautifyName("1234qwe"), "1234qwe");
    }

    @Test(testName = "русскобуквы")
    public void testSetFristCharUpperCase3() {
        Assert.assertEquals(ut.beautifyName("митрофан"), "Митрофан");
    }


    @Test
    public void testIsNumericOnly() throws Exception {
        Assert.assertEquals(ut.isNumericOnly("1"),true);
    }

    @Test
    public void testIsNumericOnly2() throws Exception {
        Assert.assertEquals(ut.isNumericOnly("1324234"),true);
    }

    @Test
    public void testIsNumericOnly3() throws Exception {
        Assert.assertEquals(ut.isNumericOnly("123123q"),false);
    }

    @Test
    public void testIsNumericOnly4() throws Exception {
        Assert.assertEquals(ut.isNumericOnly("qweqwe"),false);
    }

    @Test
    public void testIsNumericOnly5() throws Exception {
        Assert.assertEquals(ut.isNumericOnly("!\"№№№"),false);
    }
    @Test
    public void testIsNumericOnly6() throws Exception {
        Assert.assertEquals(ut.isNumericOnly("фывйцв"),false);
    }

    @Test
    public void testBeautifyName() throws Exception {
        Assert.assertEquals(ut.beautifyName("дима"),"Дима");
    }

    @Test
    public void testBeautifyName2() throws Exception {
        Assert.assertEquals(ut.beautifyName("ДИМА"),"Дима");
    }

    @Test
    public void testBeautifyName3() throws Exception {
        Assert.assertEquals(ut.beautifyName("Peter"),"Peter");
    }

    @Test
    public void testBeautifyName4() throws Exception {
        Assert.assertEquals(ut.beautifyName("PETER"),"Peter");
    }

    @Test
    public void testFirstCharIsNumeric() throws Exception {
        Assert.assertEquals(ut.firstCharIsNumeric("1111"),true);
    }

    @Test
    public void testFirstCharIsNumeric2() throws Exception {
        Assert.assertEquals(ut.firstCharIsNumeric("qweqwe"),false);
    }
    @Test
    public void testFirstCharIsNumeric3() throws Exception {
        Assert.assertEquals(ut.firstCharIsNumeric("1"),true);
    }
    @Test
    public void testFirstCharIsNumeric4() throws Exception {
        Assert.assertEquals(ut.firstCharIsNumeric("q1qwe"),false);
    }
}