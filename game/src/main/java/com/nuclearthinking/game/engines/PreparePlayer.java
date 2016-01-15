package com.nuclearthinking.game.engines;


import com.nuclearthinking.game.characters.MageClass;
import com.nuclearthinking.game.characters.Player;
import com.nuclearthinking.game.characters.RogueClass;
import com.nuclearthinking.game.characters.WarriorClass;
import com.nuclearthinking.game.characters.instance.PlayableInstance;
import com.nuclearthinking.game.characters.templates.PlayerTemplate;
import com.nuclearthinking.game.characters.templates.PlayerTemplateData;
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
    private Player player = null;
    private PlayableInstance newPlayer = null;
    private PlayerTemplate template = null;
    private MessagesReader messages = MessagesReader.getInstance();
    String _name;
    int _classId;

    private PreparePlayer()
    {
        player = new Player();
        //Установка имени игроку если оно null
        setPlayerName();
        //Установка класса игроку если он null
        choosePlayerClass();
        template = PlayerTemplateData.getInstance().getTemplate(_classId);
        newPlayer = PlayableInstance.create(template, _name);
    }

    private void setPlayerName()
    {
        _name = ut.beautifyName(getValidName());
        System.out.println(messages.getMessage("welcomeMessage") + " " + _name);
        System.out.println();
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
                    _classId = 0;
                    System.out.println(messages.getMessage("choosedClass") + " : " + messages.getMessage("mageClass"));
                    break;
                }
                case 2: {
                    player.setClass(new WarriorClass());
                    _classId = 1;
                    System.out.println(messages.getMessage("choosedClass") + " : " + messages.getMessage("warriorClass"));
                    break;
                }
                case 3: {
                    player.setClass(new RogueClass());
                    _classId = 2;
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
