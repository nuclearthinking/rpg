package com.nuclearthinking.game.characters.stats;

import com.nuclearthinking.game.characters.CharacterObject;
import com.nuclearthinking.game.characters.stats.functions.*;

/**
 * Created by kuksin-mv on 14.01.2016.
 *
 * Тут предлагаю производить все расчеты со статами и эффектами
 */
public final class Formulas
{
    public static void addFuncsToNewCharacter(CharacterObject cha)
    {
        if (cha.isPlayer() || cha.isMonster())
        {
            cha.addStatFunc(FuncMaxHpMul.getInstance());
            cha.addStatFunc(FuncMaxMpMul.getInstance());
            cha.addStatFunc(FuncPAtkMod.getInstance());
            cha.addStatFunc(FuncMAtkMod.getInstance());
            cha.addStatFunc(FuncPDefMod.getInstance());
            cha.addStatFunc(FuncMDefMod.getInstance());
            cha.addStatFunc(FuncAtkCritical.getInstance());
            cha.addStatFunc(FuncMAtkCritical.getInstance());
            cha.addStatFunc(FuncAtkAccuracy.getInstance());
            cha.addStatFunc(FuncAtkEvasion.getInstance());
            cha.addStatFunc(FuncPAtkSpeed.getInstance());
            cha.addStatFunc(FuncMAtkSpeed.getInstance());
            cha.addStatFunc(FuncMoveSpeed.getInstance());

            //TODO: Добавить установку статов с брони
        }
    }
}
