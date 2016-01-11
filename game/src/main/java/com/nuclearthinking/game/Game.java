package com.nuclearthinking.game;

import com.nuclearthinking.game.engines.PreparePlayer;
import com.nuclearthinking.game.obj.Player;
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
        PreparePlayer pp = PreparePlayer.getInstance();

        Player playableCharacter = pp.getPlayer();

        World world = new World().setSize(30);
        world.createWorld();
    }

    public static Game getInstance() {
        return GameHolder.INSTANCE;
    }

    private static class GameHolder {
        private static final Game INSTANCE = new Game();
    }


}
