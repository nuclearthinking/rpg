package com.nuclearthinking.game.engines;


import com.nuclearthinking.game.characters.CharacterObject;
import com.nuclearthinking.game.characters.MageClass;
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
    private CharacterObject characterObject = null;
    private PlayableInstance newPlayer = null;
    private PlayerTemplate template = null;
    private MessagesReader messages = MessagesReader.getInstance();
    String _name;
    int _classId;

    public PreparePlayer() {
        characterObject = new CharacterObject() {
            @Override
            public int getId() {
                return 0;
            }
        };
        //Установка имени игроку если оно null
        setPlayerName();
        //Установка класса игроку если он null
        choosePlayerClass();
        template = PlayerTemplateData.getInstance().getTemplate(_classId);
        newPlayer = PlayableInstance.create(template, _name);
    }

    private void setPlayerName() {
        _name = ut.beautifyName(getValidName());
        System.out.println(messages.getMessage("welcomeMessage") + " " + _name);
        System.out.println();
    }

    private void choosePlayerClass() {
        if (characterObject.getpClass() == null) {

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
                    characterObject.setClass(new MageClass());
                    _classId = 1;
                    System.out.println(messages.getMessage("choosedClass") + " : " + messages.getMessage("mageClass"));
                    break;
                }
                case 2: {
                    characterObject.setClass(new WarriorClass());
                    _classId = 0;
                    System.out.println(messages.getMessage("choosedClass") + " : " + messages.getMessage("warriorClass"));
                    break;
                }
                case 3: {
                    characterObject.setClass(new RogueClass());
                    _classId = 2;
                    System.out.println(messages.getMessage("choosedClass") + " : " + messages.getMessage("rogueClass"));
                    break;
                }
            }
            System.out.println();
        }
    }


    public CharacterObject getCharacterObject() {
        return characterObject;
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
