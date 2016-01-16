package com.nuclearthinking.game.characters;

import com.nuclearthinking.game.characters.stats.PlayableStat;
import com.nuclearthinking.game.characters.templates.CharacterTemplate;

/**
 * Created by kuksin-mv on 15.01.2016.
 */
public class PlayableObject extends ChracterObject
{
    public PlayableObject(int objectId, CharacterTemplate template)
    {
        super(objectId, template);
    }

    @Override
    public PlayableStat getStat()
    {
        return (PlayableStat) super.getStat();
    }

    @Override
    public void initCharStat()
    {
        setStat(new PlayableStat(this));
    }

    @Override
    public boolean canBeAttacked()
    {
        return true;
    }

    @Override
    public boolean isPlayable()
    {
        return true;
    }

    @Override
    public int getId()
    {
        return 0;
    }
}
