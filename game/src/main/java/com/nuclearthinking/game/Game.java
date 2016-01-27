package com.nuclearthinking.game;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.nuclearthinking.game.engines.DatabaseEngine;
import com.nuclearthinking.game.engines.PreparePlayer;
import com.nuclearthinking.game.obj.SaveEntity;
import com.nuclearthinking.game.obj.world.World;
import com.nuclearthinking.game.obj.world.WorldManager;
import com.nuclearthinking.game.player.Player;
import com.nuclearthinking.game.utils.ResourceUtil;


/**
 * Created
 * Date: 23.12.2015
 * Time: 14:21
 *
 * @author Vladislav Radchenko (onfient@gmail.com)
 */
public final class Game {

    private Game() {
        //Инициализация базы данных
        DatabaseEngine.getInstance().initDb();
        startNewGame();
//        loadGame();
    }


    protected void startNewGame() {
        //Создание мира
        World world = new WorldManager(30).getWorld();
        //Создание персонажа
        Player player = new PreparePlayer().getPlayer();
        //Запуск игры
        new MainGameLoop(player, world);
    }

    protected void loadGame() {
        SaveEntity savedGame = null;
        try (Input input = new Input(ResourceUtil.getResourceAsStream("save/game.sav"))) {
            Kryo kryo = new Kryo();
            savedGame = (SaveEntity) kryo.readClassAndObject(input);
        }
        new MainGameLoop(savedGame);
    }

    public static Game getInstance() {
        return GameHolder.INSTANCE;
    }

    private static class GameHolder {
        private static final Game INSTANCE = new Game();
    }


}
