package com.nuclearthinking.game.model.skills;

import com.nuclearthinking.game.model.StatsSet;
import com.nuclearthinking.game.model.interfaces.IIdentifiable;

import java.util.logging.Logger;

public class Skill implements IIdentifiable {
    private static final Logger LOG = Logger.getLogger(Skill.class.getName());

    private final int _id;
    private final int _level;
    private final String _name;

    public Skill(StatsSet set) {
        _id = set.getInt("skill_id");
        _level = set.getInt("level");
        _name = set.getString("name", "");
    }

    @Override
    public int getId() {
        return _id;
    }

    public int getLevel() {
        return _level;
    }

    public String getName() {
        return _name;
    }

    @Override
    public String toString() {
        return "Skill " + _name + "(" + _id + "," + _level + ")";
    }
}
