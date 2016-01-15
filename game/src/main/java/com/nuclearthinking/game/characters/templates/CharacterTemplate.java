package com.nuclearthinking.game.characters.templates;

import com.nuclearthinking.game.enums.Race;
import com.nuclearthinking.game.model.StatsSet;
import com.nuclearthinking.game.model.skills.Skill;

import java.util.Collections;
import java.util.Map;

/**
 * Created by kuksin-mv on 13.01.2016.
 */
public class CharacterTemplate
{
    //Базовые статы
    private int _baseSTR;
    private int _baseCON;
    private int _baseDEX;
    private int _baseINT;
    private int _baseWIT;
    private int _baseMEN;

    private float _baseHpMax;
    private float _baseMpMax;
    private float _baseHpReg;
    private float _baseMpReg;

    private int _basePAtk;
    private int _baseMAtk;
    private int _basePDef;
    private int _baseMDef;

    private int _basePAtkSpd;
    private int _baseMAtkSpd;

    private int _baseAttackRange;
    private int _baseCritRate;
    private int _baseMCritRate;

    private Race _race;

    public CharacterTemplate(StatsSet set)
    {
        set(set);
    }

    public void set(StatsSet set)
    {
        _baseSTR = set.getInt("baseSTR", 0);
        _baseCON = set.getInt("baseCON", 0);
        _baseDEX = set.getInt("baseDEX", 0);
        _baseINT = set.getInt("baseINT", 0);
        _baseWIT = set.getInt("baseWIT", 0);
        _baseMEN = set.getInt("baseMEN", 0);
        _baseHpMax = set.getFloat("baseHpMax", 0);
        _baseMpMax = set.getFloat("baseMpMax", 0);
        _baseHpReg = set.getFloat("baseHpReg", 0);
        _baseMpReg = set.getFloat("baseMpReg", 0);
        _basePAtk = set.getInt("basePAtk", 0);
        _baseMAtk = set.getInt("baseMAtk", 0);
        _basePDef = set.getInt("basePDef", 0);
        _baseMDef = set.getInt("baseMDef", 0);
        _basePAtkSpd = set.getInt("basePAtkSpd", 0);
        _baseMAtkSpd = set.getInt("baseMAtkSpd", 0);
        _baseAttackRange = set.getInt("baseAtkRange", 0);
        _baseCritRate = set.getInt("baseCritRate", 0);
        _baseMCritRate = set.getInt("baseMCritRate", 0);
    }

    public int getBaseSTR()
    {
        return _baseSTR;
    }

    public int getBaseCON()
    {
        return _baseCON;
    }

    public int getBaseDEX()
    {
        return _baseDEX;
    }

    public int getBaseINT()
    {
        return _baseINT;
    }

    public int getBaseWIT()
    {
        return _baseWIT;
    }

    public int getBaseMEN()
    {
        return _baseMEN;
    }

    public float getBaseHpMax()
    {
        return _baseHpMax;
    }

    public float getBaseMpMax()
    {
        return _baseMpMax;
    }

    public float getBaseHpRegen()
    {
        return _baseHpReg;
    }

    public float getBaseMpRegen()
    {
        return _baseMpReg;
    }

    public int getBasePAtk()
    {
        return _basePAtk;
    }

    public int getBaseMAtk()
    {
        return _baseMAtk;
    }

    public int getBasePDef()
    {
        return _basePDef;
    }

    public int getBaseMDef()
    {
        return _baseMDef;
    }

    public int getBasePAtkSpd()
    {
        return _basePAtkSpd;
    }

    public int getBaseMAtkSpd()
    {
        return _baseMAtkSpd;
    }

    public int getBaseAttackRange()
    {
        return _baseAttackRange;
    }

    public int getBaseCritRate()
    {
        return _baseCritRate;
    }

    public int getBaseMCritRate()
    {
        return _baseMCritRate;
    }

    public Race getRace()
    {
        return _race;
    }

    public void setRace(Race race)
    {
        _race = race;
    }

    public Map<Integer, Skill> getSkills()
    {
        return Collections.emptyMap();
    }
}
