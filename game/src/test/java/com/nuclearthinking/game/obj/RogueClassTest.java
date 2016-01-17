package com.nuclearthinking.game.obj;

import com.nuclearthinking.game.characters.Player;
import com.nuclearthinking.game.characters.RogueClass;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Date: 26.12.2015
 * Time: 21:07
 *
 * @author Vladislav Radchenko (onfient@gmail.com)
 */
public class RogueClassTest {

    @Test
    public void testLevelUp() throws Exception {
        Player player = new Player();
        player.setClass(new RogueClass());
        player.levelUP();
        Assert.assertEquals(player.getAgility(), 11.1);
        Assert.assertEquals(player.getLevel(), 2);
    }

    @Test
    public void testLevelUp2() throws Exception {
        Player player = new Player();
        player.setClass(new RogueClass());
        player.levelUP();
        player.levelUP();
        Assert.assertEquals(player.getAgility(), 12.2);
        Assert.assertEquals(player.getLevel(), 3);
    }


    @Test
    public void testPDamage() throws Exception {
        Player player = new Player();
        RogueClass rCLass = new RogueClass();
        player.setClass(rCLass);
        player.levelUP();
        player.levelUP();
        player.levelUP();
        int dmg = rCLass.pDamage(player);
        Assert.assertEquals(player.getLevel(), 4);
        Assert.assertEquals(dmg, 18);
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