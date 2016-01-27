package com.nuclearthinking.game.model.items;

import com.nuclearthinking.game.model.StatsSet;
import com.nuclearthinking.game.model.interfaces.IIdentifiable;
import com.nuclearthinking.game.model.items.type.ItemType;

import java.util.logging.Logger;

/**
 * Date: 26.12.2015
 * Time: 12:09
 *
 * @author Izonami
 */
public abstract class Item implements IIdentifiable {
    protected static final Logger LOG = Logger.getLogger(Item.class.getName());

    private final int _itemId;
    private final String _name;

    protected Item(StatsSet set) {
        _itemId = set.getInt("item_id");
        _name = set.getString("name");
    }

    public abstract ItemType getItemType();

    @Override
    public final int getId() {
        return _itemId;
    }

    public final String getName() {
        return _name;
    }

    public abstract int getItemMask();

    public boolean isMagicWeapon() {
        return false;
    }

    @Override
    public String toString() {
        return _name + "(" + _itemId + ")";
    }
}
