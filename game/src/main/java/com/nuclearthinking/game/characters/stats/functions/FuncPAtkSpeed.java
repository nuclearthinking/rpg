package com.nuclearthinking.game.characters.stats.functions;

import com.nuclearthinking.game.characters.CharacterObject;
import com.nuclearthinking.game.enums.BaseStats;
import com.nuclearthinking.game.enums.Stats;
import com.nuclearthinking.game.model.skills.Skill;

/**
 * Created by Izonami on 14.01.2016.
 */
public class FuncPAtkSpeed extends AbstractFunction {
    private static final FuncPAtkSpeed _fpas_instance = new FuncPAtkSpeed();

    public FuncPAtkSpeed() {
        super(Stats.POWER_ATTACK_SPEED, 1, null, 0);
    }

    public static AbstractFunction getInstance() {
        return _fpas_instance;
    }

    @Override
    public double calc(CharacterObject effector, CharacterObject effected, Skill skill, double initVal) {
        return initVal * BaseStats.DEX.calcBonus(effector);
    }
}
