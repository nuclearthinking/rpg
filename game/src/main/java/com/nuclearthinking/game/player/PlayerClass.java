package com.nuclearthinking.game.player;

import com.nuclearthinking.game.characters.interfaces.IPlayerClass;

/**
 * Date: 22.12.2015
 * Time: 19:53
 *
 * @author Vladislav Radchenko (onifent@gmail.com)
 */

public abstract class PlayerClass implements IPlayerClass {
    public double pCriticalChanse(Player characterObject) {
        return 5 + (characterObject.getAgility() / (10 * (characterObject.getLevel() * 0.5)));
    }

    public double mCriticalChanse(Player characterObject) {
        return 5 + (characterObject.getIntelligence() / (10 * characterObject.getLevel() * 0.5));
    }

    public boolean isMage() {
        return false;
    }

    public boolean isRogue() {
        return false;
    }

    public boolean isWarrior() {
        return false;
    }
}
