package com.nuclearthinking.game.engines;

import com.nuclearthinking.game.data.SkillData;
import com.nuclearthinking.game.engines.items.DocumentItem;
import com.nuclearthinking.game.engines.skills.DocumentSkill;
import com.nuclearthinking.game.model.items.Item;
import com.nuclearthinking.game.model.skills.Skill;
import com.nuclearthinking.game.utils.ResourceUtil;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Date: 24.12.2015
 * Time: 11:51
 *
 * @author kuksin-mv
 */
public class Engine {
    private static final Logger LOG = Logger.getLogger(Engine.class.getName());

    private static final ResourceUtil resource = new ResourceUtil();

    private final List<InputStream> _itemFiles = new ArrayList<InputStream>();
    private final List<InputStream> _skillFiles = new ArrayList<InputStream>();

    protected Engine()
    {
        hashFiles("data/items/", _itemFiles);
        hashFiles("data/skills/", _skillFiles);
    }

    public static Engine getInstance()
    {
        return SingletonHolder._instance;
    }

    private void hashFiles(String dirname, List<InputStream> hash)
    {
        //TODO: Почитать как брать файлы из дирректории для инпут стрима. Скорее всего надо сделать метод в котором он будет вайлить по дирректории
        InputStream is = resource.getResourceAsStream(dirname + "000-100.xml");
        hash.add(is);
    }

    public List<Skill> loadSkills(InputStream file)
    {
        if (file == null) {
            LOG.log(Level.WARNING, "Skill file not found.");
            return null;
        }
        DocumentSkill doc = new DocumentSkill(file);
        doc.parse();
        return doc.getSkills();
    }

    public List<Item> loadItems()
    {
        List<Item> list = new ArrayList<Item>();
        for (InputStream file : _itemFiles)
        {
            DocumentItem documentItem = new DocumentItem(file);
            documentItem.parse();
            list.addAll(documentItem.getItemList());
        }
        return list;
    }

    public void loadAllSkills(final Map<Integer, Skill> allSkills) {
        int count = 0;
        for (InputStream file : _skillFiles) {
            List<Skill> s = loadSkills(file);
            if (s == null) {
                continue;
            }
            for (Skill skill : s) {
                allSkills.put(SkillData.getSkillHashCode(skill), skill);
                count++;
            }
        }
        LOG.log(Level.FINE, getClass().getSimpleName() + ": Loaded " + count + " Skill templates from XML files.");
    }


    private static class SingletonHolder {
        protected static final Engine _instance = new Engine();
    }
}
