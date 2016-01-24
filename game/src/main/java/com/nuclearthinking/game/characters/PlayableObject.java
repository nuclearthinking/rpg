package com.nuclearthinking.game.characters;

import com.nuclearthinking.game.characters.stats.PlayableStat;
import com.nuclearthinking.game.characters.status.PlayableStatus;
import com.nuclearthinking.game.characters.templates.CharacterTemplate;

/**
 * Created by kuksin-mv on 15.01.2016.
 */
public class PlayableObject extends CharacterObject {
    public PlayableObject(int objectId, CharacterTemplate template) {
        super(objectId, template);
    }

    @Override
    public PlayableStat getStat() {
        return (PlayableStat) super.getStat();
    }

    @Override
    public void initCharacterStat() {
        setStat(new PlayableStat(this));
    }

    @Override
    public PlayableStatus getStatus() {
        return (PlayableStatus) super.getStatus();
    }

    @Override
    public void initCharacterStatus() {
        setStatus(new PlayableStatus(this));
    }

    @Override
    public boolean canBeAttacked() {
        return true;
    }

    @Override
    public boolean isPlayable() {
        return true;
    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public boolean fillDie(CharacterObject killer) {
        if (isDead()) {
            return false;
        }
        // now reset currentHp to zero
        setIsDead(true);

        return true;
    }
}
