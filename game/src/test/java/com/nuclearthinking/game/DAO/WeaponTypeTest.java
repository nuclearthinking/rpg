package com.nuclearthinking.game.DAO;

import com.nuclearthinking.game.engines.DatabaseEngine;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Date: 24.01.2016
 * Time: 0:50
 *
 * @author Vladislav Radchenko (onfient@gmail.com)
 */
public class WeaponTypeTest {

    @BeforeMethod
    public void setUp() {
        DatabaseEngine.getInstance().initDb();
    }

    @Test
    public void testGetArmorTypeById() throws Exception {
        WeaponType weaponType = new WeaponType().getWeaponTypeById(1);
        assertEquals(weaponType.getWeaponTypeId(), 1);
        assertEquals(weaponType.getWeaponTypeName(), "sword");
    }

    @Test
    public void testGetArmorTypeNameById() throws Exception {
        assertEquals("sword", new WeaponType().getWeaponTypeNameById(1));

    }
}