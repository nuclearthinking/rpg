package com.nuclearthinking.game.characters.stats.functions;

import com.nuclearthinking.game.characters.Player;
import com.nuclearthinking.game.enums.BaseStats;
import com.nuclearthinking.game.enums.Stats;
import com.nuclearthinking.game.model.skills.Skill;

/**
 * Created by kuksin-mv on 14.01.2016.
 */
public class FuncMaxMpMul extends AbstractFunction
{
    private static final FuncMaxMpMul _fmmm_instance = new FuncMaxMpMul();

    public static AbstractFunction getInstance()
    {
        return _fmmm_instance;
    }

    public FuncMaxMpMul()
    {
        super(Stats.MAX_MP, 1, null, 0);
    }

    @Override
    public double calc(Player effector, Player effected, Skill skill, double initVal)
    {
        return initVal * BaseStats.MEN.calcBonus(effector);
    }
}
