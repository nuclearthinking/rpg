package com.nuclearthinking.game.app.alldrow;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.canvas.GraphicsContext;

/**
 * Created by kuksin-mv on 01.02.2016.
 */
public interface IPaint extends EventHandler<Event>
{
    public void draw(GraphicsContext context);

    public IPaint invoke();

    public Node getControllBar();
}
