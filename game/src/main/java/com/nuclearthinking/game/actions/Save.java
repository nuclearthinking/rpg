package com.nuclearthinking.game.actions;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Output;
import com.nuclearthinking.game.obj.SaveEntity;
import com.nuclearthinking.game.obj.world.World;
import com.nuclearthinking.game.player.Player;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Date: 27.01.2016
 * Time: 13:31
 *
 * @author Vladislav Radchenko (onfient@gmail.com)
 */

public class Save extends Action implements Actable {

    protected Save(Player player, World world) {
        super(player, world);
    }


    @Override
    public void run() {
        if (player != null && world != null) {
            try {
                SaveEntity saveFile = new SaveEntity(world, player);
                Kryo kryo = new Kryo();
                kryo.register(SaveEntity.class);
                FileOutputStream file = new FileOutputStream("Save");
                Output output = new Output();
                output.setOutputStream(file);
                saveFile.write(kryo, output);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
