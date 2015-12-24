package com.nuclearthinking.game;

import com.nuclearthinking.game.config.Config;
import com.nuclearthinking.game.engines.PreparePlayer;
import com.nuclearthinking.game.utils.Printable;

/**
 * Created
 * Date: 23.12.2015
 * Time: 14:21
 *
 * @author Vladislav Radchenko (onfient@gmail.com)
 */
public final class Game extends Printable {

    private static final String welMsg = Config.WELCOME_MSG;

    private Game() {
        PreparePlayer preparePlayer = PreparePlayer.getInstance();
    }

    private static class GameHolder {
        private static final Game INSTANCE = new Game();
    }

    public static Game getInstance() {
        return GameHolder.INSTANCE;
    }


}
