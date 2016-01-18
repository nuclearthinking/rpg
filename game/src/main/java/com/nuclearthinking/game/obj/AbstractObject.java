package com.nuclearthinking.game.obj;

import com.nuclearthinking.game.characters.interfaces.IName;

/**
 * Created by kuksin-mv on 18.01.2016.
 */
public abstract class AbstractObject implements IName
{
    public String _name;
    public int _hitPoints;
    public static final double DIFFICULITY = 1.0;
    public double _strength = 10;
    public double _intelligence = 10;
    public double _agility = 10;
    public double _stamina = 10;

    public AbstractObject()
    {
        initStat();
    }

    public int getHitPoints()
    {
        return _hitPoints;
    }

    public void setHitPoints(int hitPoints)
    {
        _hitPoints = hitPoints;
    }

    public void initHitPoints()
    {
        _hitPoints = (int) getStamina() * 2;
    }

    public double getStrength()
    {
        return _strength;
    }

    public double getIntelligence()
    {
        return _intelligence;
    }

    public double getAgility()
    {
        return _agility;
    }

    public double getStamina()
    {
        return _stamina;
    }

    public void updateHp(int dmg)
    {
        setHitPoints(_hitPoints - dmg);
    }

    @Override
    public String getName()
    {
        return _name;
    }

    public void setName(String name)
    {
        _name = name;
    }

    public void initStat()
    {
        initHitPoints();
    }
}
