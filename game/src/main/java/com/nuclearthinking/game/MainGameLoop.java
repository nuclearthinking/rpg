package com.nuclearthinking.game;

import com.nuclearthinking.game.actions.Action;
import com.nuclearthinking.game.actions.Actions;
import com.nuclearthinking.game.engines.MessagesReader;
import com.nuclearthinking.game.npc.Monster;
import com.nuclearthinking.game.obj.world.World;
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

    public MainGameLoop(Player player, World world) {
        /**
         * основная петля игры
         */

        while (true) {
            if (day == 1) {
                System.out.println(messages.getMessage("firstDayWelcomeMessage"));
                player.setCurrentFloor(1);
                player.setCurrentRoom(1);
            } else {
                printCurrentDay();
            }
            System.out.println("Текущий уровень " + player.getCurrentFloor() + " из " + world.getWorldArray().size());
            System.out.println("Текущая комната " + player.getCurrentRoom() + " из " + world.getWorldArray().get(player.getCurrentFloor()).getFloorSize());
            System.out.println();

            Actions actionsLoader = new Actions(player, world);
            Action selectedAction = userInput.selectActionFromMap(actionsLoader.getAvailableActions());
            selectedAction.run();

            byte lvl = (byte)(player.getCurrentRoom() + player.getCurrentFloor());

            spawn(player, "Monster" + lvl, lvl);
           
            if (player.getHitPoints() <= 0) {
                System.out.println("Game over!");
                break;
            }
            System.out.println();
            day++;
        }
    }

    public void spawn(Player player, String name, byte lvl)
    {
        monster = new Monster(name, lvl);

        System.out.println(player.getName() + " " + player.getHitPoints() + " " + player.getpClass() + " " + player.getPDef());
        System.out.println(monster.getName() + " " + monster.getLevel() + " " + monster.getHitPoints());
        player.addDmg(monster, true);
        System.out.println(monster.getName() + " " + monster.getLevel() + " " + monster.getHitPoints());
    }


    public void printCurrentDay() {
        System.out.println(messages.getMessage("day") + ": " + day);
    }
}
