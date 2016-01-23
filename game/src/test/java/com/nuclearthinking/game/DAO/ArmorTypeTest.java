package com.nuclearthinking.game.DAO;

import com.nuclearthinking.game.engines.DatabaseEngine;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Date: 24.01.2016
 * Time: 0:24
 *
 * @author Vladislav Radchenko (onfient@gmail.com)
 */
public class ArmorTypeTest {

    @Test
    public void testGetArmorTypeById() throws Exception {
        DatabaseEngine.getInstance().initDb();
        ArmorType armorType = new ArmorType().getArmorTypeById(1);
        assertEquals(armorType.getArmorTypeId(), new Integer(1));
        assertEquals(armorType.getArmorTypeName(), "helmet");
    }

    @Test
    public void testGetArmorTypeNameById() throws Exception {
        DatabaseEngine.getInstance().initDb();
        assertEquals("helmet", new ArmorType().getArmorTypeNameById(1));
    }
}