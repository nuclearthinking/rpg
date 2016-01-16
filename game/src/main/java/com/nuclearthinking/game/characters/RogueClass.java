package com.nuclearthinking.game.characters;

import com.nuclearthinking.game.characters.interfaces.IPlayerClass;
import com.nuclearthinking.game.engines.ClassConfigReader;
import com.nuclearthinking.game.obj.jsonpojo.RogueConfig;

/**
 * Date: 25.12.2015
 * Time: 13:06
 *
 * @author Vladislav Radchenko (onifent@gmail.com)
 */

public class RogueClass extends PlayerClass implements IPlayerClass {
    ClassConfigReader classConfigReader = ClassConfigReader.getInstance();
    private RogueConfig rConf = null;

    public RogueClass() {
        rConf = classConfigReader.getClassConfig().getRogueConfig();
    }


    @Override
    public int pDamage(ChracterObject chracterObject) {
        double pDmg = chracterObject.getAgility() * 0.8 + chracterObject.getLevel() * 2;
        return (int) pDmg;
    }

    @Override
    public int mDamage(ChracterObject chracterObject) {
        return (int) chracterObject.getIntelligence();
    }

    @Override
    public void levelUp(ChracterObject chracterObject) {
        chracterObject.addStrenght(rConf.getStrengthRate());
        chracterObject.addStamina(rConf.getStaminaRate());
        chracterObject.addIntelegence(rConf.getIntelligenceRate());
        chracterObject.addAgility(rConf.getAgilityRate());
    }

    @Override
    public int mDefence(ChracterObject chracterObject) {
        double mDef = chracterObject.getIntelligence();
        return (int) mDef;
    }

    @Override
    public int pDefence(ChracterObject chracterObject) {
        double pDef = chracterObject.getStrength() / 2 + chracterObject.getAgility();
        return (int) pDef;
    }

}
