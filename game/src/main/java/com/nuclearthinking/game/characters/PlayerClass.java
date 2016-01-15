package com.nuclearthinking.game.characters;

/**
 * Date: 22.12.2015
 * Time: 19:53
 *
 * @author Vladislav Radchenko (onifent@gmail.com)
 */

public abstract class PlayerClass {
    public double pCriticalChanse(Player player) {
        return 5 + (player.getAgility() / (10 * (player.getLevel() * 0.5)));
    }

    public double mCriticalChanse(Player player) {
        return 5 + (player.getIntelligence() / (10 * player.getLevel() * 0.5));
    }
}
