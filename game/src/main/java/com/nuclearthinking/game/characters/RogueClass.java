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
    public int pDamage(Player player) {
        double pDmg = player.getAgility() * 0.8 + player.getLevel() * 2;
        return (int) pDmg;
    }

    @Override
    public int mDamage(Player player) {
        return (int) player.getIntelligence();
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
        double mDef = player.getIntelligence();
        return (int) mDef;
    }

    @Override
    public int pDefence(Player player) {
        double pDef = player.getStrength() / 2 + player.getAgility();
        return (int) pDef;
    }

}
