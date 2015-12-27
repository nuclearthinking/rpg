package com.nuclearthinking.game.obj;

import com.nuclearthinking.game.engines.ClassConfigReader;
import com.nuclearthinking.game.obj.jsonpojo.RogueConfig;

/**
 * Date: 25.12.2015
 * Time: 13:06
 *
 * @author Vladislav Radchenko (onifent@gmail.com)
 */

public class RogueClass extends PlayerClass implements IPlayerClass {
    ClassConfigReader classConfigReader = new ClassConfigReader();
    private RogueConfig rConf = null;

    private RogueClass() {
        rConf = classConfigReader.getClassConfig().getRogueConfig();
    }

    public static RogueClass getInstance() {
        return RogueClassHolder.INSTANCE;
    }

    @Override
    public int pDamage(Player player) {
        double agi = player.getAgility();
        int level = player.getLevel();
        double pdmg = agi*0.8+level*2;
        return (int) pdmg;
    }

    @Override
    public int mDamage(Player player) {
        return 0;
    }

    @Override
    public void levelUp(Player player) {
        player.addStrenght(rConf.getStrengthRate());
        player.addStamina(rConf.getStaminaRate());
        player.addIntelegence(rConf.getIntelligenceRate());
        player.addAgility(rConf.getAgilityRate());
    }

    @Override
    public int mDefence(Player player) {
        return 0;
    }

    @Override
    public int pDefence(Player player) {
        return 0;
    }

    @Override
    public double pCriticalChanse(Player player) {
        return 0;
    }

    @Override
    public double mCriticalChanse(Player player) {
        return 0;
    }

    private static class RogueClassHolder {

        private static final RogueClass INSTANCE = new RogueClass();
    }
}
