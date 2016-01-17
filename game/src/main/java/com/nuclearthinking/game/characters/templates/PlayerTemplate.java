package com.nuclearthinking.game.characters.templates;

import com.nuclearthinking.game.enums.ClassId;
import com.nuclearthinking.game.model.StatsSet;

/**
 * Created by kuksin-mv on 15.01.2016.
 * TODO: Пока тут сделано для одного уровня, нужно придумать как делать для большего кол-ва уровней
 */
public class PlayerTemplate extends CharacterTemplate
{
    private final ClassId _classId;

    private final int[] _baseHp;
    private final int[] _baseMp;

    private final double[] _baseHpRegen;
    private final double[] _baseMpRegen;

    public PlayerTemplate(StatsSet set)
    {
        super(set);

        _classId = ClassId.getClassId(set.getInt("classId"));
        setRace(_classId.getRace());
        _baseHp = new int[200];
        _baseMp = new int[150];

        _baseHpRegen = new double[1];
        _baseMpRegen = new double[1];
    }

    public ClassId getClassId()
    {
        return _classId;
    }

    public int getBaseHp(int level)
    {
        return _baseHp[level];
    }

    public int getBaseMp(int level)
    {
        return _baseMp[level];
    }

    public double getBaseHpRegen(int level)
    {
        return _baseHpRegen[level];
    }

    public double getBaseMpRegen(int level)
    {
        return _baseMpRegen[level];
    }

}
