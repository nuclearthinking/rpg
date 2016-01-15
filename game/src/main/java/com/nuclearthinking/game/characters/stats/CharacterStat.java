package com.nuclearthinking.game.characters.stats;

import com.nuclearthinking.game.characters.Player;
import com.nuclearthinking.game.enums.Stats;
import com.nuclearthinking.game.model.skills.Skill;

/**
 * Created by kuksin-mv on 15.01.2016.
 */
public class CharacterStat
{
    private final Player _activePlayer;
    private long _exp = 0;
    private byte _level = 1;

    public CharacterStat(Player activePlayer)
    {
        _activePlayer = activePlayer;
    }

    public final double calcStat(Stats stat, double init)
    {
        return calcStat(stat, null, null, init);
    }

    public final double calcStat(Stats stats, Player target, Skill skill, double initVal)
    {
        double value = initVal;

        final int id = stats.ordinal();
        final Calculator c = _activePlayer.getCalculators()[id];

        value = c.calc(_activePlayer, target, skill, value);

        return value;
    }

    public Player getActiveChar()
    {
        return _activePlayer;
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

    public final int getMaxHp()
    {
        return (int) calcStat(Stats.MAX_HP, _activePlayer.getTemplate().getBaseHpMax());
    }

    public final int getMaxMp()
    {
        return (int) calcStat(Stats.MAX_MP, _activePlayer.getTemplate().getBaseMpMax());
    }

    public final int getMaxHpRegen()
    {
        return (int) calcStat(Stats.MAX_RECOVERABLE_HP, _activePlayer.getTemplate().getBaseHpRegen());
    }

    public final int getMaxMpRegen()
    {
        return (int) calcStat(Stats.REGENERATE_MP_RATE, _activePlayer.getTemplate().getBaseMpRegen());
    }

    public final int getPDef()
    {
        return (int) calcStat(Stats.POWER_DEFENCE, _activePlayer.getTemplate().getBasePDef());
    }

    public final int getMDef()
    {
        return (int) calcStat(Stats.MAGIC_DEFENCE, _activePlayer.getTemplate().getBaseMDef());
    }

    public final int getPAtk()
    {
        return (int) calcStat(Stats.POWER_ATTACK, _activePlayer.getTemplate().getBasePAtk());
    }

    public final int getMAtk()
    {
        return (int) calcStat(Stats.MAGIC_ATTACK, _activePlayer.getTemplate().getBaseMAtk());
    }

    public final int getPAtkSpd()
    {
        return (int) calcStat(Stats.POWER_ATTACK_SPEED, _activePlayer.getTemplate().getBasePAtkSpd());
    }

    public final int getMAtkSpd()
    {
        return (int) calcStat(Stats.MAGIC_ATTACK_SPEED, _activePlayer.getTemplate().getBaseMAtkSpd());
    }

    public final int getSTR()
    {
        return (int) calcStat(Stats.STAT_STR, _activePlayer.getTemplate().getBaseSTR());
    }

    public final int getCON()
    {
        return (int) calcStat(Stats.STAT_CON, _activePlayer.getTemplate().getBaseCON());
    }

    public final int getDEX()
    {
        return (int) calcStat(Stats.STAT_DEX, _activePlayer.getTemplate().getBaseDEX());
    }

    public final int getINT()
    {
        return (int) calcStat(Stats.STAT_INT, _activePlayer.getTemplate().getBaseINT());
    }

    public final int getWIT()
    {
        return (int) calcStat(Stats.STAT_WIT, _activePlayer.getTemplate().getBaseWIT());
    }

    public final int getMEN()
    {
        return (int) calcStat(Stats.STAT_MEN, _activePlayer.getTemplate().getBaseMEN());
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