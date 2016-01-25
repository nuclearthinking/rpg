package com.nuclearthinking.game.actions;

import com.nuclearthinking.game.npc.Monster;
import com.nuclearthinking.game.obj.world.World;
import com.nuclearthinking.game.obj.world2.WorldInstance;
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
    WorldInstance worldInstance;
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

    public Actions(Player player, WorldInstance worldInstance, Monster monster) {
        this.player = player;
        this.worldInstance = worldInstance;
        this.monster = monster;
    }

    public Map<String, Action> getAvailableActions() {
        Map<String, Action> actionsList = new HashMap<>();
        //gatherNavigationActions(actionsList);
        getAttackActions(actionsList);
        gatherNavigationActions2(actionsList);
        return actionsList;
    }

    protected void gatherNavigationActions2(Map<String, Action> actionList)
    {
        Map<String, Action> tempActionList = new HashMap<String, Action>();
        int currentRoom = player.getCurrentRoom();
        int currentFloor = player.getCurrentFloor();
        int floors = worldInstance.getFloorSize();

        if (currentRoom > worldInstance.getRoomSize())
        {
            System.out.println("Игра пройдена");
            return;
        }

        if (currentRoom == 1)
        {
            Navigate navigate = new Navigate(player, worldInstance);
            worldInstance.biomOut(worldInstance.jungle, currentRoom);
            navigate.setRoomModification(currentFloor + 1);
            tempActionList.put("Следующая комната", navigate);
        }
        else if (currentRoom == floors)
        {
            Navigate navigateNextFloor = new Navigate(player, worldInstance);
            worldInstance.biomOut(worldInstance.jungle, currentRoom);
            navigateNextFloor.setRoomModification(1);
            navigateNextFloor.setFloorModification(currentFloor + 1);
            tempActionList.put("Следующий этаж", navigateNextFloor);

            Navigate navigatePreviousRoom = new Navigate(player, world);
            navigatePreviousRoom.setRoomModification(currentRoom - 1);
            tempActionList.put("Предыдущая комната", navigatePreviousRoom);
        }
        else
        {
            Navigate navigateNextRoom = new Navigate(player, world);
            worldInstance.biomOut(worldInstance.jungle, currentRoom);
            navigateNextRoom.setRoomModification(currentRoom + 1);
            tempActionList.put("Следующая комната", navigateNextRoom);

            Navigate navigatePreviousRoom = new Navigate(player, world);
            navigatePreviousRoom.setRoomModification(currentRoom - 1);
            tempActionList.put("Предыдущая комната", navigatePreviousRoom);
        }

        actionList.putAll(tempActionList);
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

    protected void getAttackActions(Map<String, Action> actionMap) {
        Map<String, Action> tempActionMap = new HashMap<String, Action>();
        if (player.getCurrentRoom() > worldInstance.getRoomSize())
        {
            return;
        }
        if (!monster.isDead()) {
            Attack attack = new Attack(player, worldInstance, monster);
            tempActionMap.put("Attack", attack);
        }

        actionMap.putAll(tempActionMap);
    }

}

