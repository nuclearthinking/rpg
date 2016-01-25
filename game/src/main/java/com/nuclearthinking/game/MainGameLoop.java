package com.nuclearthinking.game;

import com.nuclearthinking.game.actions.Action;
import com.nuclearthinking.game.actions.Actions;
import com.nuclearthinking.game.engines.MessagesReader;
import com.nuclearthinking.game.npc.Monster;
import com.nuclearthinking.game.obj.world2.WorldInstance;
import com.nuclearthinking.game.player.Player;
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
    Monster monster;

    int day = 1;

    public MainGameLoop(Player player, WorldInstance world) {
        /**
         * основная петля игры
         */

        while (true) {
            if (player.getCurrentRoom() > world.getRoomSize())
            {
                System.out.println("Игра пройдена");
                return;
            }
            if (day == 1) {
                System.out.println(messages.getMessage("firstDayWelcomeMessage"));
                player.setCurrentFloor(1);
                player.setCurrentRoom(1);
            } else {
                printCurrentDay();
            }
            System.out.println("Текущий уровень " + player.getCurrentFloor() + " из " + world.getFloorSize());
            System.out.println("Текущая комната " + player.getCurrentRoom() + " из " + world.getRoomSize());
            System.out.println();

            byte lvl = (byte) (player.getCurrentRoom() + player.getCurrentFloor());

            spawn(player, "Monster" + lvl, lvl, world);

            Actions actionsLoader = new Actions(player, world, monster);
            Action selectedAction = userInput.selectActionFromMap(actionsLoader.getAvailableActions());
            selectedAction.run();


            if (player.getHitPoints() <= 0) {
                System.out.println("Game over!");
                break;
            }
            System.out.println();
            day++;
        }
    }

    public void spawn(Player player, String name, byte lvl, WorldInstance worldInstance)
    {
        monster = new Monster(name, lvl);
        //TODO: Хардкод
        worldInstance.jungle.setCellValue("☻");
        System.out.println(player.getExp() + " " + player.getLevel());
    }


    public void printCurrentDay() {
        System.out.println(messages.getMessage("day") + ": " + day);
    }
}
