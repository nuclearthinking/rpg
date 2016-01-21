package com.nuclearthinking.game.characters.stats.functions;

import com.nuclearthinking.game.characters.CharacterObject;
import com.nuclearthinking.game.enums.BaseStats;
import com.nuclearthinking.game.enums.Stats;
import com.nuclearthinking.game.model.skills.Skill;

/**
 * Created by Izonami on 14.01.2016.
 */
public class FuncMoveSpeed extends AbstractFunction {
    private static final FuncMoveSpeed _fms_instance = new FuncMoveSpeed();

    public static AbstractFunction getInstance() {
        return _fms_instance;
    }

    public FuncMoveSpeed() {
        super(Stats.MOVE_SPEED, 1, null, 0);
    }

    @Override
    public double calc(CharacterObject effector, CharacterObject effected, Skill skill, double initVal) {
        return initVal * BaseStats.DEX.calcBonus(effector);
    }
}
