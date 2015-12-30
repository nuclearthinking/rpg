package com.nuclearthinking.game.model.items.type;

import com.nuclearthinking.game.enums.TraitType;

/**
 * Created by Izonami on 26.12.2015.
 */
public enum WeaponType implements ItemType
{

    SWORD(TraitType.SWORD),
    DAGGER(TraitType.DAGGER),
    MAGSWORD(TraitType.MAGSWORD);

    private final int _mask;
    private final TraitType _traitType;

    /**
     * Constructor of the L2WeaponType.
     * @param traitType
     */
    WeaponType(TraitType traitType)
    {
        _mask = 1 << ordinal();
        _traitType = traitType;
    }

    @Override
    public int mask()
    {
        return _mask;
    }

    //TODO: Добавить гетер, который будет отдавать TraitType и на его основе делать умножение урона
}
