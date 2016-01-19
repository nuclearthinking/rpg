package com.nuclearthinking.game.characters.stats;

import com.nuclearthinking.game.characters.CharacterObject;
import com.nuclearthinking.game.enums.Stats;
import com.nuclearthinking.game.model.skills.Skill;

/**
 * Created by kuksin-mv on 15.01.2016.
 */
public class CharacterStat
{
    private final CharacterObject _activeCharacterObject;
    private long _exp = 0;
    private byte _level = 1;

    public CharacterStat(CharacterObject activeCharacterObject)
    {
        _activeCharacterObject = activeCharacterObject;
    }

    public final double calcStat(Stats stat, double init)
    {
        return calcStat(stat, null, null, init);
    }

    public final double calcStat(Stats stats, CharacterObject target, Skill skill, double initVal)
    {
        double value = initVal;

        final int id = stats.ordinal();
        final Calculator c = _activeCharacterObject.getCalculators()[id];

        if ((c == null) || (c.size() == 0))
        {
            return value;
        }

        value = c.calc(_activeCharacterObject, target, skill, value);

        return value;
    }

    public CharacterObject getActiveChar()
    {
        return _activeCharacterObject;
    }

    // BASIC STATS
    /*MAX_HP("maxHp"),
    MAX_MP("maxMp"),
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
    */

    public int getMaxHp()
    {
        return (int) calcStat(Stats.MAX_HP, _activeCharacterObject.getTemplate().getBaseHpMax());
    }

    public int getMaxMp()
    {
        return (int) calcStat(Stats.MAX_MP, _activeCharacterObject.getTemplate().getBaseMpMax());
    }

    public int getMaxHpRegen()
    {
        return (int) calcStat(Stats.MAX_RECOVERABLE_HP, _activeCharacterObject.getTemplate().getBaseHpRegen());
    }

    public int getMaxMpRegen()
    {
        return (int) calcStat(Stats.REGENERATE_MP_RATE, _activeCharacterObject.getTemplate().getBaseMpRegen());
    }

    public int getPDef()
    {
        return (int) calcStat(Stats.POWER_DEFENCE, _activeCharacterObject.getTemplate().getBasePDef());
    }

    public int getMDef()
    {
        return (int) calcStat(Stats.MAGIC_DEFENCE, _activeCharacterObject.getTemplate().getBaseMDef());
    }

    public int getPAtk()
    {
        return (int) calcStat(Stats.POWER_ATTACK, _activeCharacterObject.getTemplate().getBasePAtk());
    }

    public int getMAtk()
    {
        return (int) calcStat(Stats.MAGIC_ATTACK, _activeCharacterObject.getTemplate().getBaseMAtk());
    }

    public int getPAtkSpd()
    {
        return (int) calcStat(Stats.POWER_ATTACK_SPEED, _activeCharacterObject.getTemplate().getBasePAtkSpd());
    }

    public int getMAtkSpd()
    {
        return (int) calcStat(Stats.MAGIC_ATTACK_SPEED, _activeCharacterObject.getTemplate().getBaseMAtkSpd());
    }

    public int getSTR()
    {
        return (int) calcStat(Stats.STAT_STR, _activeCharacterObject.getTemplate().getBaseSTR());
    }

    public int getCON()
    {
        return (int) calcStat(Stats.STAT_CON, _activeCharacterObject.getTemplate().getBaseCON());
    }

    public int getDEX()
    {
        return (int) calcStat(Stats.STAT_DEX, _activeCharacterObject.getTemplate().getBaseDEX());
    }

    public int getINT()
    {
        return (int) calcStat(Stats.STAT_INT, _activeCharacterObject.getTemplate().getBaseINT());
    }

    public int getWIT()
    {
        return (int) calcStat(Stats.STAT_WIT, _activeCharacterObject.getTemplate().getBaseWIT());
    }

    public int getMEN()
    {
        return (int) calcStat(Stats.STAT_MEN, _activeCharacterObject.getTemplate().getBaseMEN());
    }

    public byte getLevel()
    {
        return _level;
    }

    public void setLevel(byte value)
    {
        _level = value;
    }

    public long getExp()
    {
        return _exp;
    }

    public void setExp(long value)
    {
        _exp = value;
    }
}
