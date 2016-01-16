package com.nuclearthinking.game;

import com.nuclearthinking.game.characters.ChracterObject;
import com.nuclearthinking.game.engines.PreparePlayer;
import com.nuclearthinking.game.obj.world.World;


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
        ChracterObject chracterObject = new PreparePlayer().getChracterObject();
        MainGameLoop loop = new MainGameLoop(chracterObject, world);
    }

    public static Game getInstance() {
        return GameHolder.INSTANCE;
    }

    private static class GameHolder {
        private static final Game INSTANCE = new Game();
    }


}
