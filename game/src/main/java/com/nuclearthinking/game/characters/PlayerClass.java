package com.nuclearthinking.game.characters;

/**
 * Date: 22.12.2015
 * Time: 19:53
 *
 * @author Vladislav Radchenko (onifent@gmail.com)
 */

public abstract class PlayerClass {
    public double pCriticalChanse(CharacterObject characterObject) {
        return 5 + (characterObject.getAgility() / (10 * (characterObject.getLevel() * 0.5)));
    }

    public double mCriticalChanse(CharacterObject characterObject) {
        return 5 + (characterObject.getIntelligence() / (10 * characterObject.getLevel() * 0.5));
    }
}
