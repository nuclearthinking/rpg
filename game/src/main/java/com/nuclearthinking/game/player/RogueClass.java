package com.nuclearthinking.game.player;

import com.nuclearthinking.game.engines.ClassConfigReader;
import com.nuclearthinking.game.obj.jsonpojo.RogueConfig;

/**
 * Date: 25.12.2015
 * Time: 13:06
 *
 * @author Vladislav Radchenko (onifent@gmail.com)
 */

public class RogueClass extends PlayerClass {
    ClassConfigReader classConfigReader = ClassConfigReader.getInstance();
    private RogueConfig rConf = null;

    public RogueClass() {
        rConf = classConfigReader.getClassConfig().getRogueConfig();
    }


    @Override
    public int pDamage(Player characterObject) {
        double pDmg = characterObject.getAgility() * 0.8 + characterObject.getLevel() * 2;
        return (int) pDmg;
    }

    @Override
    public int mDamage(Player characterObject) {
        return (int) characterObject.getIntelligence();
    }

    @Override
    public void levelUp(Player characterObject) {
        characterObject.addStrenght(rConf.getStrengthRate());
        characterObject.addStamina(rConf.getStaminaRate());
        characterObject.addIntelegence(rConf.getIntelligenceRate());
        characterObject.addAgility(rConf.getAgilityRate());
    }

    @Override
    public int mDefence(Player characterObject) {
        double mDef = characterObject.getIntelligence();
        return (int) mDef;
    }

    @Override
    public int pDefence(Player characterObject) {
        double pDef = characterObject.getStrength() / 2 + characterObject.getAgility();
        return (int) pDef;
    }

    @Override
    public boolean isRogue()
    {
        return true;
    }

    @Override
    public String toString()
    {
        return "Rogue";
    }
}
