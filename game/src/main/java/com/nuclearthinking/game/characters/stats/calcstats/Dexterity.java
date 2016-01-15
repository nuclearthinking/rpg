package com.nuclearthinking.game.characters.stats.calcstats;

import com.nuclearthinking.game.characters.Player;
import com.nuclearthinking.game.characters.interfaces.IBaseStat;
import com.nuclearthinking.game.enums.BaseStats;

/**
 * Created by kuksin-mv on 14.01.2016.
 */
public class Dexterity implements IBaseStat
{
    @Override
    public double calcBonus(Player player)
    {
        return BaseStats.DEXbonus[player.getDEX()];
    }
}
