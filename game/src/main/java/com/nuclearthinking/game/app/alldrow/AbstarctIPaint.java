package com.nuclearthinking.game.app.alldrow;

import javafx.event.Event;
import javafx.scene.Node;

/**
 * Created by kuksin-mv on 01.02.2016.
 */
public abstract class AbstarctIPaint implements IPaint
{
    @Override
    public IPaint invoke()
    {
        return this;
    }

    @Override
    public Node getControllBar()
    {
        return null;
    }

    @Override
    public void handle(Event event)
    {

    }
}
