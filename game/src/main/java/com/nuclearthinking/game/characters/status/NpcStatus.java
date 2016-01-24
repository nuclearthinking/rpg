package com.nuclearthinking.game.characters.status;

import com.nuclearthinking.game.characters.CharacterObject;
import com.nuclearthinking.game.characters.Npc;

/**
 * Created by Izonami on 16.01.2016.
 */
public class NpcStatus extends CharacterStatus {

    public NpcStatus(Npc npc) {
        super(npc);
    }

    @Override
    public void updateHp(double value, CharacterObject attacker) {
        if (getActiveCharacter().isDead()) {
            return;
        }

        super.updateHp(value, attacker);
    }

    @Override
    public Npc getActiveCharacter() {
        return (Npc) super.getActiveCharacter();
    }
}
