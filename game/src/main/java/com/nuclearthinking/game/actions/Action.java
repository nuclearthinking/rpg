package com.nuclearthinking.game.actions;

import com.nuclearthinking.game.npc.Monster;
import com.nuclearthinking.game.obj.world.World;
import com.nuclearthinking.game.obj.world2.WorldInstance;
import com.nuclearthinking.game.player.Player;

/**
 * Date: 15.01.2016
 * Time: 16:26
 *
 * @author Vladislav Radchenko (onifent@gmail.com)
 */

public class Action implements Actable {
    Player player;
    World world;
    WorldInstance worldInstance;
    Monster monster;

    Action(Player player, World world) {
        this.world = world;
        this.player = player;
    }

    Action(Player player, WorldInstance worldInstance) {
        this.worldInstance = worldInstance;
        this.player = player;
    }

    Action(Player player, World world, Monster monster) {
        this.world = world;
        this.player = player;
        this.monster = monster;
    }

    Action(Player player, WorldInstance worldInstance, Monster monster) {
        this.worldInstance = worldInstance;
        this.player = player;
        this.monster = monster;
    }

    @Override
    public void run() {

    }

}
