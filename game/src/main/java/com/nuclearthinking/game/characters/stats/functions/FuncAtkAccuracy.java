package com.nuclearthinking.game.characters.stats.functions;

import com.nuclearthinking.game.characters.Player;
import com.nuclearthinking.game.enums.BaseStats;
import com.nuclearthinking.game.enums.Stats;
import com.nuclearthinking.game.model.skills.Skill;

/**
 * Created by Izonami on 14.01.2016.
 */
public class FuncAtkAccuracy extends AbstractFunction
{
    private static final FuncAtkAccuracy _faa_instance = new FuncAtkAccuracy();

    public static AbstractFunction getInstance()
    {
        return _faa_instance;
    }

    public FuncAtkAccuracy()
    {
        super(Stats.ACCURACY_COMBAT, 1, null, 0);
    }

    @Override
    public double calc(Player effector, Player effected, Skill skill, double initVal)
    {
        return initVal * BaseStats.DEX.calcBonus(effector);
    }
}
