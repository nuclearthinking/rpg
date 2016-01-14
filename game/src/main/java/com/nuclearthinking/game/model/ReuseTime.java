package com.nuclearthinking.game.model;

import com.nuclearthinking.game.model.skills.Skill;

/**
 * Created by kuksin-mv on 11.01.2016.
 */
public class ReuseTime
{
    private final int _id1;
    private final int _id2;
    private final long _reuse;
    private final long _stamp;

    //Принимает скил, время перезарядки скила и время использования
    public ReuseTime(Skill skill, long reuse, long systime)
    {
        _id1 = skill.getId();
        _id2 = skill.getLevel();
        _reuse = reuse;
        _stamp = systime > 0 ? systime : System.currentTimeMillis() + reuse;
    }

    public long getStamp()
    {
        return _stamp;
    }

    public int getItemId()
    {
        return _id1;
    }

    public int getItemObjectId()
    {
        return _id2;
    }

    public int getSkillId()
    {
        return _id1;
    }

    public int getSkillLvl()
    {
        return _id2;
    }

    public long getReuse()
    {
        return _reuse;
    }

    public long getRemaining()
    {
        return Math.max(_stamp - System.currentTimeMillis(), 0);
    }

    public boolean hasNotPassed()
    {
        return System.currentTimeMillis() < _stamp;
    }
}
