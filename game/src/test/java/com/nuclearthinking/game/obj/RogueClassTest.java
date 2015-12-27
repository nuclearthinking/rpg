package com.nuclearthinking.game.obj;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Date: 26.12.2015
 * Time: 21:07
 *
 * @author Vladislav Radchenko (onfient@gmail.com)
 */
public class RogueClassTest {
    RogueClass rClass;

    @Test
    public void testLevelUp() throws Exception {
        Player player = Player.getInstance();
        player.setClass(RogueClass.getInstance());
        player.levelUP();
        Assert.assertEquals(player.getAgility(), 11.1);
        Assert.assertEquals(player.getLevel(), 2);
    }

    @Test
    public void testLevelUp2() throws Exception {
        Player player = Player.getInstance();
        player.setClass(RogueClass.getInstance());
        player.levelUP();
        player.levelUP();
        Assert.assertEquals(player.getAgility(), 12.2);
        Assert.assertEquals(player.getLevel(), 3);
    }


    @Test
    public void testPDamage() throws Exception {
       Player  player = Player.getInstance();
        int dmg = rClass.pDamage(player);
        player.levelUP();
        player.levelUP();
        player.levelUP();
        Assert.assertEquals(player.getLevel(), 4);
        Assert.assertEquals(dmg, 12);
    }

    @Test
    public void testMDamage() throws Exception {

    }

    @Test
    public void testMDefence() throws Exception {

    }

    @Test
    public void testPDefence() throws Exception {

    }

    @Test
    public void testPCriticalChanse() throws Exception {

    }

    @Test
    public void testMCriticalChanse() throws Exception {

    }
}