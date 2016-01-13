package com.nuclearthinking.game.engines;

import com.nuclearthinking.game.obj.MageClass;
import com.nuclearthinking.game.obj.Player;
import com.nuclearthinking.game.obj.RogueClass;
import com.nuclearthinking.game.obj.WarriorClass;
import com.nuclearthinking.game.utils.StringUtil;
import com.nuclearthinking.game.utils.UserInput;

import java.util.ArrayList;
import java.util.List;

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

        if (player.getpClass() == null) {

            System.out.println(messages.getMessage("chooseYourClass"));

            List<String> strings = new ArrayList<String>() {
                {
                    add(messages.getMessage("mageClass"));
                    add(messages.getMessage("warriorClass"));
                    add(messages.getMessage("rogueClass"));
                }
            };
            int classId = input.chouseOne(strings);

            switch (classId) {
                case 1: {
                    player.setClass(new MageClass());
                    System.out.println(messages.getMessage("choosedClass")+" : "+messages.getMessage("mageClass"));
                    break;
                }
                case 2: {
                    player.setClass(new WarriorClass());
                    System.out.println(messages.getMessage("choosedClass") + " : " + messages.getMessage("warriorClass"));
                    break;
                }
                case 3: {
                    player.setClass(new RogueClass());
                    System.out.println(messages.getMessage("choosedClass") + " : " + messages.getMessage("rogueClass"));
                    break;
                }
            }
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
