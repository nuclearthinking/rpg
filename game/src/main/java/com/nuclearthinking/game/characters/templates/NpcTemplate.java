package com.nuclearthinking.game.characters.templates;

import com.nuclearthinking.game.model.StatsSet;
import com.nuclearthinking.game.model.interfaces.IIdentifiable;

/**
 * Created by kuksin-mv on 15.01.2016.
 */
public class NpcTemplate extends CharacterTemplate implements IIdentifiable {
    private int _id;
    private byte _level;
    private String _name;

    private boolean _attackable;
    private boolean _targetable;

    public NpcTemplate(StatsSet set) {
        super(set);
    }

    @Override
    public void set(StatsSet set) {
        super.set(set);

        _id = set.getInt("id");
        _level = set.getByte("level", (byte) 5);
        _name = set.getString("name", "");
    }

    @Override
    public int getId() {
        return _id;
    }

    public byte getLevel() {
        return _level;
    }

    public String getName() {
        return _name;
    }

    public boolean isAttackable() {
        return _attackable;
    }

    public boolean isTargetable() {
        return _targetable;
    }
}
