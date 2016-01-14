package com.nuclearthinking.game.enums;

import com.nuclearthinking.game.characters.Player;
import com.nuclearthinking.game.characters.interfaces.IBaseStat;
import com.nuclearthinking.game.characters.stats.calcstats.*;

import java.util.NoSuchElementException;
import java.util.logging.Logger;

/**
 * Created by kuksin-mv on 14.01.2016.
 */
public enum BaseStats
{
    STR(new STR()),
    INT(new INT()),
    DEX(new DEX()),
    WIT(new WIT()),
    CON(new CONN()),
    MEN(new MEN());

    private static final Logger _log = Logger.getLogger(BaseStats.class.getName());

    public static final int MAX_STAT_VALUE = 100;

    public static final double[] STRbonus = new double[MAX_STAT_VALUE];
    protected static final double[] INTbonus = new double[MAX_STAT_VALUE];
    protected static final double[] DEXbonus = new double[MAX_STAT_VALUE];
    protected static final double[] WITbonus = new double[MAX_STAT_VALUE];
    protected static final double[] CONbonus = new double[MAX_STAT_VALUE];
    protected static final double[] MENbonus = new double[MAX_STAT_VALUE];

    private final IBaseStat _stat;

    public final String getValue()
    {
        return _stat.getClass().getSimpleName();
    }

    BaseStats(IBaseStat s)
    {
        _stat = s;
    }

    public final double calcBonus(Player player)
    {
        if (player != null)
        {
            return _stat.calcBonus(player);
        }

        return 1;
    }

    public static final BaseStats valueOfXml(String name)
    {
        name = name.intern();
        for (BaseStats s : values())
        {
            if (s.getValue().equalsIgnoreCase(name))
            {
                return s;
            }
        }
        throw new NoSuchElementException("Unknown name '" + name + "' for enum BaseStats");
    }
}
