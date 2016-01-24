package com.nuclearthinking.game.characters.stats.functions;

import com.nuclearthinking.game.characters.CharacterObject;
import com.nuclearthinking.game.enums.BaseStats;
import com.nuclearthinking.game.enums.Stats;
import com.nuclearthinking.game.model.skills.Skill;

/**
 * Created by kuksin-mv on 14.01.2016.
 */
public class FuncMAtkMod extends AbstractFunction {
    private static final FuncMAtkMod _fmam_instance = new FuncMAtkMod();

    public static AbstractFunction getInstance() {
        return _fmam_instance;
    }

    public FuncMAtkMod() {
        super(Stats.MAGIC_ATTACK, 1, null, 0);
    }

    @Override
    public double calc(CharacterObject effector, CharacterObject effected, Skill skill, double initVal) {
        return initVal * BaseStats.INT.calcBonus(effector);
    }
}
