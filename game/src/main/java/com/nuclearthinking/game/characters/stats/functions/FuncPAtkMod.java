package com.nuclearthinking.game.characters.stats.functions;

import com.nuclearthinking.game.characters.Player;
import com.nuclearthinking.game.enums.BaseStats;
import com.nuclearthinking.game.enums.Stats;
import com.nuclearthinking.game.model.skills.Skill;

/**
 * Created by kuksin-mv on 14.01.2016.
 */
public class FuncPAtkMod extends AbstractFunction
{
    private static final FuncPAtkMod _fpa_instance = new FuncPAtkMod();

    public static AbstractFunction getInstance()
    {
        return _fpa_instance;
    }

    private FuncPAtkMod()
    {
        super(Stats.POWER_ATTACK, 1, null, 0);
    }

    @Override
    public double calc(Player effector, Player effected, Skill skill, double initVal)
    {
        return initVal * BaseStats.STR.calcBonus(effector);
    }
}