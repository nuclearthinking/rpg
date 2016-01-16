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
    public int pDamage(CharacterObject characterObject) {
        double pDmg = characterObject.getAgility() / 2 + characterObject.getStrength() / 2 + characterObject.getLevel();
        return (int) pDmg;
    }

    @Override
    public int mDamage(CharacterObject characterObject) {
        double mDmg = characterObject.getIntelligence() * 0.8 + characterObject.getLevel() * 2;
        return (int) mDmg;
    }

    @Override
    public void levelUp(CharacterObject characterObject) {
        characterObject.addStrenght(mConfig.getStrengthRate());
        characterObject.addStamina(mConfig.getStaminaRate());
        characterObject.addIntelegence(mConfig.getIntelligenceRate());
        characterObject.addAgility(mConfig.getAgilityRate());
    }

    @Override
    public int mDefence(CharacterObject characterObject) {
        double mDef = characterObject.getIntelligence() * 1.5;
        return (int) mDef;
    }

    @Override
    public int pDefence(CharacterObject characterObject) {
        double pDef = characterObject.getStrength() / 2 + characterObject.getAgility() / 2;
        return (int) pDef;
    }

}
