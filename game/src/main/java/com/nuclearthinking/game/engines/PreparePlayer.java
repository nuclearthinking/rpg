package com.nuclearthinking.game.engines;

import com.nuclearthinking.game.config.Config;
import com.nuclearthinking.game.obj.Player;
import com.nuclearthinking.game.utils.UserInput;
import com.nuclearthinking.game.utils.Util;

/**
 * Created by onifent
 */

public class PreparePlayer {

    private static final String welMsg = Config.WELCOME_MSG;
    private Player player;

    private PreparePlayer() {
        player = Player.getInstance();

        setName(player);

    }

    public static PreparePlayer getInstance() {
        return PreparePlayerHolder.INSTANCE;
    }

    public Player getPlayer() {
        return player;
    }

    private void setName(Player player) {
        if (player.getName() == null) {
            UserInput input = new UserInput();
            Util ut = new Util();
            boolean valid = false;
            String playerName = null;
            while (!valid) {
                System.out.println("Введите имя персонажа");
                playerName = input.getUserInput();
                valid = !ut.isNumericOnly(playerName);
            }
            String playerUpperCaseName = ut.setFirstCharUpperCase(playerName);
            player.setName(playerUpperCaseName);
            System.out.println(welMsg + " " + player.getName());
        }
    }

    private static class PreparePlayerHolder {
        private static final PreparePlayer INSTANCE = new PreparePlayer();
    }

}
