package com.nuclearthinking.game.characters;

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
}
