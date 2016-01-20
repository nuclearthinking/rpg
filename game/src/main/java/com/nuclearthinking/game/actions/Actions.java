package com.nuclearthinking.game.actions;

import com.nuclearthinking.game.npc.Monster;
import com.nuclearthinking.game.obj.world.World;
import com.nuclearthinking.game.player.Player;

import java.util.HashMap;
import java.util.Map;

/**
 * Date: 15.01.2016
 * Time: 16:13
 *
 * @author Vladislav Radchenko (onifent@gmail.com)
 */

public class Actions {

    Player player;
    World world;
    Monster monster;

    public Actions(Player player, World world, Monster monster) {
        this.player = player;
        this.world = world;
        this.monster = monster;
    }

    public Actions(Player player, World world) {
        this.player = player;
        this.world = world;
    }

    public Map<String, Action> getAvailableActions() {
        Map<String, Action> actionsList = new HashMap<>();
        gatherNavigationActions(actionsList);
        getAttackActions(actionsList);
        return actionsList;
    }

    protected void gatherNavigationActions(Map<String, Action> actionList) {
        Map<String, Action> tempActionList = new HashMap<>();
        int currentRoom = player.getCurrentRoom();
        int currentFloor = player.getCurrentFloor();
        int floorSize = world.getWorldArray().get(currentFloor).getFloorSize();

        if (currentRoom == 1) {
            Navigate navigate = new Navigate(player, world);
            navigate.setRoomModification(player.getCurrentRoom() + 1);
            tempActionList.put("Следующая комната", navigate);
        } else {
            if (currentRoom == floorSize) {

                Navigate navigateNextFloor = new Navigate(player, world);
                navigateNextFloor.setRoomModification(1);
                navigateNextFloor.setFloorModification(player.getCurrentFloor() + 1);
                tempActionList.put("Следующий этаж", navigateNextFloor);

                Navigate navigatePreviousRoom = new Navigate(player, world);
                navigatePreviousRoom.setRoomModification(player.getCurrentRoom() - 1);
                tempActionList.put("Предыдущая комната", navigatePreviousRoom);
            } else {
                Navigate navigateNextRoom = new Navigate(player, world);
                navigateNextRoom.setRoomModification(player.getCurrentRoom() + 1);
                tempActionList.put("Следующая комната", navigateNextRoom);

                Navigate navigatePreviousRoom = new Navigate(player, world);
                navigatePreviousRoom.setRoomModification(player.getCurrentRoom() - 1);
                tempActionList.put("Предыдущая комната", navigatePreviousRoom);
            }
        }
        actionList.putAll(tempActionList);
    }

    protected void getAttackActions(Map<String, Action> actionMap)
    {
        Map<String, Action> tempActionMap = new HashMap<String, Action>();
        if(!monster.isDead())
        {
            Attack attack = new Attack(player, world, monster);
            tempActionMap.put("Attack", attack);
        }

        actionMap.putAll(tempActionMap);
    }
}

