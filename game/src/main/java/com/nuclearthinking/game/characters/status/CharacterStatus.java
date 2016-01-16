package com.nuclearthinking.game.characters.status;

import com.nuclearthinking.game.characters.CharacterObject;

/**
 * Created by Izonami on 16.01.2016.
 */
public class CharacterStatus
{
    CharacterObject _characterObject;

    private double _curHp = 0;

    public CharacterStatus(CharacterObject activeCharacter)
    {
        _characterObject = activeCharacter;
    }

    public void updateHp(double value, CharacterObject attacker)
    {
        if (getActiveCharacter().isDead())
        {
            return;
        }

        if (value > 0)
        {
            setCurrentHp(Math.max(getCurrentHp() - value, 0));
        }

        if (getActiveCharacter().getCurrentHp() < 0.5)
        {
            getActiveCharacter().fillDie(attacker);
        }
    }

    public final double getCurrentHp()
    {
        return _curHp;
    }

    public void setCurrentHp(double newHp)
    {
        if (getActiveCharacter().isDead())
        {
            return;
        }

        _curHp = newHp;
    }

    public CharacterObject getActiveCharacter()
    {
        return _characterObject;
    }
}
