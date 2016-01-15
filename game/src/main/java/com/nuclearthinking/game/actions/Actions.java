package com.nuclearthinking.game.actions;

import com.nuclearthinking.game.characters.Player;
import com.nuclearthinking.game.obj.world.World;

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


    }


}

