package com.nuclearthinking.game.actions;

import com.nuclearthinking.game.obj.world.World;
import com.nuclearthinking.game.obj.world.WorldManager;
import com.nuclearthinking.game.player.Player;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

/**
 * Date: 17.01.2016
 * Time: 11:28
 *
 * @author Vladislav Radchenko (onfient@gmail.com)
 */
public class ActionsTest {

    @Test
    public void testGetAvailableActionsStartPoint() throws Exception {
        Player player = new Player();
        player.setCurrentFloor(1);
        player.setCurrentRoom(1);
        World world = new WorldManager(30).getWorld();
        Actions acts = new Actions(player, world);
        Map<String, Action> actionsMap = acts.getAvailableActions();
        Assert.assertEquals(actionsMap.size(), 1);
        Action action = actionsMap.get("Следующая комната");
        action.run();
        Assert.assertEquals(player.getCurrentRoom(), 2);

    }

    @Test
    public void testGatherNavigationActions() throws Exception {

    }
}