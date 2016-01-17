package com.nuclearthinking.game.characters.stats;

import com.nuclearthinking.game.characters.PlayableObject;

/**
 * Created by kuksin-mv on 15.01.2016.
 */
public class PlayableStat extends CharacterStat
{
    public PlayableStat(PlayableObject activePlayer)
    {
        super(activePlayer);
    }

    public boolean addExp(long value)
    {
        setExp(getExp() + value);
        return true;
    }

    public boolean addLevel(byte value)
    {

        return true;
    }

    public long getExpForLevel(int level)
    {
        return level;
    }

    @Override
    public PlayableObject getActiveChar()
    {
        return (PlayableObject) super.getActiveChar();
    }

    public int getMaxLevel()
    {
        //TODO: Убрать хардход
        return 5;
    }
}
