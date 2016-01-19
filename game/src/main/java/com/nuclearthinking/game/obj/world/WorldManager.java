package com.nuclearthinking.game.obj.world;

/**
 * Created by onifent
 */

public class WorldManager {

    World world;


    public WorldManager(int worldSize) {
        world = new World();
        world.setSize(worldSize);
        world.createWorld();
    }

    public World getWorld() {
        return this.world;
    }

}
