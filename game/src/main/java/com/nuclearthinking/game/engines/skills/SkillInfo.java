package com.nuclearthinking.game.engines.skills;

import com.nuclearthinking.game.model.StatsSet;
import com.nuclearthinking.game.model.skills.Skill;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Izonami on 26.12.2015.
 */
public class SkillInfo {
    public int id;
    public String name;
    public StatsSet[] sets;
    public int currentLevel;
    public List<Skill> skills = new ArrayList<>();
    public List<Skill> currentSkills = new ArrayList<>();
}
