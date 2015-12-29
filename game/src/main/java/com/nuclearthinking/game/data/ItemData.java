package com.nuclearthinking.game.data;

import com.nuclearthinking.game.config.Config;
import com.nuclearthinking.game.engines.Engine;
import com.nuclearthinking.game.model.items.Item;
import com.nuclearthinking.game.model.items.Weapon;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kuksin-mv on 29.12.2015.
 */
public class ItemData
{
    private final Map<Integer, Weapon> _weapons = new HashMap<>();

    private Item[] _allTemplates;

    public static ItemData getInstance()
    {
        return SingletonHolder._instance;
    }

    protected ItemData()
    {
        load();
    }

    private void load()
    {
        int highest = 0;
        _weapons.clear();
        for(Item item : Engine.getInstance().loadItems())
        {
            if (highest < item.getId())
            {
                highest = item.getId();
            }
            if(item instanceof Weapon)
            {
                _weapons.put(item.getId(), (Weapon) item);
            }
        }
        buildFastLookupTable(highest);
    }

    private void buildFastLookupTable(int size)
    {
        _allTemplates = new Item[size + 1];

        for (Weapon item : _weapons.values())
        {
            _allTemplates[item.getId()] = item;
        }
    }

    public Item getTemplate(int id)
    {
        if ((id >= _allTemplates.length) || (id < 0))
        {
            return null;
        }

        if (Config.DEBUG)
        {
            System.out.println("Item Name: " + _weapons.get(id).getName());
            System.out.println("Weapon Id: " + _weapons.get(id).getId());
            System.out.println("Weapon Type: " + _weapons.get(id).getItemType());
        }

        return _allTemplates[id];
    }

    private static class SingletonHolder
    {
        protected static final ItemData _instance = new ItemData();
    }
}
