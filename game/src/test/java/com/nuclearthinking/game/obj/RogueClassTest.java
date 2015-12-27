package com.nuclearthinking.game.obj;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Date: 26.12.2015
 * Time: 21:07
 *
 * @author Vladislav Radchenko (onfient@gmail.com)
 */
public class RogueClassTest {
    Player player;

    @BeforeMethod
    public void setUp() {
        player = Player.getInstance();

    }

    @Test
    public void testLevelUp() throws Exception {
        player.setpClass(RogueClass.getInstance());
        player.levelUP();
        Assert.assertEquals(player.getAgility(), 11.1);
    }
}