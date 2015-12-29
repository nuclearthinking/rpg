package com.nuclearthinking.game.model.items;

import com.nuclearthinking.game.model.StatsSet;
import com.nuclearthinking.game.model.items.type.WeaponType;

/**
 * Created by Izonami on 26.12.2015.
 */
public class Weapon extends Item
{
    private final WeaponType _type;

    protected Weapon(StatsSet set)
    {
        super(set);
        _type = WeaponType.valueOf(set.getString("weapon_type", "none").toUpperCase());
    }

    @Override
    public WeaponType getItemType()
    {
        return _type;
    }
}
