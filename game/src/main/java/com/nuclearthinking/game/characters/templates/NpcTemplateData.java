package com.nuclearthinking.game.characters.templates;

import com.nuclearthinking.game.model.StatsSet;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Izonami on 16.01.2016.
 */
public class NpcTemplateData {
    private final Map<Integer, NpcTemplate> _npcs = new ConcurrentHashMap<Integer, NpcTemplate>();

    protected NpcTemplateData() {
        load();
        System.out.println(_npcs.size());
    }

    public static NpcTemplateData getInstance() {
        return SingletonHolder._instance;
    }

    public void load() {
        final StatsSet set = new StatsSet();
        final int npcId = 1;

        set.set("id", npcId);
        set.set("level", 5);
        set.set("name", "TestMob");
        set.set("baseSTR", 10);
        set.set("baseINT", 10);
        set.set("baseDEX", 10);
        set.set("baseWIT", 10);
        set.set("baseCON", 10);
        set.set("baseMEN", 10);
        set.set("baseHpMax", 100);

        NpcTemplate template = _npcs.get(npcId);

        if (template == null) {
            template = new NpcTemplate(set);
            _npcs.put(template.getId(), template);
        } else {
            template.set(set);
        }
    }

    public NpcTemplate getTemplate(int id) {
        return _npcs.get(id);
    }

    public NpcTemplate getNpcName(String name) {
        for (NpcTemplate npcTemplate : _npcs.values()) {
            if (npcTemplate.getName().equalsIgnoreCase(name)) {
                return npcTemplate;
            }
        }
        return null;
    }

    private static class SingletonHolder {
        protected static final NpcTemplateData _instance = new NpcTemplateData();
    }
}
