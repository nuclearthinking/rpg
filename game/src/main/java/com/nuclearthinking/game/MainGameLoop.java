package com.nuclearthinking.game;

import com.nuclearthinking.game.actions.Action;
import com.nuclearthinking.game.actions.Actions;
import com.nuclearthinking.game.characters.Player;
import com.nuclearthinking.game.engines.MessagesReader;
import com.nuclearthinking.game.obj.world.World;
import com.nuclearthinking.game.utils.UserInput;

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

    public MainGameLoop(Player player, World world) {
        /**
         * основная петля игры
         */
        int currentFloor;
        int worldSize;
        int floorSize;

        while (true) {
            if (day == 1) {
                System.out.println(messages.getMessage("firstDayWelcomeMessage"));
                player.setCurrentFloor(1);
                player.setCurrentRoom(1);
            } else {
                printCurrentDay();
            }
            currentFloor = player.getCurrentFloor();
            worldSize = world.getWorldArray().size();
            floorSize = world.getWorldArray().get(currentFloor).getFloorSize();

            //Почистить
            System.out.println("Текущий уровень " + player.getCurrentFloor() + " из " + worldSize);
            System.out.println("Текущая комната " + player.getCurrentRoom() + " из " + floorSize);
            System.out.println();

            Actions acts = new Actions(player, world);
            Action act = userInput.chouseOneMap(acts.getAviableActions());
            act.run();

            if (player.getHitPoints() <= 0) {
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
