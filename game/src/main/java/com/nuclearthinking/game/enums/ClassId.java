package com.nuclearthinking.game.enums;

import com.nuclearthinking.game.model.interfaces.IIdentifiable;

/**
 * Created by kuksin-mv on 15.01.2016.
 */
public enum ClassId implements IIdentifiable {
    warrior(0, false, Race.HUMAN),
    mage(1, true, Race.HUMAN),
    rogue(2, false, Race.HUMAN);

    private final int _id;
    private final boolean _isMage;
    private final Race _race;

    ClassId(int cId, boolean cIsMage, Race race) {
        _id = cId;
        _isMage = cIsMage;
        _race = race;
    }

    public static ClassId getClassId(int cId) {
        return ClassId.values()[cId];
    }

    @Override
    public int getId() {
        return _id;
    }

    public final boolean isMage() {
        return _isMage;
    }

    public final Race getRace() {
        return _race;
    }
}
