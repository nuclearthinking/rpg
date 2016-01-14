package com.nuclearthinking.game.characters.stats.functions;

import com.nuclearthinking.game.characters.Player;
import com.nuclearthinking.game.enums.BaseStats;
import com.nuclearthinking.game.enums.Stats;
import com.nuclearthinking.game.model.skills.Skill;

/**
 * Created by Izonami on 14.01.2016.
 */
public class FuncMDefMod extends AbstractFunction
{
    private static final FuncMDefMod _fmdm_instance = new FuncMDefMod();

    public static AbstractFunction getInstance()
    {
        return _fmdm_instance;
    }

    public FuncMDefMod()
    {
        super(Stats.MAGIC_DEFENCE, 1, null, 0);
    }

    @Override
    public double calc(Player effector, Player effected, Skill skill, double initVal)
    {
        //TODO: Тут надо бы учитывать одетую бижутерию
        return initVal * BaseStats.MEN.calcBonus(effector);
    }
}
