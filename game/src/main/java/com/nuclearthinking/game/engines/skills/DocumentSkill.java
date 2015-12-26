package com.nuclearthinking.game.engines.skills;

import com.nuclearthinking.game.engines.Base;
import com.nuclearthinking.game.model.StatsSet;
import com.nuclearthinking.game.model.skills.Skill;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

/**
 * Created by kuksin-mv on 24.12.2015.
 */
public class DocumentSkill extends Base
{
    public static class SkillInfo
    {
        public int id;
        public String name;
        public StatsSet[] sets;
        public int currentLevel;
        public List<Skill> skills = new ArrayList<>();
        public List<Skill> currentSkills = new ArrayList<>();
    }

    private SkillInfo _currentSkill;
    private final List<Skill> _skillsInFile = new ArrayList<>();

    public DocumentSkill(InputStream file)
    {
        super(file);
    }

    private void setCurrentSkill(SkillInfo skill)
    {
        _currentSkill = skill;
    }

    @Override
    protected StatsSet getStatsSet()
    {
        return _currentSkill.sets[_currentSkill.currentLevel];
    }

    public List<Skill> getSkills()
    {
        return _skillsInFile;
    }

    @Override
    protected void parseDocument(Document doc)
    {
        for (Node n = doc.getFirstChild(); n != null; n = n.getNextSibling())
        {
            if ("list".equalsIgnoreCase(n.getNodeName()))
            {
                for (Node d = n.getFirstChild(); d != null; d = d.getNextSibling())
                {
                    if ("skill".equalsIgnoreCase(d.getNodeName()))
                    {
                        setCurrentSkill(new SkillInfo());
                        parseSkill(d);
                        _skillsInFile.addAll(_currentSkill.skills);
                    }
                }
            }
            else if ("skill".equalsIgnoreCase(n.getNodeName()))
            {
                setCurrentSkill(new SkillInfo());
                parseSkill(n);
                _skillsInFile.addAll(_currentSkill.skills);
            }
        }
    }

    protected void parseSkill(Node n)
    {
        NamedNodeMap attrs = n.getAttributes();

        int skillId = Integer.parseInt(attrs.getNamedItem("id").getNodeValue());
        String skillName = attrs.getNamedItem("name").getNodeValue();
        int levels = Integer.parseInt(attrs.getNamedItem("levels").getNodeValue());

        _currentSkill.id = skillId;
        _currentSkill.name = skillName;
        _currentSkill.sets = new StatsSet[levels];

        for (int i = 0; i < levels; i++)
        {
            _currentSkill.sets[i] = new StatsSet();
            _currentSkill.sets[i].set("skill_id", _currentSkill.id);
            _currentSkill.sets[i].set("name", _currentSkill.name);
            _currentSkill.sets[i].set("level", i+1);
        }

        if (_currentSkill.sets.length != levels)
        {
            //TODO:ERROR
        }

        makeSkills();
        _currentSkill.skills.addAll(_currentSkill.currentSkills);
    }

    private void makeSkills()
    {
        int count = 0;

        _currentSkill.currentSkills = new ArrayList<>(_currentSkill.sets.length);

        StatsSet set;
        for (int i = 0; i < _currentSkill.sets.length; i++)
        {
            set = _currentSkill.sets[i];
            try
            {
                _currentSkill.currentSkills.add(i, new Skill(set));
                count++;
            }
            catch (Exception e)
            {
                LOG.log(Level.SEVERE, "Skill id= " + set.getInt("skill_id") + "level " + set.getInt("level"), e);
            }
        }
    }
}
