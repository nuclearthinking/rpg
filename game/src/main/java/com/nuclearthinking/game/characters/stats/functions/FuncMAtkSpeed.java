package com.nuclearthinking.game.characters.stats.functions;

import com.nuclearthinking.game.characters.Player;
import com.nuclearthinking.game.enums.BaseStats;
import com.nuclearthinking.game.enums.Stats;
import com.nuclearthinking.game.model.skills.Skill;

/**
 * Created by Izonami on 14.01.2016.
 */
public class FuncMAtkSpeed extends AbstractFunction
{
    private static final FuncMAtkSpeed _fmas_instance = new FuncMAtkSpeed();

    public static AbstractFunction getInstance()
    {
        return _fmas_instance;
    }

    public FuncMAtkSpeed()
    {
        super(Stats.MAGIC_ATTACK_SPEED, 1, null, 0);
    }

    @Override
    public double calc(Player effector, Player effected, Skill skill, double initVal)
    {
        return initVal * BaseStats.WIT.calcBonus(effector);
    }
}
