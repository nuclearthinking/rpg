package com.nuclearthinking.game.characters.interfaces;

import com.nuclearthinking.game.player.Player;

/**
 * Created
 * Date: 25.12.2015
 * Time: 13:07
 *
 * @author Vladislav Radchenko (onfient@gmail.com)
 */
public interface IPlayerClass {

    int pDamage(Player characterObject);

    int mDamage(Player characterObject);

    void levelUp(Player characterObject);

    int mDefence(Player characterObject);

    int pDefence(Player characterObject);

}
