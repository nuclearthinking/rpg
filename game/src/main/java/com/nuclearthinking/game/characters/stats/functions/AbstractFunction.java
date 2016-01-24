package com.nuclearthinking.game.characters.stats.functions;

import com.nuclearthinking.game.characters.CharacterObject;
import com.nuclearthinking.game.enums.Stats;
import com.nuclearthinking.game.model.skills.Skill;

/**
 * Created by kuksin-mv on 14.01.2016.
 */
public abstract class AbstractFunction {
    private final Stats _stat;
    private final int _order;
    private final Object _funcOwner;
    private final double _value;

    public AbstractFunction(Stats stat, int order, Object owner, double value) {
        _stat = stat;
        _order = order;
        _funcOwner = owner;
        _value = value;
    }

    public final Object getFuncOwner() {
        return _funcOwner;
    }

    public final int getOrder() {
        return _order;
    }

    public final Stats getStat() {
        return _stat;
    }

    public final double getValue() {
        return _value;
    }

    public abstract double calc(CharacterObject effector, CharacterObject effected, Skill skill, double initVal);
}
