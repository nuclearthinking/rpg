package com.nuclearthinking.game.characters;

import com.nuclearthinking.game.characters.interfaces.IPlayerClass;
import com.nuclearthinking.game.engines.ClassConfigReader;
import com.nuclearthinking.game.obj.jsonpojo.MageConfig;

/**
 * Date: 25.12.2015
 * Time: 13:06
 *
 * @author Vladislav Radchenko (onifent@gmail.com)
 */

public class MageClass extends PlayerClass implements IPlayerClass {
    MageConfig mConfig;
    ClassConfigReader classConfigReader = ClassConfigReader.getInstance();

    public MageClass() {
        mConfig = classConfigReader.getClassConfig().getMageConfig();
    }

    @Override
    public int pDamage(ChracterObject chracterObject) {
        double pDmg = chracterObject.getAgility() / 2 + chracterObject.getStrength() / 2 + chracterObject.getLevel();
        return (int) pDmg;
    }

    @Override
    public int mDamage(ChracterObject chracterObject) {
        double mDmg = chracterObject.getIntelligence() * 0.8 + chracterObject.getLevel() * 2;
        return (int) mDmg;
    }

    @Override
    public void levelUp(ChracterObject chracterObject) {
        chracterObject.addStrenght(mConfig.getStrengthRate());
        chracterObject.addStamina(mConfig.getStaminaRate());
        chracterObject.addIntelegence(mConfig.getIntelligenceRate());
        chracterObject.addAgility(mConfig.getAgilityRate());
    }

    @Override
    public int mDefence(ChracterObject chracterObject) {
        double mDef = chracterObject.getIntelligence() * 1.5;
        return (int) mDef;
    }

    @Override
    public int pDefence(ChracterObject chracterObject) {
        double pDef = chracterObject.getStrength() / 2 + chracterObject.getAgility() / 2;
        return (int) pDef;
    }

}
