package com.nuclearthinking.game.characters.stats.calcstats;

import com.nuclearthinking.game.characters.ChracterObject;
import com.nuclearthinking.game.characters.interfaces.IBaseStat;
import com.nuclearthinking.game.enums.BaseStats;

/**
 * Created by kuksin-mv on 14.01.2016.
 */
public class Strength implements IBaseStat
{
    @Override
    public double calcBonus(ChracterObject chracterObject)
    {
        return BaseStats.STRbonus[chracterObject.getSTR()];
    }
}
