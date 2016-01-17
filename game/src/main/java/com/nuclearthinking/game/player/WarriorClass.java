package com.nuclearthinking.game.player;

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
    public int pDamage(Player characterObject) {
        return 0;
    }

    @Override
    public int mDamage(Player characterObject) {
        return (int) characterObject.getIntelligence();
    }

    @Override
    public void levelUp(Player characterObject) {
        characterObject.addStrenght(warriorConfig.getStrengthRate());
        characterObject.addStamina(warriorConfig.getStaminaRate());
        characterObject.addIntelegence(warriorConfig.getIntelligenceRate());
        characterObject.addAgility(warriorConfig.getAgilityRate());
    }

    @Override
    public int mDefence(Player characterObject) {
        double mDef = characterObject.getIntelligence();
        return (int) mDef;
    }

    @Override
    public int pDefence(Player characterObject) {
        double pDef = characterObject.getStrength() + characterObject.getAgility() / 2;
        return (int) pDef;
    }

    @Override
    public boolean isWarrior()
    {
        return true;
    }

}
