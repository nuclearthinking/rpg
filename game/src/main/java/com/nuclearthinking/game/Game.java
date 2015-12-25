package com.nuclearthinking.game;

import com.nuclearthinking.game.engines.PreparePlayer;

/**
 * Created
 * Date: 23.12.2015
 * Time: 14:21
 *
 * @author Vladislav Radchenko (onfient@gmail.com)
 */
public final class Game {

    private Game() {
        PreparePlayer preparePlayer = PreparePlayer.getInstance();
    }

    public static Game getInstance() {
        return GameHolder.INSTANCE;
    }

    private static class GameHolder {
        private static final Game INSTANCE = new Game();
    }


}
