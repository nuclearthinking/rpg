package com.nuclearthinking.game.actions;

import com.nuclearthinking.game.characters.Player;
import com.nuclearthinking.game.obj.world.World;

/**
 * Date: 15.01.2016
 * Time: 16:26
 *
 * @author Vladislav Radchenko (onifent@gmail.com)
 */

public class Action implements Actable {
    Player player;

    World world;

    Action(Player player, World world) {
        this.world = world;
        this.player = player;
    }

    @Override
    public void run() {

    }

    public boolean isNavigate() {
        return false;
    }
}
