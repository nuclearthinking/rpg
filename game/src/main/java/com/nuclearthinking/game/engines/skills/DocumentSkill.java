package com.nuclearthinking.game.engines.skills;

import com.nuclearthinking.game.engines.Base;
import com.nuclearthinking.game.model.StatsSet;
import com.nuclearthinking.game.model.skills.Skill;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

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

    public DocumentSkill(File file)
    {
        super(file);
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
                        resetTable();
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

    }

    private void setCurrentSkill(SkillInfo skill)
    {
        _currentSkill = skill;
    }

    public List<Skill> getSkills()
    {
        return _skillsInFile;
    }
}
