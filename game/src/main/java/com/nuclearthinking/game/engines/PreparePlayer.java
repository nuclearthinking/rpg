package com.nuclearthinking.game.engines;

import com.nuclearthinking.game.obj.Player;
import com.nuclearthinking.game.utils.UserInput;
import com.nuclearthinking.game.utils.Util;

/**
 * Created
 * Date: 23.12.2015
 * Time: 14:21
 *
 * @author Vladislav Radchenko (onfient@gmail.com)
 */

public class PreparePlayer {
    UserInput input = new UserInput();
    Util ut = new Util();
    private Player player;
    private GameMessages messages = GameMessages.getInstance();


    private PreparePlayer() {
        player = Player.getInstance();
        if (player.getName() == null) {

        }
        System.out.println(messages.getMessages().getWelcomeMessage() + " " + player.getName());


    }

    public static PreparePlayer getInstance() {
        return PreparePlayerHolder.INSTANCE;
    }

    public Player getPlayer() {
        return player;
    }

    protected String getValidName() {
        //TODO: Сделать это красивым и понятным!
        boolean valid = false;
        String playerName;
        while (!valid) {

            System.out.println(messages.getMessages().getInputNameMessage());
            playerName = input.getUserInput();
            if (!ut.isNumericOnly(playerName)) {
                if (!ut.firstCharIsNumeric(playerName)) {
                    return ut.beautifyName(playerName);
                } else {
                    valid = false;
                    System.out.println(messages.getMessages().getFirstCharNumeric());
                }
            } else {
                valid = false;
            }
        }
        return null;
    }

    protected boolean isValidName(String string) {
        boolean valid;
        valid = ut.isNumericOnly(string);
        valid = ut.firstCharIsNumeric(string);
        return valid;
    }

    private static class PreparePlayerHolder {
        private static final PreparePlayer INSTANCE = new PreparePlayer();
    }

}
