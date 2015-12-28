package com.nuclearthinking.game.obj;

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
    public int pDamage(Player player) {
        return 0;
    }

    @Override
    public int mDamage(Player player) {
        return (int) player.getIntelligence();
    }

    @Override
    public void levelUp(Player player) {
        player.addStrenght(warriorConfig.getStrengthRate());
        player.addStamina(warriorConfig.getStaminaRate());
        player.addIntelegence(warriorConfig.getIntelligenceRate());
        player.addAgility(warriorConfig.getAgilityRate());
    }

    @Override
    public int mDefence(Player player) {
        double mDef = player.getIntelligence();
        return (int) mDef;
    }

    @Override
    public int pDefence(Player player) {
        double pDef = player.getStrength() + player.getAgility() / 2;
        return (int) pDef;
    }

    @Override
    public double pCriticalChanse(Player player) {
        return 0;
    }

    @Override
    public double mCriticalChanse(Player player) {
        return 0;
    }
}
