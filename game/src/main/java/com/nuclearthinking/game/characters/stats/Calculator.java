package com.nuclearthinking.game.characters.stats;

import com.nuclearthinking.game.characters.ChracterObject;
import com.nuclearthinking.game.characters.stats.functions.AbstractFunction;
import com.nuclearthinking.game.model.skills.Skill;

/**
 * Created by kuksin-mv on 14.01.2016.
 */
public final class Calculator
{
    private static final AbstractFunction[] EMPTY_FUNCS = new AbstractFunction[0];

    private AbstractFunction[] _functions;

    public Calculator()
    {
        _functions = EMPTY_FUNCS;
    }

    public Calculator(Calculator c)
    {
        _functions = c._functions;
    }

    public synchronized void addFunc(AbstractFunction function)
    {
        AbstractFunction[] funcs = _functions;
        AbstractFunction[] tmp = new AbstractFunction[funcs.length + 1];

        final int order = function.getOrder();
        int i;

        for (i = 0; (i < funcs.length) && (order >= funcs[i].getOrder()); i++)
        {
            tmp[i] = funcs[i];
        }

        tmp[i] = function;

        for (; i < funcs.length; i++)
        {
            tmp[i + 1] = funcs[i];
        }

        _functions = tmp;
    }

    //Производим расчет на основе формул
    public double calc(ChracterObject caster, ChracterObject target, Skill skill, double initVal)
    {
        double value = initVal;
        for (AbstractFunction func : _functions)
        {
            value = func.calc(caster, target, skill, value);
        }
        return value;
    }
}
