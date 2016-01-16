package com.nuclearthinking.game.obj;

import com.nuclearthinking.game.characters.ChracterObject;
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
        ChracterObject chracterObject = new ChracterObject() {
            @Override
            public int getId() {
                return 0;
            }
        };
        chracterObject.setClass(new RogueClass());
        chracterObject.levelUP();
        Assert.assertEquals(chracterObject.getAgility(), 11.1);
        Assert.assertEquals(chracterObject.getLevel(), 2);
    }

    @Test
    public void testLevelUp2() throws Exception {
        ChracterObject chracterObject = new ChracterObject() {
            @Override
            public int getId() {
                return 0;
            }
        };
        chracterObject.setClass(new RogueClass());
        chracterObject.levelUP();
        chracterObject.levelUP();
        Assert.assertEquals(chracterObject.getAgility(), 12.2);
        Assert.assertEquals(chracterObject.getLevel(), 3);
    }


    @Test
    public void testPDamage() throws Exception {
        ChracterObject chracterObject = new ChracterObject() {
            @Override
            public int getId() {
                return 0;
            }
        };
        RogueClass rCLass = new RogueClass();
        chracterObject.setClass(rCLass);
        chracterObject.levelUP();
        chracterObject.levelUP();
        chracterObject.levelUP();
        int dmg = rCLass.pDamage(chracterObject);
        Assert.assertEquals(chracterObject.getLevel(), 4);
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