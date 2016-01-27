package com.nuclearthinking.game.characters.stats.functions;

import com.nuclearthinking.game.characters.CharacterObject;
import com.nuclearthinking.game.enums.BaseStats;
import com.nuclearthinking.game.enums.Stats;
import com.nuclearthinking.game.model.skills.Skill;

/**
 * Created by Izonami on 14.01.2016.
 */
public class FuncMAtkSpeed extends AbstractFunction {
    private static final FuncMAtkSpeed _fmas_instance = new FuncMAtkSpeed();

    public FuncMAtkSpeed() {
        super(Stats.MAGIC_ATTACK_SPEED, 1, null, 0);
    }

    public static AbstractFunction getInstance() {
        return _fmas_instance;
    }

    @Override
    public double calc(CharacterObject effector, CharacterObject effected, Skill skill, double initVal) {
        return initVal * BaseStats.WIT.calcBonus(effector);
    }
}
