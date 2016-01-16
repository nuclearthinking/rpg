package com.nuclearthinking.game.characters.status;

import com.nuclearthinking.game.characters.AttackableNpc;
import com.nuclearthinking.game.characters.CharacterObject;

/**
 * Created by Izonami on 16.01.2016.
 */
public class AttackableStatus extends NpcStatus
{
    public AttackableStatus(AttackableNpc npc)
    {
        super(npc);
    }

    @Override
    public void updateHp(double value, CharacterObject attacker)
    {
        if (getActiveCharacter().isDead())
        {
            return;
        }

        super.updateHp(value, attacker);
    }

    @Override
    public AttackableNpc getActiveCharacter()
    {
        return (AttackableNpc) super.getActiveCharacter();
    }
}
