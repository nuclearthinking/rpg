package com.nuclearthinking.game.characters.instance;

import com.nuclearthinking.game.characters.PlayableCharacter;
import com.nuclearthinking.game.characters.templates.CharacterTemplate;
import com.nuclearthinking.game.characters.templates.PlayerTemplate;
import com.nuclearthinking.game.enums.ClassId;

/**
 * Created by kuksin-mv on 15.01.2016.
 *
 * Тут наконец то будет собираться именно игрок
 */
public class PlayableInstance extends PlayableCharacter
{
    protected int _class;


    public PlayableInstance(int objectId, CharacterTemplate template)
    {
        super(objectId, template);
    }

    public static PlayableInstance create(PlayerTemplate template, String name)
    {
        PlayableInstance player = new PlayableInstance(1, template);
        player.setName(name);
        player.setClass(player.getClassId());

        return player.createPlayer() ? player : null;
    }

    @Override
    public final PlayerTemplate getTemplate()
    {
        return (PlayerTemplate) super.getTemplate();
    }

    public void setClass(ClassId classId)
    {
        _class = classId.ordinal();
    }

    public ClassId getClassId()
    {
        return getTemplate().getClassId();
    }

    private boolean createPlayer()
    {
        System.out.println(
                        "Object ID:" + getObjectId() + " " +
                                "Name:" + getName() + " " +
                                "Level:" + getLevel() + " " +
                                "ClassID:" + getClassId()
        );
        return true;
    }
}
