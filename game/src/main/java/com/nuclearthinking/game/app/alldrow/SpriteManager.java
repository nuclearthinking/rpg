package com.nuclearthinking.game.app.alldrow;

import javafx.scene.layout.Pane;

import java.util.*;

/**
 * Created by kuksin-mv on 04.02.2016.
 */
public class SpriteManager
{
    private final static List<Pane> GAME_ACTORS = new ArrayList<Pane>();
    private final static List<Pane> CHECK_COLLISION_LIST = new ArrayList<Pane>();
    private final static Set<Pane> CLEAN_UP_SPRITES = new HashSet<Pane>();

    public List<Pane>  getAllSprites()
    {
        return GAME_ACTORS;
    }

    public void addSprites(Pane... sprites)
    {
        GAME_ACTORS.addAll(Arrays.asList(sprites));
    }

    public void removeSprites(Pane... sprites)
    {
        GAME_ACTORS.removeAll(Arrays.asList(sprites));
    }

    public Set<Pane> getSpritesToBeRemoved()
    {
        return CLEAN_UP_SPRITES;
    }

    public void addSpritesToBeRemoved(Pane... sprites)
    {
        if (sprites.length > 1)
        {
            CLEAN_UP_SPRITES.addAll(Arrays.asList((Pane[]) sprites));
        }
        else
        {
            CLEAN_UP_SPRITES.add(sprites[0]);
        }
    }

    public List<Pane> getCollisionsToCheck()
    {
        return CHECK_COLLISION_LIST;
    }

    public void resetCollisionsToCheck()
    {
        CHECK_COLLISION_LIST.clear();
        CHECK_COLLISION_LIST.addAll(GAME_ACTORS);
    }

    public void cleanupSprites()
    {
        GAME_ACTORS.removeAll(CLEAN_UP_SPRITES);
        CLEAN_UP_SPRITES.clear();
    }

}
