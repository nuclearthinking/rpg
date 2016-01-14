package com.nuclearthinking.game.enums;

import java.util.NoSuchElementException;

/**
 * Created by kuksin-mv on 14.01.2016.
 */
public enum Stats
{
    MAX_HP("maxHp"),
    MAX_MP("maxMp"),
    MAX_CP("maxCp"),
    MAX_RECOVERABLE_HP("maxRecoverableHp"),
    MAX_RECOVERABLE_MP("maxRecoverableMp"),
    REGENERATE_HP_RATE("regHp"),
    REGENERATE_MP_RATE("regMp"),

    POWER_DEFENCE("pDef"),
    MAGIC_DEFENCE("mDef"),
    POWER_ATTACK("pAtk"),
    MAGIC_ATTACK("mAtk"),
    PHYSICAL_SKILL_POWER("physicalSkillPower"),
    POWER_ATTACK_SPEED("pAtkSpd"),
    MAGIC_ATTACK_SPEED("mAtkSpd"),

    CRITICAL_DAMAGE("critDmg"),
    MAGIC_CRIT_DMG("mCritPower"),

    // BASIC STATS
    STAT_STR("Strength"),
    STAT_CON("CON"),
    STAT_DEX("Dexterity"),
    STAT_INT("Intelligent"),
    STAT_WIT("Wisdom"),
    STAT_MEN("Mentality");

    public static final int NUM_STATS = values().length;

    private String _value;

    public String getValue()
    {
        return _value;
    }

    Stats(String s)
    {
        _value = s;
    }

    public static Stats valueOfXml(String name)
    {
        name = name.intern();
        for (Stats s : values())
        {
            if (s.getValue().equals(name))
            {
                return s;
            }
        }

        throw new NoSuchElementException("Unknown name '" + name + "' for enum Stats");
    }
}
