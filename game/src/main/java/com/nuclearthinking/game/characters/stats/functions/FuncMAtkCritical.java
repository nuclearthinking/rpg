package com.nuclearthinking.game.characters.stats.functions;

import com.nuclearthinking.game.characters.CharacterObject;
import com.nuclearthinking.game.enums.BaseStats;
import com.nuclearthinking.game.enums.Stats;
import com.nuclearthinking.game.model.skills.Skill;

/**
 * Created by Izonami on 14.01.2016.
 */
public class FuncMAtkCritical extends AbstractFunction {
    private static final FuncMAtkCritical _fmac_instance = new FuncMAtkCritical();

    public FuncMAtkCritical() {
        super(Stats.MAGIC_CRIT_RATE, 1, null, 0);
    }

    public static AbstractFunction getInstance() {
        return _fmac_instance;
    }

    @Override
    public double calc(CharacterObject effector, CharacterObject effected, Skill skill, double initVal) {
        return initVal * BaseStats.MEN.calcBonus(effector);
    }
}
