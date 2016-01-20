package com.nuclearthinking.game.npc;

import com.nuclearthinking.game.obj.AbstractObject;
import com.nuclearthinking.game.player.Player;

/**
 * Created by Izonami on 17.01.2016.
 */
public class Monster extends AbstractObject
{
    private byte _level;
    private double DIFFICULITY = 1.023;

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
        return (int) (_hitPoints * DIFFICULITY * getLevel());
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

    public void fillDie(Player player)
    {
        System.out.println(getName() + " " + "Die");
        setHitPoints(0);
        getReward();
        player.setExp(200);
    }

    public void getReward()
    {
        System.out.println("Ваша награда");
    }
}
