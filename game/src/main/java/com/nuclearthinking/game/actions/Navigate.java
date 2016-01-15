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

    private int move;

    Navigate(Player player, World world) {
        super(player, world);
    }


    public void setMove(int move) {
        this.move = move;
    }


    @Override
    public void run() {
        if (move > 0) {
            //Если эта комната последняя
            if (player.getCurrentRoom() == world.getWorldArray().get(player.getCurrentFloor()).getFloorSize()) {
                player.setCurrentFloor(player.getCurrentFloor() + 1);
                player.setCurrentRoom(1);
            } else {
                //Если эта комната первая
                if (player.getCurrentRoom() == 1) {
                }
            }
        }
    }
}
