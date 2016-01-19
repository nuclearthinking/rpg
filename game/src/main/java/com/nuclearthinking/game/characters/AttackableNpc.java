package com.nuclearthinking.game.characters;

import com.nuclearthinking.game.characters.status.AttackableStatus;
import com.nuclearthinking.game.characters.templates.NpcTemplate;

/**
 * Created by kuksin-mv on 15.01.2016.
 */
public class AttackableNpc extends Npc
{
    public AttackableNpc(NpcTemplate template)
    {
        super(template);
    }

    @Override
    public AttackableStatus getStatus()
    {
        return (AttackableStatus) super.getStatus();
    }

    @Override
    public void initCharacterStatus()
    {
        setStatus(new AttackableStatus(this));
    }

    @Override
    public void decreaseCurrentHp(double damage, CharacterObject attacker)
    {
        super.decreaseCurrentHp(damage, attacker);
    }

    @Override
    public boolean canBeAttacked()
    {
        return true;
    }

    @Override
    public boolean isAttackable()
    {
        return true;
    }

    @Override
    public void onSpawn()
    {
        super.onSpawn();
    }

    @Override
    public boolean fillDie(CharacterObject killer)
    {
        if (!super.fillDie(killer))
        {
            return false;
        }

        return true;
    }
}
