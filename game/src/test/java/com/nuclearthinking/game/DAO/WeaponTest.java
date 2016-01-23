package com.nuclearthinking.game.DAO;

import com.nuclearthinking.game.engines.DatabaseEngine;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Date: 24.01.2016
 * Time: 0:45
 *
 * @author Vladislav Radchenko (onfient@gmail.com)
 */
public class WeaponTest {

    @Test
    public void testGetWeaponFromDbById() throws Exception {
        DatabaseEngine.getInstance().initDb();
        Weapon weapon = new Weapon().getWeaponFromDbById(1);
        assertEquals(weapon.getId(), 1);
        assertEquals(weapon.getName(), "Iron Sword");
        assertEquals(weapon.getDamageMinimal(), 1);
        assertEquals(weapon.getDamageMaximal(), 3);
        assertEquals(weapon.getAgilityBonus(), 0);
        assertEquals(weapon.getIntelligenceBonus(), 0);
        assertEquals(weapon.getStrengthBonus(), 0);
        assertEquals(weapon.getWeaponType(), "sword");
    }
}