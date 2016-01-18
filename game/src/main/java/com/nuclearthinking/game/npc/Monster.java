package com.nuclearthinking.game.npc;

import com.nuclearthinking.game.obj.AbstractObject;

/**
 * Created by Izonami on 17.01.2016.
 */
public class Monster extends AbstractObject
{
    private static final double DIFFICULITY = 1.0;
    private byte _level = 1;

    public Monster(String name, byte level)
    {
        super();
        setName(name);
        setLevel(level);
    }

    public int getPDef()
    {
        return (int) (getStrength() / 2 * DIFFICULITY);
    }

    public int getHitPoints()
    {
        return (int) (_hitPoints * DIFFICULITY);
    }

    public void setHitPoints(int hitPoints)
    {
        _hitPoints = hitPoints;
    }

    public byte getLevel()
    {
        return _level;
    }

    public void setLevel(byte level)

    {
        _level = level;
    }

    public void updateHp(int dmg)
    {
        setHitPoints(_hitPoints - dmg);
    }

    public void fillDie()
    {
        System.out.println("Monster Die");
        setHitPoints(0);
        getReward();
    }

    public void getReward()
    {
        System.out.println("Ваша награда");
    }
}
