package com.nuclearthinking.game.characters;

/**
 * Date: 22.12.2015
 * Time: 19:53
 *
 * @author Vladislav Radchenko (onifent@gmail.com)
 */

public abstract class PlayerClass {
    public double pCriticalChanse(ChracterObject chracterObject) {
        return 5 + (chracterObject.getAgility() / (10 * (chracterObject.getLevel() * 0.5)));
    }

    public double mCriticalChanse(ChracterObject chracterObject) {
        return 5 + (chracterObject.getIntelligence() / (10 * chracterObject.getLevel() * 0.5));
    }
}
