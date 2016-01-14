package com.nuclearthinking.game.characters.stats.functions;

import com.nuclearthinking.game.characters.Player;
import com.nuclearthinking.game.enums.BaseStats;
import com.nuclearthinking.game.enums.Stats;
import com.nuclearthinking.game.model.skills.Skill;

/**
 * Created by Izonami on 14.01.2016.
 */
public class FuncAtkEvasion extends AbstractFunction
{
    private static final FuncAtkEvasion _fmae_instance = new FuncAtkEvasion();

    public static AbstractFunction getInstance()
    {
        return _fmae_instance;
    }

    public FuncAtkEvasion()
    {
        super(Stats.EVASION_RATE, 1, null, 0);
    }

    @Override
    public double calc(Player effector, Player effected, Skill skill, double initVal)
    {
        return initVal * BaseStats.DEX.calcBonus(effector);
    }
}
