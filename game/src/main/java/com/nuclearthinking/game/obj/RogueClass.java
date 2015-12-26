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
    private RogueConfig rConf = null;

    ClassConfigReader classConfigReader = new ClassConfigReader();

    private RogueClass() {
        rConf = classConfigReader.getClassConfig().getRogueConfig();
    }

    @Override
    public int pDamage(Player player) {
        return 0;
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

    public static RogueClass getInstance() {
        return RogueClassHolder.INSTANCE;
    }
}
