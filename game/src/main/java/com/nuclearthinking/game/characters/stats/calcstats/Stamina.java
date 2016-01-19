package com.nuclearthinking.game.characters.stats.calcstats;

import com.nuclearthinking.game.characters.CharacterObject;
import com.nuclearthinking.game.characters.interfaces.IBaseStat;
import com.nuclearthinking.game.enums.BaseStats;

/**
 * Created by kuksin-mv on 14.01.2016.
 */
public final class Stamina implements IBaseStat
{
    @Override
    public double calcBonus(CharacterObject characterObject)
    {
        return BaseStats.CONbonus[characterObject.getCON()];
    }
}
