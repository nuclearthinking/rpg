package com.nuclearthinking.game.characters.status;

import com.nuclearthinking.game.characters.PlayableObject;

/**
 * Created by Izonami on 17.01.2016.
 */
public class PlayableStatus extends CharacterStatus {
    public PlayableStatus(PlayableObject activeCharacter) {
        super(activeCharacter);
    }

    @Override
    public PlayableObject getActiveCharacter() {
        return (PlayableObject) super.getActiveCharacter();
    }
}
