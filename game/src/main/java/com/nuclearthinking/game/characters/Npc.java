package com.nuclearthinking.game.characters;

import com.nuclearthinking.game.characters.stats.NpcStat;
import com.nuclearthinking.game.characters.templates.NpcTemplate;

/**
 * Created by kuksin-mv on 15.01.2016.
 */
public class Npc extends CharacterObject
{
    public Npc(NpcTemplate template)
    {
        super(2, template);
    }

    public Npc(int npcId)
    {
        //TODO: NPC data
    }

    @Override
    public NpcStat getStat()
    {
        return (NpcStat) super.getStat();
    }

    @Override
    public void initCharStat()
    {
        setStat(new NpcStat(this));
    }

    @Override
    public final NpcTemplate getTemplate()
    {
        return (NpcTemplate) super.getTemplate();
    }

    @Override
    public int getId()
    {
        return getTemplate().getId();
    }

    @Override
    public final int getLevel()
    {
        return getTemplate().getLevel();
    }

    @Override
    public final String getName()
    {
        return getTemplate().getName();
    }

    @Override
    public void onSpawn()
    {
        //TODO: Надо бы думаю сделать
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

    @Override
    public boolean isTargetable()
    {
        return getTemplate().isTargetable();
    }

    @Override
    public boolean isNpc()
    {
        return true;
    }

    @Override
    public String toString()
    {
        return getClass().getSimpleName() + ":" + getName() + "(" + getId() + ")" + "[" + getObjectId() + "]";
    }
}
