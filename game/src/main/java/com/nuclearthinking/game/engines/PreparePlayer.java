package com.nuclearthinking.game.engines;

import com.nuclearthinking.game.player.MageClass;
import com.nuclearthinking.game.player.Player;
import com.nuclearthinking.game.player.RogueClass;
import com.nuclearthinking.game.player.WarriorClass;
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

public class PreparePlayer extends Player {
    UserInput input = new UserInput();
    StringUtil ut = new StringUtil();
    private Player player;
    private MessagesReader messages = MessagesReader.getInstance();

    public PreparePlayer() {
        player = new Player();
        //Установка имени игроку если оно null
        setPlayerName();
        //Установка класса игроку если он null
        choosePlayerClass();
    }

    public PreparePlayer(String name, String playerClass)
    {
        player = new Player();
        setPlayerName(name);
        choosePlayerClass(playerClass);
    }

    private void setPlayerName() {
        player.setName(ut.beautifyName(getValidName()));
        System.out.println(messages.getMessage("welcomeMessage") + " " + player.getName());
        System.out.println();
    }

    private void setPlayerName(String name)
    {
        player.setName(ut.beautifyName(name));
        System.out.println(messages.getMessage("welcomeMessage") + " " + player.getName());
        System.out.println();
    }

    private void choosePlayerClass(String playerClass)
    {
        List<String> strings = new ArrayList<String>() {
            {
                add(messages.getMessage("mageClass"));
                add(messages.getMessage("warriorClass"));
                add(messages.getMessage("rogueClass"));
            }
        };
        switch (playerClass) {
            case "Mag": {
                player.setClass(new MageClass());
                System.out.println(messages.getMessage("choosedClass") + " : " + messages.getMessage("mageClass"));
                break;
            }
            case "Warrior": {
                player.setClass(new WarriorClass());
                System.out.println(messages.getMessage("choosedClass") + " : " + messages.getMessage("warriorClass"));
                break;
            }
            case "Rogue": {
                player.setClass(new RogueClass());
                System.out.println(messages.getMessage("choosedClass") + " : " + messages.getMessage("rogueClass"));
                break;
            }
        }
        System.out.println();
    }

    private void choosePlayerClass() {
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


}
