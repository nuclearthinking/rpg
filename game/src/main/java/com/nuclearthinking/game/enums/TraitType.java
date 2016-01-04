package com.nuclearthinking.game.enums;

/**
 * Created by kuksin-mv on 30.12.2015.
 */
public enum TraitType {
    SWORD(1, 1),
    DAGGER(2, 1),
    MAGSWORD(3, 1);

    private final int _id;
    private final int _type; // 1 = weapon, 2 = weakness, 3 = resistance

    TraitType(int id, int type) {
        _id = id;
        _type = type;
    }

    public int getId() {
        return _id;
    }

    public int getType() {
        return _type;
    }
}
