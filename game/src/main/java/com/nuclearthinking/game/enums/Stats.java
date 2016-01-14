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
    POWER_ATTACK_SPEED("pAtkSpd"),
    MAGIC_ATTACK_SPEED("mAtkSpd"),

    CRITICAL_DAMAGE("critDmg"),
    MAGIC_CRIT_DMG("mCritPower"),
    MAGIC_CRIT_RATE("mCritRate"),

    MOVE_SPEED("runSpd"),
    EVASION_RATE("rEvas"),
    ACCURACY_COMBAT("accCombat"),

    // BASIC STATS
    STAT_STR("STR"),
    STAT_CON("CON"),
    STAT_DEX("DEX"),
    STAT_INT("INT"),
    STAT_WIT("WIT"),
    STAT_MEN("MEN");

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
