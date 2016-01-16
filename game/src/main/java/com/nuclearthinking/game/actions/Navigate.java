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

    private int roomModification;
    private int floorModification;

    Navigate(Player player, World world) {
        super(player, world);
    }

    public void setRoomModification(int roomModification) {
        this.roomModification = roomModification;
    }

    public void setFloorModification(int floorModification) {
        this.floorModification = floorModification;
    }

    @Override
    public void run() {
        if (roomModification != 0) {
            player.setCurrentRoom(roomModification);
        }
        if (floorModification != 0) {
            player.setCurrentFloor(floorModification);
        }
    }
}
