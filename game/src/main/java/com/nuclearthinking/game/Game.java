package com.nuclearthinking.game;

import com.nuclearthinking.game.engines.DatabaseEngine;
import com.nuclearthinking.game.engines.PreparePlayer;
import com.nuclearthinking.game.obj.world.World;
import com.nuclearthinking.game.obj.world.WorldManager;
import com.nuclearthinking.game.player.Player;

import java.sql.Connection;


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
        Connection connection = new DatabaseEngine().initDb().getConnection();
        //Создание мира
        World world = new WorldManager(30).getWorld();
        //Создание персонажа
        Player player = new PreparePlayer().getPlayer();
        //Запуск игры
        new MainGameLoop(player, world);
    }

    public static Game getInstance() {
        return GameHolder.INSTANCE;
    }

    private static class GameHolder {
        private static final Game INSTANCE = new Game();
    }


}
