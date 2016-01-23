package com.nuclearthinking.game.characters.templates;

import com.nuclearthinking.game.enums.ClassId;
import com.nuclearthinking.game.model.StatsSet;

/**
 * Created by kuksin-mv on 15.01.2016.
 * TODO: Пока тут сделано для одного уровня, нужно придумать как делать для большего кол-ва уровней
 */
public class PlayerTemplate extends CharacterTemplate {
    private final ClassId _classId;

    private final float[] _baseHp;
    private final float[] _baseMp;

    private final double[] _baseHpRegen;
    private final double[] _baseMpRegen;

    public PlayerTemplate(StatsSet set) {
        super(set);

        _classId = ClassId.getClassId(set.getInt("classId"));
        setRace(_classId.getRace());
        _baseHp = new float[3];
        _baseMp = new float[3];

        _baseHpRegen = new double[3];
        _baseMpRegen = new double[3];
    }

    public ClassId getClassId() {
        return _classId;
    }

    public float getBaseHp(int level) {
        return _baseHp[level];
    }

    public float getBaseMp(int level) {
        return _baseMp[level];
    }

    public double getBaseHpRegen(int level) {
        return _baseHpRegen[level];
    }

    public double getBaseMpRegen(int level) {
        return _baseMpRegen[level];
    }

}
