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
    public int pDamage(CharacterObject characterObject) {
        double pDmg = characterObject.getAgility() * 0.8 + characterObject.getLevel() * 2;
        return (int) pDmg;
    }

    @Override
    public int mDamage(CharacterObject characterObject) {
        return (int) characterObject.getIntelligence();
    }

    @Override
    public void levelUp(CharacterObject characterObject) {
        characterObject.addStrenght(rConf.getStrengthRate());
        characterObject.addStamina(rConf.getStaminaRate());
        characterObject.addIntelegence(rConf.getIntelligenceRate());
        characterObject.addAgility(rConf.getAgilityRate());
    }

    @Override
    public int mDefence(CharacterObject characterObject) {
        double mDef = characterObject.getIntelligence();
        return (int) mDef;
    }

    @Override
    public int pDefence(CharacterObject characterObject) {
        double pDef = characterObject.getStrength() / 2 + characterObject.getAgility();
        return (int) pDef;
    }

}
