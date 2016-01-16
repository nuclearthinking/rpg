package com.nuclearthinking.game.characters.interfaces;

import com.nuclearthinking.game.characters.ChracterObject;

/**
 * Created
 * Date: 25.12.2015
 * Time: 13:07
 *
 * @author Vladislav Radchenko (onfient@gmail.com)
 */
public interface IPlayerClass {

    int pDamage(ChracterObject chracterObject);

    int mDamage(ChracterObject chracterObject);

    void levelUp(ChracterObject chracterObject);

    int mDefence(ChracterObject chracterObject);

    int pDefence(ChracterObject chracterObject);

}
