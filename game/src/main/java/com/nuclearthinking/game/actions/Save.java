package com.nuclearthinking.game.actions;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Output;
import com.nuclearthinking.game.obj.SaveEntity;
import com.nuclearthinking.game.obj.world.World;
import com.nuclearthinking.game.player.Player;

import java.io.File;
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
            File file = new File("game/src/main/resources/save/game.sav");
            if (file.exists()) System.out.println("файл сохранения существует, удаляем " + file.delete());

            File saveDir = new File("game/src/main/resources/save");
            if (!saveDir.exists()) System.out.println("отсутсвтует папка для сохранения, создаем " + saveDir.mkdir());

            try (Output output = new Output(new FileOutputStream("game/src/main/resources/save/game.sav"))) {
                SaveEntity saveFile = new SaveEntity(world, player);
                Kryo kryo = new Kryo();
                kryo.writeClassAndObject(output, saveFile);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
