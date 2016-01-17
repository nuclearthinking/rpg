package com.nuclearthinking.game.player;

import com.nuclearthinking.game.engines.ClassConfigReader;
import com.nuclearthinking.game.obj.jsonpojo.MageConfig;

/**
 * Date: 25.12.2015
 * Time: 13:06
 *
 * @author Vladislav Radchenko (onifent@gmail.com)
 */

public class MageClass extends PlayerClass {
    MageConfig mConfig;
    ClassConfigReader classConfigReader = ClassConfigReader.getInstance();

    public MageClass() {
        mConfig = classConfigReader.getClassConfig().getMageConfig();
    }

    @Override
    public int pDamage(Player characterObject) {
        double pDmg = characterObject.getAgility() / 2 + characterObject.getStrength() / 2 + characterObject.getLevel();
        return (int) pDmg;
    }

    @Override
    public int mDamage(Player characterObject) {
        double mDmg = characterObject.getIntelligence() * 0.8 + characterObject.getLevel() * 2;
        return (int) mDmg;
    }

    @Override
    public void levelUp(Player characterObject) {
        characterObject.addStrenght(mConfig.getStrengthRate());
        characterObject.addStamina(mConfig.getStaminaRate());
        characterObject.addIntelegence(mConfig.getIntelligenceRate());
        characterObject.addAgility(mConfig.getAgilityRate());
    }

    @Override
    public int mDefence(Player characterObject) {
        double mDef = characterObject.getIntelligence() * 1.5;
        return (int) mDef;
    }

    @Override
    public int pDefence(Player characterObject) {
        double pDef = characterObject.getStrength() / 2 + characterObject.getAgility() / 2;
        return (int) pDef;
    }

    @Override
    public boolean isMage()
    {
        return true;
    }
}
