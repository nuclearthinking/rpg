package com.nuclearthinking.game;

import com.nuclearthinking.game.engines.PreparePlayer;
import com.nuclearthinking.game.obj.world.World;
import com.nuclearthinking.game.player.Player;


/**
 * Created
 * Date: 23.12.2015
 * Time: 14:21
 *
 * @author Vladislav Radchenko (onfient@gmail.com)
 */
public final class Game {

    private Game() {
        World world = new World().setSize(30);
        world.createWorld();
        Player player = new PreparePlayer().getCharacterObject();
        MainGameLoop loop = new MainGameLoop(player, world);
    }

    public static Game getInstance() {
        return GameHolder.INSTANCE;
    }

    private static class GameHolder {
        private static final Game INSTANCE = new Game();
    }


}
