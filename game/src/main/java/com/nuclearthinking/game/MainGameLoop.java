package com.nuclearthinking.game;

import com.nuclearthinking.game.characters.CharacterObject;
import com.nuclearthinking.game.engines.MessagesReader;
import com.nuclearthinking.game.obj.world.World;
import com.nuclearthinking.game.utils.UserInput;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 12.01.2016
 * Time: 14:25
 *
 * @author Vladislav Radchenko (onifent@gmail.com)
 */

public final class MainGameLoop {

    MessagesReader messages = MessagesReader.getInstance();
    UserInput userInput = new UserInput();

    int day = 1;

    public MainGameLoop(CharacterObject characterObject, World world) {
        /**
         * основная петля игры
         */
        int currentFloor;
        int currentRoom;
        int worldSize;
        int floorSize;

        while (true) {
            if (day == 1) {
                System.out.println(messages.getMessage("firstDayWelcomeMessage"));
                characterObject.setCurrentFloor(1);
                characterObject.setCurrentRoom(1);
            } else {
                printCurrentDay();
            }
            currentFloor = characterObject.getCurrentFloor();
            currentRoom = characterObject.getCurrentRoom();
            worldSize = world.getWorldArray().size();
            floorSize = world.getWorldArray().get(currentFloor).getFloorSize();

            //Почистить
            System.out.println("Текущий уровень " + characterObject.getCurrentFloor() + " из " + worldSize);
            System.out.println("Текущая комната " + characterObject.getCurrentRoom() + " из " + floorSize);
            System.out.println();

            List<String> actions;

            if (characterObject.getCurrentRoom() == 1) {
                actions = new ArrayList<String>() {
                    {
                        add("Следующая комната");
                    }
                };

                int input = userInput.chouseOne(actions);
                if (input == 1) {
                    characterObject.setCurrentRoom(currentRoom + 1);
                }
            } else {
                if (characterObject.getCurrentRoom() == floorSize) {
                    {
                        actions = new ArrayList<String>() {
                            {
                                add("Следущий уровень");
                                add("Предыдущая комната");
                            }
                        };
                        int input = userInput.chouseOne(actions);
                        if (input == 1) {
                            characterObject.setCurrentFloor(currentFloor + 1);
                            characterObject.setCurrentRoom(1);
                        } else {
                            if (input == 2) {
                                characterObject.setCurrentRoom(currentRoom - 1);
                            }
                        }
                    }
                } else {

                    actions = new ArrayList<String>() {
                        {
                            add("Следующая комната");
                            add("Предыдущая комната");
                        }
                    };

                    int input = userInput.chouseOne(actions);
                    if (input == 1) {
                        characterObject.setCurrentRoom(currentRoom + 1);
                    } else {
                        if (input == 2) {
                            characterObject.setCurrentRoom(currentRoom - 1);
                        }
                    }
                }
            }

            if (characterObject.getHitPoints() <= 0) {
                System.out.println("Game over!");
                break;
            }
            System.out.println();
            day++;
        }
    }


    public void printCurrentDay() {
        System.out.println(messages.getMessage("day") + ": " + day);
    }
}
