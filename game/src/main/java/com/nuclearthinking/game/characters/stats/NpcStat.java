package com.nuclearthinking.game.characters.stats;

import com.nuclearthinking.game.characters.Npc;

/**
 * Created by kuksin-mv on 15.01.2016.
 */
public class NpcStat extends CharacterStat {
    public NpcStat(Npc activeNpc) {
        super(activeNpc);
    }

    @Override
    public byte getLevel() {
        return getActiveChar().getTemplate().getLevel();
    }

    @Override
    public Npc getActiveChar() {
        return (Npc) super.getActiveChar();
    }
}
