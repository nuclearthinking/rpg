package com.nuclearthinking.game.actions;

import com.nuclearthinking.game.npc.Monster;
import com.nuclearthinking.game.obj.world.World;
import com.nuclearthinking.game.player.Player;

public class Attack extends Action implements Actable {

    protected Attack(Player player, World world, Monster monster) {
        super(player, world, monster);
    }

    @Override
    public void run() {
        player.addDmg(monster);
    }
}
