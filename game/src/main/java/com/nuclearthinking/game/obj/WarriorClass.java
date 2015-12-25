package com.nuclearthinking.game.obj;

/**
 * Date: 25.12.2015
 * Time: 13:06
 *
 * @author Vladislav Radchenko (onifent@gmail.com)
 */

public class WarriorClass extends PlayerClass implements IPlayerClass{
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
