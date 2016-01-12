package com.nuclearthinking.game;

import com.nuclearthinking.game.engines.MessagesReader;
import com.nuclearthinking.game.obj.Player;
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

public class MainGameLoop {

    MessagesReader messages = MessagesReader.getInstance();
    UserInput userInput = new UserInput();

    int day = 1;

    public MainGameLoop(Player player, World world) {
        /**
         * основная петля игры
         */
        int currentFloor = player.getCurrentFloor();
        int currentRoom = player.getCurrentRoom();
        int worldSize = world.getWorldArray().size();
        int floorSize = world.getWorldArray().get(currentFloor).getFloorMap().length;

        while (true) {
            if (day == 1) {
                System.out.println(messages.getMessage("firstDayWelcomeMessage"));
                player.setCurrentFloor(1);
                player.setCurrentRoom(1);
            } else {
                printCurrentDay();
            }
            //Почистить
            System.out.println("Текущий уровень " + player.getCurrentFloor());
            System.out.println("Текущая комната " + player.getCurrentRoom());


            List<String> actions;

            if (player.getCurrentRoom() == 1) {
                actions = new ArrayList<String>() {
                    {
                        add("Следующая комната");
                    }
                };

                int input = userInput.chouseOne(actions);
                if (input == 1) {
                    player.setCurrentRoom(currentRoom + 1);
                }
            } else {
                if (player.getCurrentRoom() == floorSize) {
                    {
                        actions = new ArrayList<String>() {
                            {
                                add("Следущий уровень");
                                add("Предыдущая комната");
                            }
                        };
                        int input = userInput.chouseOne(actions);
                        if (input == 1) {
                            player.setCurrentFloor(currentFloor + 1);
                            player.setCurrentRoom(1);
                        } else {
                            if (input == 2) {
                                player.setCurrentRoom(currentRoom - 1);
                            }
                        }
                    }
                }
            }


            if (player.getHitPoints() <= 0) {
                System.out.println("Game over!");
                break;
            }

        }

    }


    public void printCurrentDay() {
        System.out.println(messages.getMessage("day") + ": " + day);
    }
}
