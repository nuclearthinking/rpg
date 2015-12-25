package com.nuclearthinking.game.engines;

import com.nuclearthinking.game.data.SkillData;
import com.nuclearthinking.game.engines.skills.DocumentSkill;
import com.nuclearthinking.game.model.skills.Skill;
import com.nuclearthinking.game.utils.filter.XMLFilter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Date: 24.12.2015
 * Time: 11:51
 * @author kuksin-mv
 */
public class Engine
{
    private static final Logger LOG = Logger.getLogger(Engine.class.getName());

    private static final String DIR = System.getProperty("user.dir") + "\\game\\src\\main\\resources\\";

    private final List<File> _itemFiles = new ArrayList<File>();
    private final List<File> _skillFiles = new ArrayList<File>();

    public static Engine getInstance()
    {
        return SingletonHolder._instance;
    }

    protected Engine()
    {
        //hashFiles("data/items", _itemFiles);
        hashFiles(DIR + "data/skills", _skillFiles);
    }

    private void hashFiles(String dirname, List<File> hash)
    {
        File dir = new File(dirname);
        if (!dir.exists())
        {
            LOG.warning("Dir " + dir.getAbsolutePath() + " not exists");
            return;
        }

        final File[] files = dir.listFiles(new XMLFilter());
        if (files != null)
        {
            for (File f : files)
            {
                hash.add(f);
            }
        }
    }

    public List<Skill> loadSkills(File file)
    {
        if (file == null)
        {
            LOG.warning("Skill file not found.");
            return null;
        }
        DocumentSkill doc = new DocumentSkill(file);
        doc.parse();
        return doc.getSkills();
    }

    public void loadAllSkills(final Map<Integer, Skill> allSkills)
    {
        int count = 0;
        for (File file : _skillFiles)
        {
            List<Skill> s = loadSkills(file);
            if (s == null)
            {
                continue;
            }
            for (Skill skill : s)
            {
                allSkills.put(SkillData.getSkillHashCode(skill), skill);
                count++;
            }
        }
        LOG.severe(getClass().getSimpleName() + ": Loaded " + count + " Skill templates from XML files.");
    }

    private static class SingletonHolder
    {
        protected static final Engine _instance = new Engine();
    }
}
