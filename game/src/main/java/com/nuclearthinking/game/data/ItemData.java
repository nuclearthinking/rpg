package com.nuclearthinking.game.data;

import com.nuclearthinking.game.engines.Engine;
import com.nuclearthinking.game.model.items.Item;
import com.nuclearthinking.game.model.items.Weapon;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by kuksin-mv on 29.12.2015.
 */
public class ItemData {
    private static Logger LOG = Logger.getLogger(ItemData.class.getName());
    private final Map<Integer, Weapon> _weapons = new HashMap<>();

    private Item[] _allTemplates;

    protected ItemData() {
        load();
    }

    public static ItemData getInstance() {
        return SingletonHolder._instance;
    }

    private void load() {
        int highest = 0;
        _weapons.clear();
        for (Item item : Engine.getInstance().loadItems()) {
            if (highest < item.getId()) {
                highest = item.getId();
            }
            if (item instanceof Weapon) {
                _weapons.put(item.getId(), (Weapon) item);
            }
        }
        buildFastLookupTable(highest);
        LOG.log(Level.INFO, getClass().getSimpleName() + ": Loaded: " + _weapons.size() + " Weapon Items");
    }

    private void buildFastLookupTable(int size) {
        _allTemplates = new Item[size + 1];

        for (Weapon item : _weapons.values()) {
            _allTemplates[item.getId()] = item;
        }
    }

    public Item getTemplate(int id) {
        if ((id >= _allTemplates.length) || (id < 0)) {
            return null;
        }

        return _allTemplates[id];
    }

    public void getForDebug(int id) {
        if ((id >= _allTemplates.length) || (id < 0)) {
            System.out.println("Такого Id нет");
        }

        System.out.println("Item ID: " + _allTemplates[id].getId() + "; " +
                "Item Name: " + _allTemplates[id].getName() + "; " +
                "Item Type: " + _allTemplates[id].getItemType() + "; " +
                "Item Mask: " + _allTemplates[id].getItemMask());
    }

    private static class SingletonHolder {
        protected static final ItemData _instance = new ItemData();
    }
}
