package com.nuclearthinking.game.characters.interfaces;

import com.nuclearthinking.game.characters.CharacterObject;

/**
 * Created
 * Date: 25.12.2015
 * Time: 13:07
 *
 * @author Vladislav Radchenko (onfient@gmail.com)
 */
public interface IPlayerClass {

    int pDamage(CharacterObject characterObject);

    int mDamage(CharacterObject characterObject);

    void levelUp(CharacterObject characterObject);

    int mDefence(CharacterObject characterObject);

    int pDefence(CharacterObject characterObject);

}
