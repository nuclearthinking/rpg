package com.nuclearthinking.game.obj;

import com.nuclearthinking.game.obj.world.World;
import com.nuclearthinking.game.player.Player;

/**
 * Date: 27.01.2016
 * Time: 13:01
 *
 * @author Vladislav Radchenko (onfient@gmail.com)
 */

public class SaveEntity {

    protected World world;
    protected Player player;

    public SaveEntity() {

    }

    public SaveEntity(World world, Player player) {
        this.world = world;
        this.player = player;
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

}
