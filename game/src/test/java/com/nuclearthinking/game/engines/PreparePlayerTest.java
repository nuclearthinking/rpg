package com.nuclearthinking.game.engines;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Date: 25.12.2015
 * Time: 9:20
 *
 * @author Vladislav Radchenko (onfient@gmail.com)
 */
public class PreparePlayerTest {
    PreparePlayer preparePlayer = PreparePlayer.getInstance();

    @Test
    public void testIsValidName() throws Exception {
        Assert.assertEquals(preparePlayer.isValidName("1qweqwe"), false);
    }

    @Test
    public void testIsValidName2() throws Exception {
        Assert.assertEquals(preparePlayer.isValidName("23123123"), false);
    }

    @Test
    public void testIsValidName3() throws Exception {
        Assert.assertEquals(preparePlayer.isValidName("q123123"), true);
    }

    @Test
    public void testIsValidName4()throws Exception {
        Assert.assertEquals(preparePlayer.isValidName("Onifent"),true);
    }


}