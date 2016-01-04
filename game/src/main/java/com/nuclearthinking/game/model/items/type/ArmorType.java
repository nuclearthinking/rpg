package com.nuclearthinking.game.model.items.type;

/**
 * Created by Izonami on 26.12.2015.
 */
public enum ArmorType implements ItemType {
    LIGHT,
    HEAVY,
    ROBE;

    @Override
    public int mask() {
        return 0;
    }
}
