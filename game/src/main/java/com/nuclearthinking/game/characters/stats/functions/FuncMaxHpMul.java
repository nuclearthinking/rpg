package com.nuclearthinking.game.characters.stats.functions;

import com.nuclearthinking.game.characters.CharacterObject;
import com.nuclearthinking.game.enums.BaseStats;
import com.nuclearthinking.game.enums.Stats;
import com.nuclearthinking.game.model.skills.Skill;

/**
 * Created by kuksin-mv on 14.01.2016.
 */
public class FuncMaxHpMul extends AbstractFunction
{
    private static final FuncMaxHpMul _fmhm_instance = new FuncMaxHpMul();

    public static AbstractFunction getInstance()
    {
        return _fmhm_instance;
    }

    private FuncMaxHpMul()
    {
        super(Stats.MAX_HP, 1, null, 0);
    }

    @Override
    public double calc(CharacterObject effector, CharacterObject effected, Skill skill, double initVal)
    {
        return initVal * BaseStats.CON.calcBonus(effector);
    }
}
