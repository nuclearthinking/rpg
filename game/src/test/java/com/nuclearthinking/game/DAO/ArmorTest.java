package com.nuclearthinking.game.DAO;

import com.nuclearthinking.game.engines.DatabaseEngine;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Date: 23.01.2016
 * Time: 23:55
 *
 * @author Vladislav Radchenko (onfient@gmail.com)
 */
public class ArmorTest {

    @Test
    public void testGetArmorByID() throws Exception {
        DatabaseEngine.getInstance().initDb();
        Armor testArmor = new Armor().getArmorByID(1);
        assertEquals(testArmor.getId(), 1);
        assertEquals(testArmor.getAgilityBonus(), 0, "agility");
        assertEquals(testArmor.getArmorAmount(), 3, "armor");
        assertEquals(testArmor.getArmorType(), "helmet", "armorType");
        assertEquals(testArmor.getIntelligenceBonus(), 0, "int");
        assertEquals(testArmor.getStrengthBonus(), 0, "str");
        assertEquals(testArmor.getName(), "Cloth Cap", "name");
    }
}