package com.nuclearthinking.game.engines;

import com.nuclearthinking.game.characters.Player;
import com.nuclearthinking.game.utils.StringUtil;
import com.nuclearthinking.game.utils.UserInput;

/**
 * Created
 * Date: 23.12.2015
 * Time: 14:21
 *
 * @author Vladislav Radchenko (onfient@gmail.com)
 */

public class PreparePlayer {
    UserInput input = new UserInput();
    StringUtil ut = new StringUtil();
    private Player player;
    private MessagesReader messages = MessagesReader.getInstance();


    private PreparePlayer() {
        player = new Player();
        if (player.getName() == null) {
            String playerName = getValidName();
            player.setName(ut.beautifyName(playerName));
            System.out.println(messages.getMessage("welcomeMessage") + " " + player.getName());
        }


    }

    public static PreparePlayer getInstance() {
        return PreparePlayerHolder.INSTANCE;
    }

    public Player getPlayer() {
        return player;
    }

    protected String getValidName() {
        boolean valid = false;
        String playerName = null;
        while (!valid) {
            System.out.println(messages.getMessage("inputNameMessage"));
            playerName = input.getUserInput();
            valid = ut.isValidName(playerName);
        }
        return playerName;
    }


    private static class PreparePlayerHolder {
        private static final PreparePlayer INSTANCE = new PreparePlayer();
    }

}
