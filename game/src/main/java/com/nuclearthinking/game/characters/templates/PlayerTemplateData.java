package com.nuclearthinking.game.characters.templates;

import com.nuclearthinking.game.enums.ClassId;
import com.nuclearthinking.game.model.StatsSet;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kuksin-mv on 15.01.2016.
 */
public final class PlayerTemplateData
{
    private final Map<ClassId, PlayerTemplate> _playerTemplate = new HashMap<ClassId, PlayerTemplate>();

    protected PlayerTemplateData()
    {
        load();
    }

    public void load()
    {
        _playerTemplate.clear();

        StatsSet set = new StatsSet();

        //TODO:Разхардкодить
        for (int i = 0; i < 3; i++)
        {
            int classId = i;
            System.out.println(classId);
            set.set("classId", classId);
            set.set("basePDef", 10);
            set.set("baseMDef", 5);
            _playerTemplate.put(ClassId.getClassId(classId), new PlayerTemplate(set));
        }

    }

    public PlayerTemplate getTemplate(ClassId classId)
    {
        return _playerTemplate.get(classId);
    }

    public PlayerTemplate getTemplate(int classId)
    {
        return _playerTemplate.get(ClassId.getClassId(classId));
    }

    public static final PlayerTemplateData getInstance()
    {
        return SingletonHolder._instance;
    }

    private static class SingletonHolder
    {
        protected static final PlayerTemplateData _instance = new PlayerTemplateData();
    }
}
