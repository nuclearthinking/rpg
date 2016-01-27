package com.nuclearthinking.game.obj;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.KryoSerializable;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.nuclearthinking.game.obj.world.World;
import com.nuclearthinking.game.player.Player;

/**
 * Date: 27.01.2016
 * Time: 13:01
 *
 * @author Vladislav Radchenko (onfient@gmail.com)
 */

public class SaveEntity implements KryoSerializable {

    protected World world;
    protected Player player;

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

    @Override
    public void write(Kryo kryo, Output output) {

    }

    @Override
    public void read(Kryo kryo, Input input) {

    }
}
