package com.nuclearthinking.game.actions;

import com.nuclearthinking.game.characters.Player;
import com.nuclearthinking.game.obj.world.World;

/**
 * Date: 15.01.2016
 * Time: 16:30
 *
 * @author Vladislav Radchenko (onifent@gmail.com)
 */

public class Navigate extends Action implements Actable {

    private int roomModificator;
    private int floorModificator;

    Navigate(Player player, World world) {
        super(player, world);
    }

    public void setRoomModificator(int roomModificator) {
        this.roomModificator = roomModificator;
    }

    public void setFloorModificator(int floorModificator) {
        this.floorModificator = floorModificator;
    }

    @Override
    public void run() {
        player.setCurrentRoom(roomModificator);
        player.setCurrentFloor(floorModificator);
    }
}
