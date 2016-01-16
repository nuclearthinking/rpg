package com.nuclearthinking.game.characters.stats.functions;

import com.nuclearthinking.game.characters.CharacterObject;
import com.nuclearthinking.game.enums.BaseStats;
import com.nuclearthinking.game.enums.Stats;
import com.nuclearthinking.game.model.skills.Skill;

/**
 * Created by Izonami on 14.01.2016.
 */
public class FuncAtkCritical extends AbstractFunction
{
    private static final FuncAtkCritical _fac_instance = new FuncAtkCritical();

    public static AbstractFunction getInstance()
    {
        return _fac_instance;
    }

    public FuncAtkCritical()
    {
        super(Stats.CRITICAL_DAMAGE, 1, null, 0);
    }

    @Override
    public double calc(CharacterObject effector, CharacterObject effected, Skill skill, double initVal)
    {
        return initVal * BaseStats.DEX.calcBonus(effector);
    }
}
