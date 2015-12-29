package com.nuclearthinking.game.obj;

/**
 * Created
 * Date: 25.12.2015
 * Time: 13:07
 *
 * @author Vladislav Radchenko (onfient@gmail.com)
 */
public interface IPlayerClass {

    int pDamage(Player player);

    int mDamage(Player player);

    void levelUp(Player player);

    int mDefence(Player player);

    int pDefence(Player player);

}
