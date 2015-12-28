package com.nuclearthinking.game.obj;

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
    public int pDamage(Player player) {
        return 0;
    }

    @Override
    public int mDamage(Player player) {
        return 0;
    }

    @Override
    public void levelUp(Player player) {
        player.addStrenght(mConfig.getStrengthRate());
        player.addStamina(mConfig.getStaminaRate());
        player.addIntelegence(mConfig.getIntelligenceRate());
        player.addAgility(mConfig.getAgilityRate());
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
}
