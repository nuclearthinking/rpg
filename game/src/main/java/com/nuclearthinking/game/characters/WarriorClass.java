package com.nuclearthinking.game.characters;

import com.nuclearthinking.game.characters.interfaces.IPlayerClass;
import com.nuclearthinking.game.engines.ClassConfigReader;
import com.nuclearthinking.game.obj.jsonpojo.WarriorConfig;

/**
 * Date: 25.12.2015
 * Time: 13:06
 *
 * @author Vladislav Radchenko (onifent@gmail.com)
 */

public class WarriorClass extends PlayerClass implements IPlayerClass {
    WarriorConfig warriorConfig;
    ClassConfigReader classConfigReader = ClassConfigReader.getInstance();

    public WarriorClass() {
        warriorConfig = classConfigReader.getClassConfig().getWarriorConfig();
    }

    @Override
    public int pDamage(ChracterObject chracterObject) {
        return 0;
    }

    @Override
    public int mDamage(ChracterObject chracterObject) {
        return (int) chracterObject.getIntelligence();
    }

    @Override
    public void levelUp(ChracterObject chracterObject) {
        chracterObject.addStrenght(warriorConfig.getStrengthRate());
        chracterObject.addStamina(warriorConfig.getStaminaRate());
        chracterObject.addIntelegence(warriorConfig.getIntelligenceRate());
        chracterObject.addAgility(warriorConfig.getAgilityRate());
    }

    @Override
    public int mDefence(ChracterObject chracterObject) {
        double mDef = chracterObject.getIntelligence();
        return (int) mDef;
    }

    @Override
    public int pDefence(ChracterObject chracterObject) {
        double pDef = chracterObject.getStrength() + chracterObject.getAgility() / 2;
        return (int) pDef;
    }

}
