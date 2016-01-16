package com.nuclearthinking.game.obj;

import com.nuclearthinking.game.characters.CharacterObject;
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
        CharacterObject characterObject = new CharacterObject() {
            @Override
            public int getId() {
                return 0;
            }
        };
        characterObject.setClass(new RogueClass());
        characterObject.levelUP();
        Assert.assertEquals(characterObject.getAgility(), 11.1);
        Assert.assertEquals(characterObject.getLevel(), 2);
    }

    @Test
    public void testLevelUp2() throws Exception {
        CharacterObject characterObject = new CharacterObject() {
            @Override
            public int getId() {
                return 0;
            }
        };
        characterObject.setClass(new RogueClass());
        characterObject.levelUP();
        characterObject.levelUP();
        Assert.assertEquals(characterObject.getAgility(), 12.2);
        Assert.assertEquals(characterObject.getLevel(), 3);
    }


    @Test
    public void testPDamage() throws Exception {
        CharacterObject characterObject = new CharacterObject() {
            @Override
            public int getId() {
                return 0;
            }
        };
        RogueClass rCLass = new RogueClass();
        characterObject.setClass(rCLass);
        characterObject.levelUP();
        characterObject.levelUP();
        characterObject.levelUP();
        int dmg = rCLass.pDamage(characterObject);
        Assert.assertEquals(characterObject.getLevel(), 4);
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