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
        //Новый обьект игрока
        player = new Player();
        //Установка имени игроку если оно null
        setPlayerName();
        //Установка класса игроку если он null
        choosePlayerClass();
    }


    private void setPlayerName() {
        if (player.getName() == null) {
            player.setName(ut.beautifyName(getValidName()));
            System.out.println(messages.getMessage("welcomeMessage") + " " + player.getName());
            System.out.println();
        }
    }

    private void choosePlayerClass() {
        if (player.getpClass() == null) {

            System.out.println(messages.getMessage("chooseYourClass"));
            System.out.println();
            List<String> strings = new ArrayList<String>() {
                {
                    add(messages.getMessage("mageClass"));
                    add(messages.getMessage("warriorClass"));
                    add(messages.getMessage("rogueClass"));
                }
            };

            switch (input.chouseOne(strings)) {
                case 1: {
                    player.setClass(new MageClass());
                    System.out.println(messages.getMessage("choosedClass") + " : " + messages.getMessage("mageClass"));
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
            System.out.println();
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
