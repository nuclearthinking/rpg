package com.nuclearthinking.game.characters.stats.functions;

import com.nuclearthinking.game.characters.Player;
import com.nuclearthinking.game.enums.BaseStats;
import com.nuclearthinking.game.enums.Stats;
import com.nuclearthinking.game.model.skills.Skill;

/**
 * Created by Izonami on 14.01.2016.
 */
public class FuncPDefMod extends AbstractFunction
{
    private static final FuncPDefMod _fpdm_instance = new FuncPDefMod();

    public static AbstractFunction getInstance()
    {
        return _fpdm_instance;
    }

    public FuncPDefMod()
    {
        super(Stats.POWER_DEFENCE, 1, null, 0);
    }

    @Override
    public double calc(Player effector, Player effected, Skill skill, double initVal)
    {
        //TODO: Тут надо бы учитывать одетую броню
        return initVal * BaseStats.CON.calcBonus(effector);
    }
}
