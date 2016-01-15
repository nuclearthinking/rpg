package com.nuclearthinking.game.actions;

import com.nuclearthinking.game.characters.Player;
import com.nuclearthinking.game.obj.world.World;
import com.nuclearthinking.game.utils.UserInput;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Date: 15.01.2016
 * Time: 16:13
 *
 * @author Vladislav Radchenko (onifent@gmail.com)
 */

public class Actions {

    UserInput userInput = new UserInput();
    Player player;
    World world;

    public Actions(Player player, World world) {
        this.player = player;
        this.world = world;
    }

    public Map<String, Action> getAviableActions() {
        Map<String, Action> actionsList = new HashMap<String, Action>();


        return actionsList;
    }

    protected void gatherNavigationActions(Map<String, Action> actionList) {
        Map<String, Action> tempActionList = new HashMap<String, Action>();
        int currentRoom = player.getCurrentRoom();
        int currentFloor = player.getCurrentFloor();
        int worldSize = world.getWorldArray().size();
        int floorSize = world.getWorldArray().get(currentFloor).getFloorSize();

        if (player.getCurrentRoom() == 1) {
            //Комната первая на этаже: действте комната +1
        } else {
            if (player.getCurrentRoom() == floorSize) {
                //Комната последняя на этаже : действие комната -1 или этаж +1
            } else {
                //Комната по середине этажа : действие комната +1 или комната -1
            }
        }


    }


}

