package com.nuclearthinking.game.model.items;

import com.nuclearthinking.game.model.StatsSet;
import com.nuclearthinking.game.model.items.type.WeaponType;

/**
 * Date: 26.12.2015
 * Time: 12:08
 *
 * @author Izonami
 */
public class Weapon extends Item {
    private final WeaponType _type;

    public Weapon(StatsSet set) {
        super(set);
        _type = WeaponType.valueOf(set.getString("weapon_type", "none").toUpperCase());
    }

    @Override
    public WeaponType getItemType() {
        return _type;
    }

    @Override
    public int getItemMask() {
        return getItemType().mask();
    }
}
